package edu.kh.control.loop;

import java.util.Scanner;

public class WhileExample {
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		int input = 9;
		while(input != 0) {
			System.out.println("-------메뉴 선택-------");

			System.out.println("1. 떡볶이");
			System.out.println("2. 쫄면");
			System.out.println("3. 김밥");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			
			switch(input) {
			case 1 : System.out.println("떡볶이를 주문했다."); break;
			case 2 : System.out.println("쫄면을 주문했다."); break;
			case 3 : System.out.println("김밥을 주문했다."); break;
			case 0 : System.out.println("프로그램을 종료합니다"); break;
			default : System.out.println("메뉴에 있는 번호만 선택해주세요!");
			}
		}
	}
	
	public void ex2() {
		// 입력되는 모든 정수의 합 구하기, 0 입력 : 반복 종료 후 결과 출력
		int input = 0;
		int sum = 0;
		
		do {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;
		} while(input != 0);
		
		System.out.println("합계 : " + sum);
	}
}
