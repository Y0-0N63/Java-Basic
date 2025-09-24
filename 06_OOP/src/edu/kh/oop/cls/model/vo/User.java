package edu.kh.oop.cls.model.vo;

public class User {
	// 속성 (필드) : id, pwd, 이름, 나이, 성별 >> 추상화
	// 클래스 외부에서 데이터 직접 접근 불가 원칙 > 접근제한자 : private >> 캡슐화
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;

	// 기본 생성자 == 매개변수가 없는 생성자 (ctrl + space + enter > constructor)
	public User() {
		System.out.println("기본 생성자로 User 객체 생성");
		
		// 필드 초기화
		userId = "user01";
		userPw = "pass01";
		userName = "홍길동";
		userAge = 20;
		userGender = '남';
	}
	
	// 매개변수 생성자
	public User(String userId1, String userPW) {
		userId = userId1;
		this.userPw = userPW;
	}
	
	// 필드를 전부 초기화하는 목적의 매개변수 생성자
	public User(String userId, String userPw, String userName, int userAge, char userGender) {
//		 this.userId = userId;
//		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}

	// 기능 (메서드)
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
//	오버로딩 >> 매개변수가 하나인 생성자는 이것이 유일함
	public User(String userId) {
	}
	
	// 매개변수의 개수는 동일하지만, 타입이 서로 다름
	public User(int userAge) {
	}
	
	// 매개변수의 개수와 동일한 것이 있으나, 하나의 타입이 다름
	public User(String userId, int userAge) {
	}
	
	// 매개변수의 개수, 타입은 같지만 순서가 다름
	public User(int userAge, String userId) {
	}
	
//	// 오류 발생! 변수명만 다르고, 개수와 타입, 순서가 모두 같음
	// 오버로딩은 변수명은 신경쓰지 않음
//	public User(int age, String name) {
//	}
}
