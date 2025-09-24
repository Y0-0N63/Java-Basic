package edu.kh.oop.practice.model.service;

import java.util.Scanner;

import edu.kh.oop.practice.model.vo.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	
	public void practice() {
		// 1. 기본 생성자 >> 첫 번째 Book 객체 생성
		Book book1 = new Book();
		
		// 2. 매개변수 생성자 >> 두 번째 Book 객체 생성
		Book book2 = new Book("자바의정석", 30000, 0.2, "남궁성");
		
		// 3. 객체가 가진 필드 값, toString() 이용해 출력
		System.out.println(book1.toString());
		System.out.println(book2.toString());
				
		// 4. 첫 번째 객체가 가진 값, setter 이용해 수정
		book1.setTitle("C언어");
		book1.setPrice(30000);
		book1.setDiscountRate(0.1);
		book1.setAuthor("홍길동");
		
		System.out.println("===========================");

		// 5. 수정된 객체 필드 값, toString() 이용해 출력
		System.out.println("수정된 결과 확인");
		System.out.println(book1.toString());
		
		System.out.println("===========================");
		
		// 6. 각 객체의 할인율 적용한 책 가격 계산 >> 출력
		// 7. 할인된 가격 = 가격 - (가격 * 할인율)
		System.out.printf("도서명 = %S\n할인된 가격 = %d원\n", book1.getTitle(), (int)(book1.getPrice() - (book1.getPrice() * book1.getDiscountRate())));
		System.out.printf("도서명 = %S\n할인된 가격 = %d원", book2.getTitle(), (int)(book2.getPrice() - (book2.getPrice() * book2.getDiscountRate())));
	}
}
