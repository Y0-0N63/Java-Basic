package edu.kh.oop.cls.model.vo;

public class Student { // 클래스의 선언부
// [접근제한자] [예약어] class 클래스명 {}
	
//	TestVO test = new TestVO(); >> 같은 패키지이기 때문에 가능!
	
	// 1. 필드
	// 필드 접근 제한자 == 직접 접근 가능한 범위
	public int v1 = 10; // 같은 프로젝트이기만 하면, 전체에서 접근 가능
	protected int v2 = 20; // 후손 클래스까지 접근 가능
	int v3 = 30; // 같은 패키지 내까지 가능
	private int v4 = 40; // 해당 클래스 내부에서만 가능
	// The value of the field Student.v4 is not used : 라는 경고가 뜸
	// 왜? 해당 클래스 내에 getter, setter 메서드가 없기 때문에!
	// 나머지는 클래스 외부에서 접근할 수 있기 때문에 다른 방식으로도 접근할 수가 있음!
	
	// static 예약어
	public static String schoolName = "KH고등학교";
	
	// final 예약어
	private final int TEMP1 = 100;
			
	// 2. 생성자
	// 3. 메서드

	public void ex() {
		// 필드 접근제한자 확인
		// v1~v4 모두 동일 클래스 내부에서 생성된 변수 >> 모두 직접 접근 가능
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}
}
