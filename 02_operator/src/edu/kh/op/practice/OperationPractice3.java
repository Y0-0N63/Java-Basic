package edu.kh.op.practice;

import java.util.Scanner;

public class OperationPractice3 {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("가격을 입력하세요 : ");
		int price = sc.nextInt();
		
		System.out.print("멤버십 있으세요? (있으면 true / 없으면 false 입력) : ");
		boolean member = sc.nextBoolean();
		double sale = member == true? price * 0.9 : price * 0.95;
		
		// 자바에서 문자열끼리 비교할 때에는 == 사용 X >> equals로 사용해도 ㄱㅊ
		// String member1 = sc.nextLine();
		// double sale = (member1.equals("true")) ? : price.*0.9 : price * 0.95; 
		System.out.printf("할인을 포함한 최종 금액 : %.1f원", sale);
	}
	
	public void practice2() {
		System.out.print("출금할 금액 입력 : ");
		int money = sc.nextInt();
		int fiveMillion = money / 50000;
		money %= 50000;
//		money -= 50000*fiveMillion;
		
		int oneMillion = money / 10000;
		money %= 10000;
//		money -= 10000 * oneMillion;
		
		int fiveThou = money / 5000;
		money %= 5000;
//		money -= 5000 * fiveThou;
		
		int oneThou = money/1000;
		System.out.printf("50000원 : %d\n10000원 : %d\n5000원 : %d\n1000원 : %d", fiveMillion, oneMillion, fiveThou, oneThou);
	}

	public void practice3() {
		System.out.print("첫 번째 수 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수 : ");
		int num2 = sc.nextInt();
		String result = (num1%num2) == 0? "배수입니다" : "배수가 아닙니다";
		System.out.println(result);
	}
}
