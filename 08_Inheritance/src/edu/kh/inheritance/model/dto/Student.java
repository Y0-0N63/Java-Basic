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
	
	public Student(String name, int age, String natinoality, int grade, int classroom) {
		super();
//		this.name = name;
//		this.age = age;
//		this.natinoality = natinoality;
		this.grade = grade;
		this.classroom = classroom;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
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
}
