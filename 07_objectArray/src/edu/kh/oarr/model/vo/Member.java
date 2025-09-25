package edu.kh.oarr.model.vo;

public class Member {
	// 속성 (필드 == 멤버 변수)
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String region;

	// 기능 (메서드, 생성자(기본, 매개변수), 클래스명과 동일, 반환형 없음)
	public Member() {}
	
	// 모든 필드 초기화용 매개변수 생성자
	// 오버로딩을 통해 여러 개의 메서드를 만들 수 있음
	// 오버로딩 : 같은 클래스 내 동일한 생성자명/메서드명 이용할 수 있는 기법
	// 오버로딩 성립 조건 : 매개변수의 타입, 개수, 순서 중 하나 이상 달라야
	public Member(String memberId, String memberPw, String memberName, int memberAge, String region) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.region = region;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
}
