package edu.kh.oarr.model.service;

import java.util.Scanner;

import edu.kh.oarr.model.vo.Member;

public class MemberService {
	// 속성
	private Scanner sc = new Scanner(System.in);

	// 회원가입한 사람의 정보를 저장해둘 참조 변수
	// Member 5칸짜리 객체 배열 선언 및 할당
	private Member[] memberArr = new Member[5];

	// 현재 로그인한 회원의 정보를 저장할 참조 변수 선언
	private Member loginMember = null;

	// 기능
	public MemberService() {
		// memberArr 배열 0, 1, 2 인덱스 초기화
		memberArr[0] = new Member("user01", "pass01", "홍길동", 30, "서울");
		memberArr[1] = new Member("user02", "pass02", "계보린", 25, "경기");
		memberArr[2] = new Member("user03", "pass03", "고길동", 45, "강원");
	}

	// 메뉴 출력용 메서드
	public void displayMenu() {
		int menuNum = 0;

		// 무조건 한 번은 반복할 수 있게 >> do-while
		// menuNum이 0 >> 반복 종료
		do {
			System.out.println("\n==회원 관리 프로그램 v2==");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 검색(지역)");
			System.out.println("0. 프로그램 종료");

			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();
			sc.nextLine();

			switch (menuNum) {
			case 1:
				System.out.println(signUp());
				break;
			case 2:
				System.out.println(login());
				break;
			case 3:
				System.out.println(selectMember());
				break;
			case 4:
				int result = updateMember();
				if (result == -1) {
					System.out.println("로그인 후 이용 바람");
				} else if (result == 0) {
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				} else {
					System.out.println("회원 정보가 수정되었습니다! :)");
				}
				break;
			case 5:
				searchRegion();
				break;
			case 0:
				System.out.println("프로그램 종료...");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴에 있는 번호만 선택하세요!");
			}
		} while (menuNum != 0);
	}

	// side(helper) method : main 기능은 아니나, 다른 메서드에 도움이 되는 메서드
	// memberArr의 비어있는 인덱스 번호 반환하는 역할, 비어있는 인덱스 없으면 -1 반환
	public int emptyIndex() {
		for (int i = 0; i < memberArr.length; i++) {
			// 현재 인덱스에 있는 요소가 참조하는 값이 null == 비어있음! >> 인덱스 반환
			if (memberArr[i] == null) {
				// return : 현재 메서드 종료 > 호출한 곳으로 i 값을 가지고 되돌아감
				return i;
			}
		}
		// for문 수행 이후, index 값이 return되지 않을 경우
		return -1;
	}

	public String signUp() {
		System.out.println("\n=======회원 가입=======");

		// 객체 배열 memberArr에 새로 가입할 회원의 정보를 저장할 예정
		// > if) memberArr 배열에 빈 자리 있는지 확인부터
		// > 빈 공간의 인덱스 번호 얻어오기
		// > else) -1 반환 (emptyIndex())
		int index = emptyIndex();
		if (index == -1) { // 비어있는 공간 X -> 회원가입 불가
			return "회원가입 불가능 (인원 수 초과)";
		}

		// 회원 가입 가능일 때
		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		System.out.print("비밀번호 확인 : ");
		String memberPwCheck = sc.next();

		System.out.print("이름 : ");
		String memberName = sc.next();

		System.out.print("나이 : ");
		int memberAge = sc.nextInt();

		System.out.print("지역 : ");
		String region = sc.next();

		// 비밀번호 == 비밀번호 확인 >> 회원가입 진행, else >> 회원가입 실패
		if (memberPw.equals(memberPwCheck)) {
			// 새로운 Member 객체 생성 > 할당된 주소를 memberArr의 비어있는 index에 대입
			memberArr[index] = new Member(memberId, memberPw, memberName, memberAge, region);
			return "회원 가입 성공!";
		} else {
			return "회원 가입 실패! (비밀번호 불일치)";
		}
	}

	public String login() {
		System.out.println("\n=======로그인=======");

		// 1. id, pw 입력받기
		System.out.print("아이디 : ");
		String memberId = sc.next();

		System.out.print("비밀번호 : ");
		String memberPw = sc.next();

		// 2-1. memberArr 배열 내 요소 순서대로 접근 > 현재 접근한 요소 != null 확인
		for (int i = 0; i < memberArr.length; i++) {
			if (memberArr[i] != null) {
				// 2-2. 회원 정보 존재 > 회원 정보의 id, pw == 입력받은 id, pw?
				if (memberArr[i].getMemberId().equals(memberId) && memberArr[i].getMemberPw().equals(memberPw)) {
					// 2-3. 로그인 회원 정보 객체를 참조할 변수 loginMember에
					// 현재 접근 중인 memberArr[i] 요소에 저장된 주소를 얕은 복사시킴
					loginMember = memberArr[i];
					break; // 더이상 같은 id, pw 존재하지 않을 것이라 예상됨 >> 효율 위해 for문 종료
				}
			}
		}

		// 3. 로그인 성공 or 실패 > "-님 환영합니다!" or "아이디 또는 비밀번호가 일치하지 않습니다"
		if (loginMember == null) {
			return "아이디 또는 비밀번호가 일치하지 않습니다.";
		} else {
			return loginMember.getMemberName() + "님 환영합니다!";
		}
	}

	public String selectMember() {
		System.out.println("\n=======회원 정보 조회=======");
		if (loginMember == null) {
			return "로그인 후 이용 바람";
		}

		String str = "";
		str += "이름 : " + loginMember.getMemberName() + "\n";
		str += "아이디 : " + loginMember.getMemberId() + "\n";
		str += "나이 : " + loginMember.getMemberAge() + "\n";
		str += "지역 : " + loginMember.getRegion();

		return str;
	}

	public int updateMember() {
		System.out.println("\n=======회원 정보 수정=======");
		if (loginMember != null) {
			System.out.print("수정할 이름 입력 : ");
			String updateName = sc.next();

			System.out.print("수정할 나이 입력 : ");
			int updateAge = sc.nextInt();

			System.out.print("수정할 지역 입력 : ");
			String updateRegion = sc.next();

			System.out.print("비밀번호 입력 : ");
			String pwCheck = sc.next();

			if (loginMember.getMemberPw().equals(pwCheck)) {
				loginMember.setMemberName(updateName);
				loginMember.setMemberAge(updateAge);
				loginMember.setRegion(updateRegion);
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

	public void searchRegion() {
		System.out.println("\n=======회원 검색(지역)=======");
		System.out.print("검색할 지역을 입력하세요 : ");
		String inputRegion = sc.next();

		// 1. memberArr 배열의 모든 요소 순차 접근
		boolean flag = true; // 검색 결과 신호용 변수

		for (int i = 0; i < memberArr.length; i++) {
			// 2. memberArr[i] 요소가 null인 경우 반복 종료
			if (memberArr[i] == null) {
				break;
			}
			// 3. memberArr[i] 요소가 null이 아님 > memberArr[i]요소에 저장된 지역(region)이
			// 같을 경우 >> memgerArr[i] 요소에 저장된 객체의 id, 이름 출력
			if (memberArr[i].getRegion().equals(inputRegion)) {
				System.out.printf("아이디 : %s, 이름 : %s\n", memberArr[i].getMemberId(), memberArr[i].getMemberName());
				flag = false; // 찾음
			}
		}
		// 4. 입력한 지역과 일치하는 회원이 없자면 > "일치하는 검색 결과가 없습니다!"
		if (flag) {
			System.out.println("일치하는 검색 결과가 없습니다!");
		}
	}
}