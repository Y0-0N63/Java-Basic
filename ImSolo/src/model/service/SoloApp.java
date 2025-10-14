package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.dto.DatePlan;
import model.dto.Member;

public class SoloApp {
	private Scanner sc = new Scanner(System.in);

	// 참가자를 저장할 ArrayList 생성
	List<Member> members = new ArrayList<>();

	// 투표한 참가자를 저장할 ArrayList 생성
	List<String> votedMember = new ArrayList<>();
	int voteCount = 0; // 투표 횟수 저장 변수

	// 호감도 저장할 Map 생성 (key -> 본인 이름, value -> 새로운 Map (key -> 상대 이름, value -> 호감도))
	Map<String, Map<String, Integer>> likeMap = new HashMap<>();	
	int like = 0; // 호감도 저장할 변수
	
	// 데이트 일정 저장할 Map 생성
	List<DatePlan> datePlans = new ArrayList<>();

	public SoloApp() {
		members.add(new Member("광수", 30, "마케터", "인천", 'M', addHobby("농구")));
		members.add(new Member("상철", 33, "디자이너", "서울", 'M', addHobby("사진", "전시회")));
		members.add(new Member("순자", 28, "바이올리니스트", "대전", 'F', addHobby("클래식", "산책")));
		members.add(new Member("영수", 31, "회계사", "부산", 'M', addHobby("러닝", "보드게임")));
		members.add(new Member("영숙", 33, "연구원", "수원", 'F', addHobby("요가", "카페투어")));
		members.add(new Member("영철", 34, "개발자", "서울", 'M', addHobby("등산", "볼링")));
		members.add(new Member("정숙", 30, "교사", "부산", 'F', addHobby("독서", "요리")));
		members.add(new Member("현숙", 34, "개발자", "서울", 'F', addHobby("코딩", "러닝")));
	}

	// 전달받은 취미를 list에 저장해 반환
	private List<String> addHobby(String... hobby) {
		// 저장할 list 생성
		List<String> hobbyList = new ArrayList<>();

		for (String i : hobby) {
			hobbyList.add(i);
		}

		return hobbyList;
	}

	public void displayMenu() {
		int menuNum = 0;

		do {
			System.out.println("\n===== 나는 SOLO 미니 =====");
			System.out.println("1. 전체 참가자 조회");
			System.out.println("2. 첫인상 투표");
			System.out.println("3. 데이트 신청");
			System.out.println("4. 모든 참가자별 호감도 조회");
			System.out.println("5. 마지막 선택");
			System.out.println("0. 종료");
			System.out.print(">> ");
			menuNum = sc.nextInt();

			switch (menuNum) {
			case 1:
				showApplicants();
				break;
			case 2:
				System.out.println(voteInitial());
				break;
			case 3:
				applyDate();
				break;
			case 4:
				/* showLike(); */ break;
			case 5:
				/* lastChoice(); */ break;
			case 0:
				System.out.println("프로그램이 종료됩니다...");
				break;
			default:
				System.out.println("메뉴에 있는 값만 입력해주세요.");
			}
		} while (menuNum != 0);
	}

	public void showApplicants() {
		// memberList 출력
		for (Member member : members) {
			System.out.println(member.toString());
		}
	}

