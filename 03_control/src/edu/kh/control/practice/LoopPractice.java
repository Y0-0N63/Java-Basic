package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		if(input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = 1; i <= input; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice2() {
		System.out.print("1 이상의 숫자를 입력하세요 : ");
		int input2 = sc.nextInt();
		if(input2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = input2; i > 0; i--) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input3 = sc.nextInt();
		String result = "";
		int sum = 0;
		
		for(int i = 1; i <= input3; i++) {
			sum+=i;
			if(i == input3) {
				result += i;
			} else {
				result += i + " + ";
			}
		}
		System.out.printf("%s = %d", result, sum);
	}
	
	public void practice4() {
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		int start = 0;
		int end = 0;
		
		if(num1 > num2) {
			start = num2;
			end = num1;
		} else {
			start = num1;
			end = num2;
		}
			
		if(num1 <= 0 || num2 <= 0) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = start; i <= end; i++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void practice5() {
		System.out.print("숫자 : ");
		int input4 = sc.nextInt();
		
		System.out.printf("==== %d단 ====\n", input4);
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %-2d\n", input4, i, input4*i);
		}
	}
	
	public void practice6() {
		System.out.print("숫자 : ");
		int input5 = sc.nextInt();
		
		if(input5 < 2 || input5 > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for(int i = input5; i <= 9; i++) {
				System.out.printf("==== %d단 ====\n", i);
				for(int j = 1; j <= 9; j++) {
					System.out.printf("%d * %d = %d\n", i, j, i*j);
				}
				System.out.println();
			}
		}
	}
	
	public void practice7() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int input6 = sc.nextInt();
		String array = "";
		int count = 0;
		
		for(int i = 2; i <= input6; i++) {
			if(i % 2 == 0 || i % 3 == 0) {
				array += i + " ";
			}
			
			if(i % 2 == 0 && i % 3 == 0) {
				count++;
			}
		}
		
		System.out.println(array);
		System.out.println("count : " + count);
	}
}
