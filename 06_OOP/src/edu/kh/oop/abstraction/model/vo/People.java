package edu.kh.oop.abstraction.model.vo;

// 국민(사람) 클래스
public class People {
	// 속성
	// 추상화 발생 : 이름, 성별, 주민번호, 주소, 전화번호, 나이...
	// 필드에 작성된 변수 : 필드변수, 멤버변수
	
	// 캡슐화 > 접근 제한자 사용해 public(공공) -> private(사적)
	private String name;
	private char gender;
	private String pNo; // 주민등록번호
	private String address; // 주소
	private String phone; // 전화번호
	private int age;
	
	public void tax() {
		System.out.println("세금을 냅니다.");
	}
	
	public void vote() {
		System.out.println("투표를 합니다.");
	}
	
	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 캡슐화 > 사용할 간접 접근 기능(메서드)(getter/setter)
	// 양식 : [접근제한자] 반환명 메서드명() {}
	// name 변수의 값을 호출한 쪽으로 돌려보내주는 간접 접근 기능 중 getter
	public String getName() {
		// name이라는 반환값 존재, 반환형 : 반환되는 값의 자료형
		// if) 반환형 없음을 의미하는 void를 작성 > 오류 발생!
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getPNo() {
		return pNo;
	}
	
}
