package edu.kh.inheritance.model.service;

import edu.kh.inheritance.model.dto.Person;
import edu.kh.inheritance.model.dto.Student;


public class InheritanceService {
	public void ex1() {
		Person p = new Person();
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		
		System.out.println(p.toString());
		
		Student std = new Student();
		std.setName("고길동");
		std.setAge(19);
		std.setNationality("대한민국");
		
		// Student만의 고유한 멤버
		std.setGrade(1);
		std.setClassroom(3);
	}
}
