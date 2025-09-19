package edu.kh.variable;

public class VariableExample2 {

	public static void main(String[] args) {
		boolean booleanData; // 변수의 선언
		// 자료형  변수명  ;
		// 메모리에 논리값(t/f)을 저장할 공간을 1byte 할당(선언)한 후
		// 할당된 공간의 이름을 booleanData라고 정하겠당.
		
		booleanData = true; // 변수 booleanData에 true라는 논리값을 대입 (초기화)
		
		System.out.println("booleanData : " + booleanData);

		byte byteData;
		// 메모리에 정수값을 저장할 공간을 1byte 할당
		// 할당된 공간의 이름을 byteData라고 정하겠따.
		
		// 변수의 선언과 동시에 대입(초기화)
		byte byteNumber = 127; // 값의 범위 (-128~127)
		
		short shortNumber = 32767; // 값의 범위 (-32768~32767)
		
		// 정수 자료형 중 대표 자료형
		int intNumber = 2147483647;
		
		long longNumber = 10000000000L; // 'L'이 없으면 int(정수형의 대표)로 인식
		
		float floatNumber = 1.2345f; // 모든 실수 값은 double(실수형의 대표)로 인식
		
		double doubleNumber = 3.141592;
		// double은 실수형 중 대표로, 리터럴 표기법이 없어도 되나 D/d를 쓸 수는 있음
		
		// 문자형 (char)의 리터럴 표기법 : ' '(홑따옴표) -> 문자 하나
		char ch = 'A';
		char ch2 = 66;
		
		System.out.println("ch : " + ch);
		System.out.println("ch2 : " + ch2);
		
		System.out.println();
		
		// 변수 명명 규칙
		// 1. 대소문자 구분, 길이 제한 X
		int abcdefg123456789;
		int ABCDEFG123456789;
		
		// 2. 예약어 사용 X > 해당 값이 내포하는 의미가 존재해서 안 됨
		// double final;
		
		// 3. 숫자 시작 X (숫자 포함은 가능!)
		// int 1a = 10;
		// char 1abc;
		char abc1;
		
		// 4. 특수문자는 $, _만 사용 가능하나, 웬만하면 사용하지 않음
		int $intNumb;
		int int_Num; // 사용은 가능하나, 카멜케이스 사용
		// _의 사용 : DB, 자바의 상수(대문자로 써야 함, ex) PI_VALUE) 등
		
		// 5. 카멜표기법 사용 (맨 처음 소문자 시작, 후속 단어 첫 글자만 대문자)
		char helloWorldAppleBananaTomato;
		
		// 6. 변수명은 언어를 가리지 않음 > 영어만 가능한 건 아님!, 추천은 X
		int 정수1번;
		double 실수2번 = 3.141592;
		System.out.println(실수2번);
		
		final double PI_VALUE = 3.141592;
//		PI_VALUE = 2.23; //재대입 불가
		
		final int MIN_AGE = 1;
		final int MAX_AGE = 130;
		final int LEFT_MOVE = -1;
	}
}
