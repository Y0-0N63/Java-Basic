package edu.kh.inheritance.model.dto;

/*
 * Object
 * 	ㄴ	Person
 * 		ㄴ Employee / Student (같은 부모를 가졌을 뿐, 서로 관계를 가진 것은 아님)	 
 * */

// final 클래스 : 상속 불가(누군가의 부모가 될 수 없다)
public /* final */ class Employee extends Person {
	// 필드
	private String company;

	public Employee(String name, int age, String nationality, String company) {
		// Person 매개변수 생성자
		super(name, age, nationality);
		this.company = company;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	// Override method in person
	// Person으로부터 상속받은 메서드 중, move() 메서드를 Employee에 맞게 재정의 (오버라이딩)
	// @Override : 어노테이션, 해당 메서드가 오버라이딩되었음을 컴파일러에게 알려주는 역할
	// >> 컴파일러에게 문법 체크를 하도록 알린다
	// ex) 부모에게 해당 메서드가 있는지, 이름, 매개변수 타입, 개수, 순서 일치하는지 체크
	@Override
	public void move() {
//		super.move(); >> 부모의 move 메서드 실행
		System.out.println("오버라이딩된 move()");
		System.out.println("효율적으로 빨리 일하고 퇴근한다");
	}
	
	@Override
	public String toString() {
		return super.toString() + " / " + company;
	}
	
	// final 메서드 -> 오버라이딩하면 안 되는 메서드에 붙여줌
	// == 메서드의 기능이 변하면 안 되는 경우에 사용 
	// Cannot override the final method from Employee
	public final void onlyEmployee() {
		System.out.println("final 메서드입니다.");
	}
}
