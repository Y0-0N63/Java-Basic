package edu.kh.inheritance.model.dto;

/*
 * Object
 * 	  ㄴ Person
 * 			ㄴ Student
 */

public class Student extends Person {
	// Student 클래스에 Person 클래스 내용 확장(연장)
	// == Student 클래스에 Person 클래스의 필드, 메서드 추가해 확장
	
//	private String name;
//	private int age;
//	private String natinoality;
	private int grade;
	private int classroom;
	
//	public Student(String name, int age, String natinoality, int grade, int classroom) {
//		// 매개변수 생성자처럼 사용될 수 있음
//		super();
////		this.name = name;
////		this.age = age;
////		this.natinoality = natinoality;
//		this.grade = grade;
//		this.classroom = classroom;
//	}
	
//	public Student(int grade, int classroom) {
//		super(); // 부모에게 전해줄 게 없는 초기화된 값 >> JVM 기본값으로 출력됨
//		this.grade = grade; 
//		this.classroom = classroom;
//	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

public Student(String name, int age, String nationality, int grade, int classroom) {
	// this.name = name;
	// this.age = age;
	// this.nationality = nationality;
	// > 가 되지 않는 이유 : this 참조변수는 본인 자신만을 의미함
	// > 따라서 자기 자신 객체 안에 "실제로" 들어있는 필드만 참조함
	// >> 부모의 고유 필드인 name, age, nationality는 this가 참조하고 있는 주소의 필드가 아님!
	// >> this 참조 변수를 이용해 직접 접근 불가능
	
	super(name, age, nationality); // 매개변수를 통해 전해받은 값으로 부모까지 초기화
	// ㄴ 부모의 매개변수 생성자
	// super 위에는 아무것도 작성하면 안 됨! 생성자 구문의 첫 줄에 super 작성해야만

	// setName(name);
	// setAge(age);
	// setNationality(nationality);
	// setter 메서드 이용해 초기화 가능은 하나 비효율적이라 실제로 사용하지는 않음
	//	>> super 생성자 사용
	
		this.grade = grade;
		this.classroom = classroom;
	}

	//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	public String getNatinoality() {
//		return natinoality;
//	}
//	public void setNatinoality(String natinoality) {
//		this.natinoality = natinoality;
//	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	
	// Override method in Person == 원래 Object 거지만 Person에서 재정의했으니까
	@Override
	public String toString() {
		// super. : super 참조 변수 >> 상속 관계에서 부모 객체를 가리키는 참조 변수
		return super.toString() + " / " + grade + " / " + classroom;
	}
}
