package edu.kh.io.pack3.model.dto;

import java.io.Serializable;

// 인터페이스 > 추상도가 굉장히 높음 > 반드시 implements해야 하는 메서드가 존재
// Serializable은 그렇지 않음 > interface 안에 작성된 내용이 없기 때문!
// Serializable interface : 추상 메서드가 하나도 없는 인터페이스 > 상속만 받아도 입/출력 시 직렬화가 가능하다는 의미(표시)만 제공 (마커 interface)
public class Member implements Serializable {
	// Member warning!	: The serializable class Member does not declare a static final serialVersionUID field of type long
	// 권장 내용 : Serializable하고자 하는 class에 serialVersionUID field 추가 (그렇지 않을 시, JVM이 내부적으로 자동 생성)
	// JVM이 생성해준 값은 나(개발자)가 알 수 없음 > 메모리가 꼬일 수(거의 그럴 리가 없으나) 있기 때문에 명시적으로~
	// 다만, 역직렬화할 때 serialVersionUID의 내용이 다를 시 에러 발생하므로 명시적으로 작성하는 것이 추천됨
	// serialVersionUID : 직렬화된 객체를 다시 복원할 때(역직렬화) 원래 클래스와 현재 클래스가 동일한 버전인지 확인하기 위한 식별 번호
	private static final long serialVersionUID = 1L;
	
	// 필드
	private String id;
	private String pw;
	private String name;
	private int age;
	
	// 메서드
	public Member() {}

	public Member(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}
}