	// 이름으로 memberList에서 Member 객체 가져오는 보조 메서드
	public Member getMemberByName(String name) {
		for (Member member : members) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	/**
	 * 첫인상 투표 - 입력 : 내가 누구인지(이름) - 제한 : 이성 멤버 중 한 명에게만, 투표 1회 한정 - 효과 : from -> to
	 * :호감도 +1 - 예외 : 없는 이름/동일인/동성 선택 시 안내 후 재입력
	 */
	public String voteInitial() {
		System.out.print("내 이름 : ");
		String myName = sc.next();

		if (votedMember.contains(myName)) {
			return "이미 첫인상 투표를 했습니다. (1회만 가능)";
		} else {

			System.out.print("투표할 이성 이름 : ");
			String voteName = sc.next();

			// memberList에 존재하지 않는 이름일 경우
			if (getMemberByName(voteName) == null) {
				return "해당 이름의 참가자가 없습니다. 다시 입력해주세요.";
			}

			// 동일인일 경우
			if (myName.equals(voteName)) {
				return "자기자신에게는 투표할 수 없습니다. 다시 입력해주세요.";
			}

			// 동성일 경우
			if (getMemberByName(myName).getGender() == getMemberByName(voteName).getGender()) {
				return "동성에게는 투표할 수 없습니다. 다시 입력해주세요.";
			}

			// 존재하지 않는 참가자인 경우
			boolean flag = false;
			for (Member member : members) {
				if (member.getName().equals(voteName)) {
					// 참가자가 존재할 경우 > true로 바꿔줌
					flag = true;
					break;
				}
			}

			// flag가 false == memberList에서 찾을 수 없음
			if (!flag) {
				return "존재하지 않는 참가자입니다 : " + voteName;
			}

			// 호감도 (from -> to : +1)
			// 상대 이름(key), 호감도(value) 저장하는 map 만들어주기
			Map<String, Integer> innerMap = new HashMap<>();
			
			// innerMap에 상대 이름, 호감도(+1) 저장
			innerMap.put(voteName, ++like);
			
			// likeMap에 연결해주기 > key : 내 이름, value : innerMap
			likeMap.put(myName, innerMap);

			// 투표 완료 명단에 추가 (1회만 가능)
			votedMember.add(myName);
			
			// 예외에서 걸리지 않을 경우
			return String.format("<첫인상 투표 완료 : %s -> %s (+1점)>", myName, voteName);
		}
	}

	/**
	 * 데이트 신청 - 입력 : 내가 누구인지(이름), 상대 이름, 날짜(YYYYMMDD) - 제한 : 이성 1명에게만 신청 (횟수, 날짜
	 * 무제한) - 효과 : from -> to : 호감도 +2 - 다대일 알림 : 같은 날짜에 > 같은 사람 2명 이상이 신청 > "다대일
	 * 데이트" : 다대일 데이트네요! YYYYMMDD, 대상: OO ← 신청자: A, B, ...
	 */
	public void applyDate() {
		System.out.print("내 이름 : ");
		String myName = sc.next();

		System.out.print("신청할 이성 이름 : ");
		String patnerName = sc.next();

		// 자기 자신에게 신청한 경우
		if (myName.equals(patnerName)) {
			System.out.println("자기 자신에게는 신청할 수 없습니다.");
			return;
		}

		// 동성에게 신청한 경우
		if (getMemberByName(myName).getGender() == getMemberByName(patnerName).getGender()) {
			System.out.println("데이트 신청은 이성에게만 가능합니다.");
			return;
		}

		// 날짜 입력
		System.out.print("날짜(YYYYMMDD) : ");
		String date = sc.next();
		// 입력된 날짜가 8자리 미만일 경우
		if (date.length() < 8) {
			System.out.println("날짜 형식이 올바르지 않습니다. 예 : 20241013");
			return;
		}
		
		// 정상 입력 > datePlans에 저장
		datePlans.add(new DatePlan(myName, patnerName, date));

		// 같은 날짜에 여러 명이 한 명에게 데이트 신청했을 때
		for(DatePlan p1 : datePlans) {
			// 같은 날짜가 존재하는지 확인하기
			boolean sameDate = false;
			String plan1 = p1.getDate();
			
			for(DatePlan p2 : datePlans) {
				String plan2 = p2.getDate();
				if(plan1.equals(plan2)) {
					sameDate = true;
				}
			}
			
			// 같은 날짜가 존재한다면
			if(sameDate) {
				// 데이트 수신자가 동일인인지 확인하기
				for(DatePlan p3 : datePlans) {
					boolean sameReceiver = false;
					String receiver1 = p3.getReceiver();
					
					for(DatePlan p4 : datePlans) {
						String receiver2 = p4.getReceiver();
						if(receiver1.equals(receiver2)) {
							sameReceiver = true;
						}
					}
					// 같은 날짜에 동일한 수신인이 존재한다면
					if(sameReceiver) {
						System.out.println("다대일 데이트네요! YYYYMMDD, 대상: OO ← 신청자: A, B, ... ");
					}
				}
				
			}
		}

		// 호감도 올려주기 (+2)
		Map<String, Integer> likeInnerMap = new HashMap<>();
		likeInnerMap.put(patnerName, (like + 2));
		likeMap.put(myName, likeInnerMap);
		
	}
}
