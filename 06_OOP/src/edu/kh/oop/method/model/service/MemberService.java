package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.cls.model.vo.Member;

public class MemberService {
	// 속성 (필드)
	private Scanner sc = new Scanner(System.in);
	
	// 가입한 회원의 정보를 저장할 변수 
	private Member memberInfo = null;
	
	// 로그인한 회원의 정보를 저장할 변수
	private Member loginMember = null;
	
	// 기능 (생성자, 메서드)
	// 메뉴 화면 출력 가능
	public void displayMenu() {
		int menuNum = 0;
		
		// 무조건 한 번은 수행하는 >> do-while문으로 작성해야 함
		do {
			System.out.println("=====회원 정보 관리 프로그램=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 입력 : ");
			menuNum = sc.nextInt();	
			sc.nextLine(); // 입력 버퍼에 있는 개행 문자 제거
			
			switch (menuNum){
			// signUp() 과 같이 메소드가 반환하는 값을 console 창에 출력하기 위해 syso 작성
			// **내가 호출한 메서드가 return하는 값 잘 생각하기**
				case 1 : System.out.println(signUp()); break;
				case 2 : System.out.println(login()); break;
				case 3 : System.out.println(selectMember()); break;
				case 4 : int result = updateMember();
					if(result == -1) {
						System.out.println("로그인 후 이용 바람");
					} else if(result == 0) {
						System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
					} else {
						System.out.println("회원 정보가 수정되었습니다!");
					}
				break;
						
				case 0 : System.out.println("프로그램 종료..."); break;
				default : System.out.println("메뉴에 있는 번호만 입력하세요!");
			}
		}
		// menuNum이 0이 되면 반복 종료
		while(menuNum != 0);
	}

	// 메서드 정의 > 수행을 위해 "호출" 필수
	public String signUp() {
			System.out.println("\n*****회원가입*****");

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
			
			// if) 비밀번호 == 비밀번호 확인 >> 회원가입 진행, else) != >> 회원가입 실패
			if(memberPw.equals(memberPwCheck)) {
				// 회원 가입 == 새로운 회원 객체 생성
				// == Member 클래스 이용해 새로운 객체 생성 >> 매개변수 생성자 이용
				// 회원가입한 정보를 가진 객체의 주소값을 memberInfo 필드변수에 참조시킴
				memberInfo = new Member(memberId, memberPw, memberName, memberAge);
				
				return "회원가입 성공!!";
			} else {
				return "회원 가입 실패!! (비밀번호 불일치)";
			}
	}

	public String login() {
		// 회원가입 되어있는 사람이 있는지 검사 >> 입력한 id/pwd로 가입된 정보 유무 확인
		System.out.println("\n*****로그인*****");
		
		// 회원가입 했는지 확인 == memberInfo가 객체를 참조하고 있는지 확인
		// == null 유무 확인 >> null : 회원가입을 하지 않은 경우
		if(memberInfo == null) {
			// return : **현재 메서드 종료**, 값과 함께 해당 메서드를 호출한 위치로 돌아감
			return "회원가입부터 진행해주세요!";
		}
		
		// 회원가입했다면 > 이곳에 도달해 > 로그인 기능 수행해야
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		// 회원 가입 정보(memberInfo가 참조하는 객체 Member)에 저장된 id, pw가
		// 동일 >> "로그인 성공" else 불일치 >> "아이디 또는 비밀번호 불일치" 리턴
		
		if(memberId.equals(memberInfo.getMemberId()) && memberPw.equals(memberInfo.getMemberPw())) {
			// 로그인한 사람의 정보 기억시키기 >> loginMember에 정보 기억시키기 
			// == loginMember에 memberInfo가 참조하고 있는 객체 주소 대입 >> 얕은 복사
			loginMember = memberInfo;
			return loginMember.getMemberName() + "님 환영합니다!";
		} else {
			return "아이디 또는 비밀번호가 일치하지 않습니다!";
		}
		
	}

	// 회원 정보 조회
	public String selectMember() {
		// 로그인 여부 확인 > 현재 로그인한 사람의 정보를 저장한 객체에서 정보 얻어오기 (이름, 아이디, 나이)
		// else > "로그인 후 이용해주세요"
		
		System.out.println("\n*****회원 정보 조회*****");
		
		// 1) 로그인 여부 확인
		if(loginMember == null) {
			return "로그인 후 이용해주세요";
		}
		// 2) 로그인이 되어있는 경우 : 한 줄 씩 정보 출력
		String str = "이름 : " + loginMember.getMemberName();
		str += "\n아이디 : " + loginMember.getMemberId();
		str += "\n나이 : " + loginMember.getMemberAge() + "세";
		return str;
	}
	
	// 회원 정보 수정
	public int updateMember() {
		System.out.println("\n*****회원 정보 수정*****");
		
		// 로그인 여부 판별 >> 로그인되어 있지 않으면 >> -1 반환
		if(loginMember == null) {
			return -1;
		}
		
		// 2-1) 로그인이 되어있을 때 >> 수정할 회원 정보 입력 받기 (이름, 나이)
		System.out.print("수정할 이름 입력 : ");
		String inputName = sc.next();
		
		System.out.print("수정할 나이 입력 : ");
		int inputAge = sc.nextInt();
		
		// 2-2) pw 입력 > 현재 로그인한 회원의 pw와 일치?
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.next();
		
		if(inputPw.equals(loginMember.getMemberPw())) {
			// pw 일치 >> 로그인한 회원의 이름, 나이 정보 >> 입력받은 값으로 변경(수정) >> 1 반환
			loginMember.setMemberName(inputName);
			loginMember.setMemberAge(inputAge);
			return 1;
		} else {
			// pw 불일치 >> 0 반환
			return 0;
		}
	}
}


