package edu.kh.variable;

public class VariableExample3 {

	public static void main(String[] args) {
		// 형변환 (casting) : 값의 자료형을 변환하는 것
		int num1 = 10;
		double num2 = 3.5;
		
		// '자동형변환' 덕분에 에러가 발생하지 않음
		System.out.println("자동 형변환 결과 : " + (num1 + num2));
		
		// int -> long 형변환
		int i2 = 2_100_000_000; // 21억, ','로 구분하는 것처럼 '_'로 구분할 수 있음
		long l2 = 10_000_000_000L; // 100억
		long result = i2 + l2;
		System.out.println("자동 형변환 결과 : " + result);
		
		// char -> int 형변환
		// char는 V의 숫자값(유니코드 값)을 저장하고 있기 때문에 가능
		char ch3 = 'V';
		System.out.println(ch3);
		int i3 = ch3;
		System.out.println(i3);
		
		System.out.println();
		
		// '각' 이라는 글자는 숫자 몇일까?
		char ch6 = '각';
		int i6 = ch6;
		// ch6은 char 형태이기 때문에 그냥 '각'이 출력됨 
		System.out.println(i6);
	}

}
