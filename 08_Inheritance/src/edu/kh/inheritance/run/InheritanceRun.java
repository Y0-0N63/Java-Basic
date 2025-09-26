package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Employee;
import edu.kh.inheritance.model.dto.Student;
import edu.kh.inheritance.model.service.InheritanceService;

public class InheritanceRun {

	public static void main(String[] args) {
		InheritanceService service = new InheritanceService();
//		service.ex1();
//		
//		Student std1 = new Student();
//		System.out.println(std1.getName());
//		System.out.println(std1.getAge());
//		System.out.println(std1.getNationality());
//		System.out.println(std1.getGrade());
//		System.out.println(std1.getClassroom());
//		
//		System.out.println();
//		
//		Student std2 = new Student("홍길순", 20, "미국", 1, 3);
//		System.out.println(std2.getName());
//		System.out.println(std2.getAge());
//		System.out.println(std2.getNationality());
//		System.out.println(std2.getGrade());
//		System.out.println(std2.getClassroom());
//		
//		System.out.println("==============");
//		Employee emp = new Employee("김노동", 30, "한국", "KH 정보교육원");
//		System.out.println(emp.getName());
//		System.out.println(emp.getAge());
//		System.out.println(emp.getNationality());
//		System.out.println(emp.getCompany());
		
//		service.ex2();
		service.ex3();
	}

}
