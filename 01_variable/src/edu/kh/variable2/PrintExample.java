package edu.kh.variable2;

public class PrintExample {

	public static void main(String[] args) {
		// System.out.println(); // 한 줄 출력용 메서드(출력 후 줄바꿈까지 수행)
		System.out.println("테스트 1");
		System.out.println("테스트 2");
		
		// System.out.print() : 단순 출력용 메서드 (출력 후 줄바꿈 X)
		System.out.print("테스트 3");
		System.out.println(); // 내용 없는 println() : 단순 줄바꿈
		System.out.print("테스트 4");
		
		System.out.println();
		
		// 10 + 5 = 15
		int iNum1 = 10;
		int iNum2 = 5;
		System.out.println(iNum1 + " + " + iNum2 + " = " + (iNum1 + iNum2));
		System.out.printf("%d + %d = %d \n", iNum1, iNum2, iNum1 + iNum2);
		
		// 10 + 10 * 5 / 2 = 35
		System.out.printf("%d + %d * %d / %d = %d \n", iNum1, iNum1, iNum2, 2, iNum1 + iNum1 * iNum2 / 2);
		
		int iNum3 = 3;
		System.out.printf("%d \n", iNum3);
		System.out.printf("%5d \n", iNum3);
		System.out.printf("%-5d \n", iNum3);
		
		// 소수점 자리 제어 (반올림 처리)
		System.out.printf("%f \n", 10 / 4.0);
		System.out.printf("%.2f \n", 10 / 4.0);
		
		// \
		System.out.println("\\");
		System.out.println("\\o/");
		
		// \t : tab (한 공간씩 표현 X, 한 번에 큰 공간 차지)
		System.out.println("a \t b \t c \t d");
		
		// 유니코드 이스케이프 (16진수 사용)
		System.out.println("\u0041");
	}
}
