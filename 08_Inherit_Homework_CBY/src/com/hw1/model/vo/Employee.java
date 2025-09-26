package com.hw1.model.vo;

public class Employee extends Person {
	private int salary;
	private String dept;
	
	public Employee() {}

	public Employee(String name, int age, double hieght, double weight, int salary, String dept) {
		super(age, hieght, weight);
		// 부모 Person에 작성된 필드 중 protected 접근 제한자 name
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String information() {
		return super.information() + String.format(" / 급여 : %d / 부서 : %s", salary, dept);
	}
}
