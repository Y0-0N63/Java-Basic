package edu.kh.poly.ex2.model.dto;

// 추상 클래스 (미완성 클래스) : 추상 메서드(미완성 메서드)를 보유하고 있는 클래스
//   : 객체로 만들 수 없는 클래스
public abstract class Animal {
	// 속성
	private String type;
	private String eatType;

	public Animal() {
	}

	public Animal(String type, String eatType) {
		super();
		this.type = type;
		this.eatType = eatType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}

	// 동물의 공통 기능 추출(추상화) > 공통적으로 먹고, 숨쉬고, 움직임
	// 어떤 동물이냐에 따라 그 방법이 모두 다름! >> 해당 클레스에서 자세하게 메서드 정의를 할 수 었음
	// 미완성 상태로 메서드 만들어 > 상속받은 자식들이 해당 메서드를 자식 본인에게 맞는 정의를 하도록 오버라이딩 강제화
	// >> 추상 메서드(Abstract method)로 작성

	public abstract void eat();

	public abstract void breathe();
	
	public abstract void move();
	
	public void ex() {
		System.out.println("이 메서드는 평범한 메서드...");
	}

	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
}
