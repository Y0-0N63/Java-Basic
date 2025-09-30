package com.hw2.model.service;

import java.util.Scanner;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem {
	Scanner sc = new Scanner(System.in);
	private Employee[] employees;
	private int employeeCount;
	
	public Company(int size) {
		Employee[] employees = new Employee[size];
		employeeCount = 0;
	}
	
	@Override
	public void addPerson(Person person) {
		for(int i = 0; i < employees.length; i++) {
			if(employees[i].equals(null)) {
				System.out.print("직원이 추가되었습니다 - ID : ");
				String inputId = sc.next();
				System.out.print(" , 이름 : ");
				String inputName = sc.next();
				System.out.print(", 직책 : ");
				String inputPosition = sc.next();
				
				employees[i].setId(inputId);
				employees[i].setName(inputName);
				employees[i].setId(inputPosition);
			} else {
				System.out.println("인원이 모두 충원되었습니다.");
			}
			break;
		}
	}
	
	@Override
	public void removePerson(String id) {
		System.out.print("");
//		if(int i = 0; i < employees.length; i++) {
//			if()
//		}
	}
	
	@Override
	public void displayAllPersons() {	
		displayAllPersons();
	}
	
	
}
