package edu.kh.inheritance.model.service;

import edu.kh.inheritance.model.dto.Employee;
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
	
	// 오버라이딩 확인 예제
	public void ex2() {
		Student std = new Student();
		Employee emp = new Employee();
		
		// 오버라이딩 X == Person(부모)의 메서드 수행
		std.move();

		// 오버라이딩 O == Employee에서 재정의한 메서드 수행
		emp.move();
	}
	
	// toString() 오버라이딩 예제
	public void ex3() {
		Person p = new Person("김철수", 17, "한국");
		
		// print 구문 수행 시, 참조변수명만 작성해도 자동으로 toString() 메서드 호출
		System.out.println(p);
		System.out.println(p.toString());
		
		Student std = new Student("강호동", 18, "미국", 2, 6);
		System.out.println(std);
		System.out.println(std.toString());
		
		Employee emp = new Employee("김노동", 36, "한국", "샘송");
		System.out.println(emp);
	}
}
