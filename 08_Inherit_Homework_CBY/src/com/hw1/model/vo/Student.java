package com.hw1.model.vo;

public class Student extends Person {
	private int grade;
	private String major;
	
	public Student() {}

	public Student(String name, int age, double hieght, double weight, int grade, String major) {
		super(age, hieght, weight);
		this.name = name;
		this.grade = grade;
		this.major = major;
	}
	
	@Override
	public String information() {
		return super.information() + String.format(" / 학년 : %d / 전공 : %s", grade, major);
	}
}
