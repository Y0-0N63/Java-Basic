package com.hw2.run;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;
import com.hw2.model.service.Company;
import com.hw2.model.service.ManagementSystem;
import com.hw2.model.service.Prison;

public class Run {

	public static void main(String[] args) {
		// Company의 생성자를 이용해 10칸짜리 Employee 객체배열을 생성하는 Company 객체 생성
		// >> ManagementSystem 자료형의 company에 주소 저장
		ManagementSystem company = new Company(10);
		
		// Prison 생성자를 이용해 10칸짜리 Prisoner 객체배열을 생성하는 Prison 객체 생성
		// >> ManagementSystem 자료형의 prison에 주소 저장
		ManagementSystem prison = new Prison(10);
		
		// 2명의 직원 새로 등록
		company.addPerson(new Employee("EMP001", "유재석", "기획팀"));
		company.addPerson(new Employee("EMP002", "정형돈", "개발팀"));
		
		// 등록된 전체 직원 조회
		company.displayAllPersons();
		
		System.out.println("===============================================");
		
		// 2명의 수감자 새로 등록
		// 등록된 전체 수감자 조회
		prison.addPerson(new Prisoner("1205", "정준하", "밥도둑"));
		prison.addPerson(new Prisoner("0705", "박명수", "웃음 연쇄 살인"));
		
		prison.displayAllPersons();

		System.out.println("===============================================");

		// EMP001 id를 가진 직원 삭제	
		company.removePerson("EMP001");
		
		// 1205 id를 가진 수감자 삭제
		prison.removePerson("1205");

		System.out.println("===============================================");

		// 현재 남은 직원 모두 조회
		company.displayAllPersons();
		
		// 현재 남은 수감자 모두 조회
		prison.displayAllPersons();
	}
}
