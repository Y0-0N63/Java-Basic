package com.hw2.model.service;

import java.util.Scanner;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem {
	Scanner sc = new Scanner(System.in);

	private Employee[] employees;
	private int employeeCount;

	public Company(int size) {
		employees = new Employee[size];
		employeeCount = 0;
	}

	@Override
	public void addPerson(Person person) {
		// 매개변수로 들어온 person이 Employee인지 && employees 객체 배열에 공간이 있는지 체크
		if (person instanceof Employee && employeeCount < employees.length) {
			employees[employeeCount++] = (Employee) person;
			System.out.println("직원이 추가되었습니다 - " + person.getInfo());
		} else {
			System.out.println("인원이 모두 충원되었습니다.");
		}
	}

	@Override
	public void removePerson(String id) {
		// employees.length가 아닌 employeeCount 사용 : 현재 등록된 직원 수 만큼만 반복해야 하니까!
		for (int i = 0; i < employeeCount; i++) {
			if (employees[i].getId().equals(id)) {
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());
				employees[i] = null;

				// 직원 삭제 후, 삭제된 위치서부터 나머지 배열의 요소들을 한 칸씩 앞당겨야 함
				for (int j = i; j < employeeCount - 1; j++) {
					employees[j] = employees[j + 1];
				}
				// employeeCount 변수를 감소 > 배열의 마지막 요소를 null로 설정 > 직원수 줄이기
				employees[--employeeCount] = null;
				
				return;
			}
		}
		System.out.println("해당 id를 가진 직원을 찾을 수 없습니다.");
	}

	@Override
	public void displayAllPersons() {
		System.out.print("전체 직원 명단 : \n");
		for(int i = 0; i < employeeCount; i++) {
			System.out.println(employees[i].getInfo());
		}
	}

}
