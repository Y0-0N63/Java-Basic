package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

public class AbstractionService {
	// 속성
	// 기능
	public void ex1() {
		// People 클래스 이용해 국민 객체 만들기
		People p1 = new People();
		// Peopl1 p1 : People 객체의 주소를 저장하여 참조하는 변수 p1
		// p1 == 참조변수
		// new People(); : 새로운 People 객체를 Heap 영역에 생성
		
//		p1.name = "홍길동";
//		p1.gender = '남';
//		p1.pNo = "123456-1234567";
//		p1.address = "서울시 중구 남대문로 120";
//		p1.phone = "010-1234-1234";
//		p1.age = 20;
//		
//		p1.tax();
//		p1.vote();
//		
//		System.out.println("p1의 name : " + p1.name);
//		System.out.println("p1의 gender : " + p1.gender);
//		System.out.println("p1의 pNo : " + p1.pNo);
//		System.out.println("p1의 address : " + p1.address);
//		System.out.println("p1의 phone : " + p1.phone);
//		System.out.println("p1의 age : " + p1.age);
		
		// 소괄호 내 값 = 전달인자(전달하는 값)
		// p1에 홍길동 데이터 세팅하기
		p1.setName("홍길동");
		p1.setGender('남');
		p1.setpNo("123456-1234567");
		p1.setAddress("서울시 중구 남대문로 120");
		p1.setPhone("010-1234-1234");
		p1.setAge(20);

		// getter : 메소드의 호출
		System.out.println(p1.getName());
		System.out.println(p1.getGender());
		System.out.println(p1.getpNo());
		System.out.println(p1.getAddress());
		System.out.println(p1.getPhone());
		System.out.println(p1.getAge());
		
		System.out.println("====================");

		People by = new People();
		
		by.setName("최보윤");
		by.setGender('여');
		by.setpNo("040603-4******");
		by.setAddress("서울시 동작구");
		by.setPhone("010-2122-1625");
		by.setAge(22);
		
		System.out.println(by.getName());
		System.out.println(by.getGender());
		System.out.println(by.getpNo());
		System.out.println(by.getAddress());
		System.out.println(by.getPhone());
		System.out.println(by.getAge());
		}

}
