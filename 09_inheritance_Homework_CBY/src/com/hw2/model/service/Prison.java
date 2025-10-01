package com.hw2.model.service;

import java.util.Scanner;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {
	Scanner sc = new Scanner(System.in);
	private Prisoner[] prisoners;
	int prisonerCount;
	
	public Prison(int size) {
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}

	@Override
	public void addPerson(Person person) {
		// 매개변수로 들어온 person이 Prisoner인지 && prisoners 객체 배열에 공간이 있는지 체크
		if(person instanceof Prisoner && prisonerCount < prisoners.length) {
			prisoners[prisonerCount++] = (Prisoner) person;
			System.out.println("수감자가 추가되었습니다 - " + person.getInfo());
		} else {
			System.out.println("인원이 모두 충족되었습니다.");
		}
	}

	@Override
	public void removePerson(String id) {
		for(int i = 0; i < prisonerCount; i++) {
			if(prisoners[i].getId().equals(id)) {
				System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo());
				prisoners[i] = null;
				
			} for (int j = i; j < prisonerCount - 1; j++) {
				prisoners[j] = prisoners[j + 1];
			} 
			
			prisoners[--prisonerCount] = null;
			// return : 해당 메소드 즉시 종료
			// return문으로 메소드를 빠져나가는 방법은 리턴 자료형이 void형인 메소드에서만 사용 가능
			return;
		}
		
		System.out.println("해당 id를 가진 수감자를 찾을 수 없습니다.");
	}

	@Override
	public void displayAllPersons() {
		System.out.print("전체 수감자 명단 : \n");
		for(int i = 0; i < prisonerCount; i++) {
			System.out.println(prisoners[i].getInfo());
		}
	}

}
