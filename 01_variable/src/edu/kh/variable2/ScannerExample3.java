package edu.kh.variable2;

import java.util.Scanner;

public class ScannerExample3 {

	public static void main(String[] args) {
		// 문자열을 3번 입력받아 한 줄로 출력하게
		Scanner sc = new Scanner(System.in);
//		System.out.print("입력 텍스트 : ");
//		String test = sc.nextLine();
//		System.out.println(test);
		
		System.out.print("입력 1 : ");
		String input1 = sc.nextLine();

		System.out.print("입력 2 : ");
		String input2 = sc.nextLine();

		System.out.print("입력 3 : ");
		String input3 = sc.nextLine();
		
		System.out.printf("%s %s %s", input1, input2, input3);
	}

}
