package edu.kh.io.pack2.run;

import edu.kh.io.pack2.model.service.ByteService;

public class Run {

	public static void main(String[] args) {
		// String : 불변성 (Immutable)
		
		// 1. new 연산자 통해 만들기
//		String str1 = new String("Hello");
//		String str2 = new String("Hello");
//		System.out.println(System.identityHashCode(str1)); // 1705929636
//		System.out.println(System.identityHashCode(str2)); // 2036368507
//		// new 연산자를 통해 만든 객체는 다른 주소를 가짐
//		
//		str1 = str1 + "world";
//		System.out.println(System.identityHashCode(str1));
//		
//		System.out.println("============================");
		
//		// 2. 리터럴 표기법 이용해 만들기
//		String str3 = "Hello";
//		String str4 = "Hello";
//		System.out.println(System.identityHashCode(str3)); // 1785210046
//		System.out.println(System.identityHashCode(str4)); // 1785210046
//		// 리터럴 표기법을 이용해 만든 객체들은 > String 상수풀에 들어가기 때문에 > 같은 주소를 가짐
//		
//		str3 = str3 + "world";
//		System.out.println(System.identityHashCode(str3));
//		
//		System.out.println("============================");
//		
//		StringBuilder sb = new StringBuilder();
//		System.out.println(System.identityHashCode(sb));
//		sb.append("Hello World!");
//		sb.append("12345");
//		System.out.println(sb);
//		System.out.println(System.identityHashCode(sb));
		
		ByteService service = new ByteService();
//		service.fileByteOutput();
		service.bufferedFileByteOutput();
	}
}