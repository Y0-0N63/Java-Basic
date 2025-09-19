package edu.kh.variable;

// class : 코드를 작성하는 곳
public class VariableExample1 {

	public static void main(String[] args) {
		// 변수 미사용
		System.out.println(2 * 3.141592653589793 * 5); // 원의 둘레
		System.out.println(3.141592653589793 * 5 * 5); // 원의 넓이
		System.out.println(3.141592653589793 * 5 * 5 * 20); // 원기둥의 부피
		System.out.println(3.141592653589793 * 4 * 5 *5); // 구의 겉넓이
		
		System.out.println();
		
		// 변수 사용
		double pi = 3.141592653589793;
		int r = 5;
		int h = 20;
		
		System.out.println(2 * r * pi);
		System.out.println(pi * r * r);
		System.out.println(pi * r * r * h);
		System.out.println(pi * 4 * r * r);
	}
}
