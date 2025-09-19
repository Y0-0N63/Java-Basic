package edu.kh.op.ex;

import java.util.Scanner;

// 예제 코드 작성용 클래스 (기능용, 메서드용)
public class OpExample {
	// 따라서 기능(메서드)만 모아둠
	public void ex1() {
		System.out.println("안녕!");
	}
	
	public void ex2() {
		System.out.println("점심모먹지그러게모먹지");
	}
	
	public void testEx1() {
		// 증감(증가와 감소) 연산자 : ++, --
		int iNum1 = 10;
		int iNum2 = 10;
		
//		iNum1++;
//		iNum2--;
		
		// 이어쓰기, 출력, 증감 연산 순서로 진행됨 >> 둘 다 10으로 출력 
		System.out.println("iNum1 = " + iNum1++);
		System.out.println("iNum2 = " + iNum2--);
		
		// 전위 연산
		int temp1 = 5;
		System.out.println(++temp1 + 5);
		
		// 후위 연산
		int temp2 = 3;
		// 3-- + 2 -> 5
		System.out.println(temp2-- +2);
		// 3-- > 2 (출력 연산까지 이루어진 후 후위 연산이 이루어짐)
		System.out.println(temp2);
		
		int a = 3;
		int b = 5;
		int c = a++ + --b;
		// a 4, b 4, c 7
		System.out.printf("%d / %d / %d\n\n", a, b, c);
	}
	
	public void testEx2() {
		// 비교 연산자 : 결과는 항상 논리값
		
		int a = 10;
		int b = 20;
		System.out.println((a == b) == false);
		
		int c = 4;
		int d = 5;
		System.out.println((++c != d) == (--c != d));
		System.out.println();
		
		System.out.println(100 > 99);
		System.out.println(100 >= 100);
		System.out.println(99<64);
		System.out.println(99 <= 100);
	}
	
	public void testEx3() {
		// 논리 연산자
		// &&(AND, 와, 그리고, ~면서, ~부터 ~까지, ~사이)
		// a는 100 이상이면서 짝수인가?
		int a = 101;
		System.out.println((a>=100) && (a%2 == 0));
		System.out.println((a>=100) && (a%2 != 0));
		System.out.println();
		
		// b는 1부터 10까지 숫자 범위에 포함되어 있는가?
		// == b는 1보다 크거나 같으면서, 10보다 작거나 같다
		int b = 5;
		System.out.println((b>=1) && (b<=10));
				
		// ||(OR) : 또는, 혹은, ~거나
		// c는 10을 초과하거나 짝수인가?
		int c = 10;
		System.out.println((c > 10) || (c%2 == 0));
	}
	
	public void testEx4() {
		// 삼항 연산자
		// 조건식 ? true일 때 수행될 값 : false일 때 수행될 값 
		// 조건식 : 연산 결과가 true or false인 식 => 비교연산자를 사용해야 함
		
		// num이 30보다 크면(초과), "num은 30보다 큰 수 이다.", 그렇지 않으면 "num은 30 이하의 수이다"
		int num = 30;
		String result = num > 30 ? "num은 30보다 큰 수이다." : "num은 30 이하의 수이다";
		System.out.println(result);
	}
	
	public void test() {
		// 입력받은 정수가 음수인지 양수인지 구분, 0은 양수로 처리
		// 정수 입력 : (키보드로 직접 입력)
		// 양수입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		String inputResult = input < 0 ? "음수 입니다." : "양수 입니다.";
		System.out.println(inputResult);
	}
	
	public void testEx5() {
		// 복합대입 연산자, +=, -=, /=, %-
		int a = 10;
		a += 10;
		System.out.println(a);
		
		int b = 20;
		b -= 10;
		System.out.println(b);
		
		// 부정 연산자 : !논리값 = 논리값을 반대로 적용하는 것
		System.out.println(!true);
		
		System.out.println(!(10 != 10));
		
		// ~ : 비트 단위 부정(NOT 연산자)
		int c = 5;
		System.out.println(~c);		
	}
}
