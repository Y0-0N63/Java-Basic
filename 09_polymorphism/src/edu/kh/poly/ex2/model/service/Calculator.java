package edu.kh.poly.ex2.model.service;

//  계산기 인터페이스 > 모든 계산기에대한 공통 필드, 기능명 제공하는 접점 용도
public interface Calculator {

	// 속성(필드)
	public static final double PI = 3.14;
	static final int MAX_NUM = 100000;
	public int MIN_NUM = -100000;
	int ZERO = 1; //묵시적
	
	// 기능, 메서드는 묵시적으로 public abstract
	public abstract int plus (int num1, int num2);
	
	public abstract int minus (int num1, int num2);
	
	public abstract int divide(int num1, int num2);

	public abstract int multiple(int num1, int num2);
}

