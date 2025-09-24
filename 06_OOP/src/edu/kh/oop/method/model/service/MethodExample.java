package edu.kh.oop.method.model.service;

public class MethodExample {
	// 메소드 호출할 때마다, Stack 자료구조에 메서드 실행 이력이 쌓임
	// main -> method1 -> method2, 마지막에 쌓인 순서대로 스택에서 나감(LIFO, 후입선출)
	public void method1() {
		int result = method2(3, 5);
		System.out.println(result);
		// return; 생략된 상태 > 없으면 컴파일러가 자동생성해줌!
		// 해당 메서드 종료 후 호출한 곳으로 돌아감
	}
	
	public int method2(int a, int b) {
		int sum = a + b;
		return sum;
		// return 값; 반환값이 있는 상태 (값은 컴파일러가 자동생성해주지 않음!)
		// 해당 메서드 종료 > 호출한 곳으로 값을 가지고 되돌아감
	}
}
