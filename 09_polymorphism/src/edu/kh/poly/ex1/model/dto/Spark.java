package edu.kh.poly.ex1.model.dto;

// 경차
public class Spark extends Car {
	private double discountOffer;
	
	public Spark() {
	}

	public Spark(String engine, String fuel, int wheel, double discountOffer) {
		super(engine, fuel, wheel);
		this.discountOffer = discountOffer;
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	@Override
	public String toString() {
		return super.toString() + " / " + discountOffer;
	}
}
