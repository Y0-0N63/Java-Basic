package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {
	public void practice() {
		// 1. 매개변수 생성자를 이요해 첫 번째, 두 번째 Hero 객체 생성
		Hero hero1 = new Hero("이구역짱", "전사", 200, 20, 1, 0.0);
		Hero hero2 = new Hero("Zi존위자드", "마법사", 100, 100, 1, 0.0);
		
		// 2. 객체가 가진 필드값을 매개변수 생성자를 이용해 객체 생성 시 출력
		System.out.println("==========캐릭터 생성==========");
		System.out.println(hero1.getJob() + " 직업으로 '" + hero1.getNickname() + "'님이 생성되었습니다.");
		System.out.println("현재 레벨 : " + hero1.getLevel());
		System.out.println("현재 hp : " + hero1.getHp());
		System.out.println("현재 mp : " + hero1.getMp());
		System.out.println("현재 경험치 : " + hero1.getExp());
		
		System.out.println("==========캐릭터 생성==========");
		System.out.println(hero2.getJob() + " 직업으로 '" + hero2.getNickname() + "'님이 생성되었습니다.");
		System.out.println("현재 레벨 : " + hero2.getLevel());
		System.out.println("현재 hp : " + hero2.getHp());
		System.out.println("현재 mp : " + hero2.getMp());
		System.out.println("현재 경험치 : " + hero2.getExp());
		
		// 3. 각 객체가 가진 method를 적절히 호출하여 출력결과와 같이 출력
		System.out.println("==============" + hero1.getNickname() + " 시점==============");
		hero1.attack(100.0);	
		hero1.attack(50.5);
		hero1.attack(49.5);
		hero1.dash();	
		hero1.dash();
		hero1.dash();
		
		System.out.println(hero1.toString());

		System.out.println("==============" + hero2.getNickname() + " 시점==============");
		hero2.attack(300.0);
		hero2.dash();
		hero2.attack(300.0);
		hero2.attack(300.0);
		
		System.out.println(hero2.toString());
	}
}
