package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample {
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		// 1~10 출력
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		// A부터 Z까지 한 줄로 출력
		for(int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char)i);
		}
		
		System.out.println("\n==========================");
		
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
	
	public void ex3() {
		// 1부터 입력받은 수까지 1씩 증가하며 출력
		System.out.print("번호 입력 : ");
		int input = sc.nextInt();
		for(int i = 1; i <= input; i++) {
			System.out.println(i);
		}
	}	
	
	public void ex4() {
		// 정수 5개 입력받아 > 합계 구하기
		int sum = 0;
		for(int i = 1; i <= 5; i++) {
//			System.out.printf("입력 %d : ", i);
//			sum += sc.nextInt();
			
			System.out.print("입력 " + i + " : ");
			int input = sc.nextInt();
			sum += input;
		}
		System.out.println("합계 : " + sum);
	}
	
	public void ex5() {
		// 1부터 20까지 1씩 증가하며 출력, 입력받은 수의 배수는 양쪽에 () 표시
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= 20; i++) {
			if (i % num == 0) {
				System.out.printf("(%d) ", i);
			} else {
				System.out.print(i + " ");
			}
		}
	}
	
	public void ex6() {
		// 구구단 : 2~9 하나 입력 받아 해당 단 출력
		// 입력받은 수가 2~9 이외의 것 >> "잘못 입력하셨습니다"
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		if(dan < 2 || dan > 9) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			for(int i = 1; i <= 9 ; i++) {
				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
			}
		}
	}
	
	public void ex7() {
		// 숫자 세기 (count) : 1부터 20까지 1씩 증가, 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력
		System.out.print("숫자 입력 : ");
		int input2 = sc.nextInt();
		
		String result = "";
		int count = 0;
		int sum = 0;
		
		System.out.println();
		
		for(int i = 1; i <= 20; i++) {
			if(i % input2 == 0) {
				result += i + " ";
				sum += i;
				count ++;
			}
		}
		
		System.out.printf("%s: %d개\n", result, count);
		System.out.printf("%d의 배수 합계 : %d", input2, sum);
	}
	
	public void ex8() {
		// 구구단 모두 출력하기
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				// %2d : 두 칸 확보, 오른쪽 정렬 // %-2d : 두 칸 확보, 왼쪽 정렬
				System.out.printf("%d X %d = %2d  ", i, j, i*j);
			}
			System.out.println();
		}
	}
}
