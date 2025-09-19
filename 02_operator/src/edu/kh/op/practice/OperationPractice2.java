package edu.kh.op.practice;

import java.util.Scanner;

public class OperationPractice2 {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 나이는? : ");
		int age = sc.nextInt();
		
		String result = age >= 20? "저는 성인입니다" : "저는 미성년입니다";
		System.out.println(result);
		
		System.out.print("청소년 입니까? ");
		System.out.print((age>=13) && (age<=19));
		// boolean isTeenager = (age>=13) && (age<=19)
		// System.out.println("청소년 입니까? " + isTeenager);
		System.out.println();
		
		System.out.print("노인이거나 어린이입니까? ");
		System.out.print((age>=65) || (age<=12));
	}

}
