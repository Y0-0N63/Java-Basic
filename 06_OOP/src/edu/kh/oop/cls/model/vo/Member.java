package edu.kh.oop.cls.model.vo;

// 회원 클래스
public class Member {
	// 속성(Field) : id, pw, 이름 나이
	// 기능(Method, 생성자) : getter, setter
	
	private String memberId;
	private String memberPw;
	private  String memberName;
	private int memberAge;
	
	public Member() {
	}
	
	public Member(String memberId, String memberPw, String memberName, int memberAge) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	// toString() : Object 최상위 클래스에 이미 만들어진 메서드
	// : 객체가 문자열로 변환되어야 할 때 사용하는 메서드
	// -> 보통 객체의 필드값을 출력하는 용도로 오버라이딩하여 사용 
	@Override
	public String toString() {
		// 객체의 문자열을 주소값으로 반환
		return memberId + " / " + memberName + " / " + memberAge + "세";
	}
}
