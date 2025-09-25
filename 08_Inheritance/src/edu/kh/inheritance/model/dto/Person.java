package edu.kh.inheritance.model.dto;

public class Person {
	// 속성(필드)
	private String name;
	private int age;
	private String nationality;

	// 기능(생성자/메서드)
	public Person() {
		// super();이 생략된 상태 >> 컴파일러가 자동으로 추가해줌!
	}

	public Person(String name, int age, String nationality) {
		super(); // Object( ) : 기본 생성자 == 부모의 생성자
		this.name = name;
		this.age = age;
		this.nationality = nationality;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	

	public void breath() {
		System.out.println("사람은 코나 입으로 숨을 쉰다.");
	}
	
	public void move() {
		System.out.println("사람은 움직일 수 있다.");
	}
	
	// 오버라이딩 하는 순간 >> 부모의 것에서 자식의 것이 됨
	@Override
	public String toString() {
		return name + " / " + age + " / " + nationality;
	}

}
