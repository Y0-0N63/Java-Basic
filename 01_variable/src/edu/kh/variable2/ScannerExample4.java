package edu.kh.variable2;

import java.util.Scanner;

public class ScannerExample4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("nextInt() 입력 : ");
		int intNum = sc.nextInt();
		// 이 시점에서 프로그램이 종료가 됨
		
		sc.nextLine(); 
		
		System.out.print("nextLine() 입력 : ");
		String word = sc.nextLine(); 
		
	}

}
