package com.hw2.run;

import com.hw2.model.dto.Monkey;
import com.hw2.model.dto.Tiger;
import com.hw2.model.service.Zoo;

public class Run {

	public static void main(String[] args) {
		// Zoo 객체 생성
		Zoo zoo = new Zoo();
		
		// Tiger 객체 생성해 zoo에 추가
		zoo.addAnimal(new Tiger("호랑이"));
		
		// Monkey 객체 생성해 zoo에 추가
		zoo.addAnimal(new Monkey("원숭이"));
		
		// 동물원 메뉴 출력 > 입력한 값대로 코드 수행
		zoo.displayMenu();
	}

}
