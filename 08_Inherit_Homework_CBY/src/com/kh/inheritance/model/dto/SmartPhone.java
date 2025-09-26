package com.kh.inheritance.model.dto;

public class SmartPhone extends Phone{
	private String operatingSystem;
	private int storageCapacity;
	
	public SmartPhone() {}

	public SmartPhone(String brand, String model, int year, int price, String operatingSystem, int storageCapacity) {
		super(brand, model, year, price);
		this.operatingSystem = operatingSystem;
		this.storageCapacity = storageCapacity;
	}
	
	@Override
	public void printInfo() { 
		super.printInfo();
		System.out.println("Operating System : " + operatingSystem + "\nStorage Capacity : " + storageCapacity + "GB");
	}
	
}
