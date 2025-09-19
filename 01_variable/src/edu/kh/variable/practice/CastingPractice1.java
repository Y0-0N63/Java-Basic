package edu.kh.variable.practice;

public class CastingPractice1 {

	public static void main(String[] args) {
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1/iNum2); // 2
		System.out.println((int) dNum); // 2
		System.out.println(iNum2 * dNum); // 10.0 (int(-> double) x double 자동 형변환)
		System.out.println((double) iNum1); // 10.0

		System.out.println((double) iNum1 / (double) iNum2); // 2.5
		// 우선 순위 : 형변환 > 계산 => float으로 형변환 시키면, int -> float 자동 형변환도 따라옴
		System.out.println(iNum1 / (float) iNum2); // 2.5
		
		System.out.println(dNum); // 2.5
		System.out.println((int) fNum); // 3
		System.out.println((int) (iNum1 / fNum)); // 3

		// float : 소수점 아래 8번째 자리까지 연산 후 반올림
		// => double에 비해, 정밀도가 낮음
		System.out.println(iNum1 / fNum);// 3.3333333

		// double : 소수점 아래 16번째 자리까지 연산 후 반올림 
		// 정밀도가 높아 마지막 값이 5 (근사치를 절삭하는 데 있어 비교적 세세함)
		System.out.println((double) iNum1 / (double) fNum); // 3.3333333333333335
		System.out.println(iNum1 / (double) fNum); // 3.3333333333333335
		
		System.out.println("'" + ch + "'"); // 'A'
		System.out.println((int) ch); // 65
		
		// char은 int형과 연산 시, char이 자동 형변환
		System.out.println((int) ch + iNum1); // 75
		System.out.println(ch + iNum1); // 75
		
		System.out.println("'" + (char) (ch + iNum1) + "'"); // 'K'
	}
}
