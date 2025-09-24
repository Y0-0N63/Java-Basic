package edu.kh.oop.cls.model.service;

import edu.kh.oop.cls.model.vo.Student;
import edu.kh.oop.cls.model.vo.User;

// ClsService와 Student/TestVO는 패키지가 다름
// CLsService(자식) <- Student(부모)
public class ClsService /* extends Student*/ {
	public void ex1() {
		// 클래스 접근제한자 확인하기
		Student std = new Student();
		
		// TestVO test = new TestVO(); // 다른 패키지라 사용 불가 (import도 불가능!)
		
		// 필드 접근제한자 확인하기
		// 상속 관계에서 직접 접근 가능 범위 테스트
		// *상속받으면 부모의 것도 마치 내 것처럼 사용 가능
//		System.out.println(v1); // public
//		System.out.println(v2); // protected
//		System.out.println(v3); // The field Student.v3 is not visible, default
//		System.out.println(v4); // private, 해당 클래스 내부가 아닌 다른 클래스라서 X
		
		System.out.println(std.v1); // 같은 프로젝트니까 직접 접근 가능~
//		System.out.println(std.v2); // extends(상속) 주석 처리 후 > 오류 발생! (후손 클래스가 아니니까)
//		System.out.println(std.v3);
//		System.out.println(std.v4);
	}
	
	public void ex2() {
		Student std1 = new Student();
		Student std2 = new Student();
		
		System.out.println(Student.schoolName);
		System.out.println(std2.schoolName);
		System.out.println(Student.schoolName);
	}
	
	public void ex3() {
		// 생성자 확인 테스트
		
//		// User() -> 기본 생성자, 컴파일러가 자동으로 만들어줌
//		User u1 = new User(); // 기본 생성자 활성화 위치
//		System.out.println(u1.getUserId());
//		System.out.println(u1.getUserPw());
//		System.out.println(u1.getUserName());
//		System.out.println(u1.getUserAge());
//		// char 기본 값 > 공백
//		System.out.println(u1.getUserGender());
//		
//		System.out.println();
//		
//		// 기본 생성자 사용 시, 고정된 값으로 필드를 초기화시키면 같은 정보만 대입됨
//		User u2 = new User();
//		System.out.println(u2.getUserId());
//		System.out.println(u2.getUserPw());
//		System.out.println(u2.getUserName());
//		System.out.println(u2.getUserAge());
//		System.out.println(u2.getUserGender());
//		
//		System.out.println("=====================================");
//		// 1. setter 이용해 새로운 값으로 재대입(덮어쓰기)
//		u2.setUserId("asd1234");
//		u2.setUserPw("1s2d3f");
//		u2.setUserName("김영희");
//		u2.setUserAge(25);
//		u2.setUserGender('여');
//		
//		System.out.println(u2.getUserId());
//		System.out.println(u2.getUserPw());
//		System.out.println(u2.getUserName());
//		System.out.println(u2.getUserAge());
//		System.out.println(u2.getUserGender());
		
		// 2. 매개변수 생성자 이용 > 객체 생성부터 다른 값으로 필드 초기화되게
		
		User u3 = new User("test3", "pssword1234");
		System.out.println(u3.getUserId());
		System.out.println(u3.getUserPw());
		System.out.println(u3.getUserName());
		System.out.println(u3.getUserAge());
		System.out.println(u3.getUserGender());
	}

	public void ex4() {
		// 기본 생성자
		User u1 = new User();
		// 매개변수 생성자
		User u2 = new User("user02", "pass02");
		// 매개변수 5개 생성자 (전부 초기화)
		User u3 = new User("user03", "pass03", "김길동", 20, '남');
		
		System.out.printf("u1 : %s / %s / %s / %d / %c\n", u1.getUserId(),
				u1.getUserPw(), u1.getUserName(), u1.getUserAge(), u1.getUserGender());
		
		System.out.printf("u2: %s / %s / %s / %d / %c\n", u2.getUserId(),
				u2.getUserPw(), u2.getUserName(), u2.getUserAge(), u2.getUserGender());
		
		System.out.printf("u3 : %s / %s / %s / %d / %c\n", u3.getUserId(),
				u3.getUserPw(), u3.getUserName(), u3.getUserAge(), u3.getUserGender());
	}
}
