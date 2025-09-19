package edu.kh.variable2;

import java.util.Scanner;

public class ScannerExample2 {

	public static void main(String[] args) {
		// 사칙연산 계산기 : 두 실수를 입력받아(Scanner) 사칙연산 결과를 모두 출력(Print)
		// 단, 출력된 결과값은 소수점 이하 둘째 자리까지만 표현
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 실수 입력 : ");
		double num1 = sc.nextDouble();
		
		System.out.print("두번째 실수 입력 : ");
		double num2 = sc.nextDouble();
		
		System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, (num1+num2));
		System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, (num1-num2));
		System.out.printf("%.2f * %.2f = %.2f\n", num1, num2, (num1*num2));
		System.out.printf("%.2f / %.2f = %.2f\n", num1, num2, (num1/num2));
	}
}
