package model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.dto.Member;

public class SoloApp {
	private Scanner sc = new Scanner(System.in);

	// 참가자를 저장할 ArrayList 생성
	List<Member> memberList = new ArrayList<>();
	
	// 투표한 참가자를 저장할 ArrayList 생성
	List<String> votedMember = new ArrayList<>();
	
	// 호감도 저장할 Map 생성 (key -> 본인 이름, value -> 새로운 Map (key -> 상대 이름, value -> 호감도))
	Map<String, Map<String, Integer>> likeMap = new HashMap<>();

	// 투표 횟수 저장 변수
	int voteCount = 0;

	public SoloApp() {
		memberList.add(new Member("광수", 30, "마케터", "인천", 'M', addHobby("농구")));
		memberList.add(new Member("상철", 33, "디자이너", "서울", 'M', addHobby("사진", "전시회")));
		memberList.add(new Member("순자", 28, "바이올리니스트", "대전", 'F', addHobby("클래식", "산책")));
		memberList.add(new Member("영수", 31, "회계사", "부산", 'M', addHobby("러닝", "보드게임")));
		memberList.add(new Member("영숙", 33, "연구원", "수원", 'F', addHobby("요가", "카페투어")));
		memberList.add(new Member("영철", 34, "개발자", "서울", 'M', addHobby("등산", "볼링")));
		memberList.add(new Member("정숙", 30, "교사", "부산", 'F', addHobby("독서", "요리")));
		memberList.add(new Member("현숙", 34, "개발자", "서울", 'F', addHobby("코딩", "러닝")));
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
				voteInitial();
				break;
			case 3:
				/* applyDate(); */ break;
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
		for (Member member : memberList) {
			System.out.println(member.toString());
		}
	}

	// 이름으로 memberList에서 Member 객체 가져오는 보조 메서드
	public Member getMemberByName(String name) {
		for (Member member : memberList) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}

	public void voteInitial() {
		System.out.print("내 이름 : ");
		String myName = sc.next();
		
		if(votedMember.contains(myName)) {
			System.out.println("이미 첫인상 투표를 했습니다. (1회만 가능)");
			return;
		} else {
			while (true) {
				System.out.print("투표할 이성 이름 : ");
				String voteName = sc.next();

				// memberList에 존재하지 않는 이름일 경우
				if (getMemberByName(voteName) == null) {
					System.out.println("해당 이름의 참가자가 없습니다. 다시 입력해주세요.");
					continue;
				}

				// 동일인일 경우
				if (myName.equals(voteName)) {
					System.out.println("자기자신에게는 투표할 수 없습니다. 다시 입력해주세요.");
					continue;
				}

				// 동성일 경우
				if (getMemberByName(myName).getGender() == getMemberByName(voteName).getGender()) {
					System.out.println("동성에게는 투표할 수 없습니다. 다시 입력해주세요.");
					continue;
				}

				// 호감도 (from -> to : +1)

				// 예외에서 걸리지 않을 경우
				System.out.printf("<첫인상 투표 완료 : %s -> %s (+1점)>\n", myName, voteName);
				// 투표 완료 명단에 추가 (1회만 가능)
				votedMember.add(myName);
				break;
			}
		}
	}
	
}
