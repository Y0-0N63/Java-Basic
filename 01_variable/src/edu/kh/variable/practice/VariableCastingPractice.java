package edu.kh.variable.practice;

public class VariableCastingPractice {

	public static void main(String[] args) {
		// 문제 1
		int age = 22;
		System.out.println("나는 " + age + "살입니다.");
		
		// 문제 2
		int score = 90;
		System.out.println("최종 점수 : " + (score+10));
		
		// 문제 3
		int a = 10;
		double b = a;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		// 문제 4
		double pi = 3.14159;
		int pi2 = (int)pi;
		System.out.printf("pi = %.2f, pi2 = %d \n", pi, pi2);
		
		// 문제 5
		char ch = 'A';
		int code = ch;
		System.out.println("문자 : " + ch + ", 코드값 : " + (int)ch);
		System.out.printf("문자 : %c, 코드값 : %d \n", ch, code);
		
		// 문제 6
		final int PRICE = 5000;
		int count = 3;
		System.out.println("물건 가격 : " + PRICE + "원, 개수 : " + count + "개, 총액 : " + PRICE * count + "원");
		System.out.printf("물건 가격 : %d원, 개수 : %d개, 총액 : %d원 \n", PRICE, count, (PRICE*count));
		
		// 문제 7
		int korea = 95, eng = 87, math = 90;
		int sum = korea + eng + math;
		double avg = sum/3;
		// 나누는 값을 실수로 변환하면 자동형변환이 일어남!
		double avg2 = sum/3.0;
		System.out.printf("국어 : %d, 영어 : %d, 수학 : %d \n", korea, eng, math);
		System.out.printf("총점 : %d, 평균 : %.2f \n", sum, avg);		
		System.out.printf("총점 : %d, 평균 : %.2f \n", sum, avg2);		
	}

}
