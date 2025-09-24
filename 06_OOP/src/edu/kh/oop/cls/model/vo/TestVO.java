package edu.kh.oop.cls.model.vo;

class TestVO {
	// 접근제한자 자리에 아무것도 안 쓰면 > default
	
	public void ex() {
		Student std = new Student();
		System.out.println(std.v1);
		System.out.println(std.v2);
		System.out.println(std.v3);
//		System.out.println(std.v4); >> 같은 클래스까지만 직접 접근 가능
	}
}
