package edu.kh.variable2;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();
//		System.out.println(input1);
		
		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
//		System.out.println(input2);
		
		System.out.printf("%d + %d = %d", input1, input2, (input1 + input2));
	}
}
