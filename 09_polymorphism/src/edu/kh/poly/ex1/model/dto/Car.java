package edu.kh.poly.ex1.model.dto;

// 클래스가 아무것도 상속받지 않으면 내부적으로 Object를 상속받게 됨
public class Car /* extends Object */ {
	// 속성
	private String engine;
	private String fuel;
	private int wheel;
	
	// 기능 (메서드 + 생성자)
	public Car() {
	}

	public Car(String engine, String fuel, int wheel) {
		super();
		this.engine = engine;
		this.fuel = fuel;
		this.wheel = wheel;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	
	// Object.toString() 오버라이딩 : 부모 클래스(Object)에서 정의된 메서드(toString)를
	// 자식 클래스(Car)가 재정의하는 것
	@Override
	public String toString() {
		return engine + " / " + fuel + " / " + wheel;
	}
}
