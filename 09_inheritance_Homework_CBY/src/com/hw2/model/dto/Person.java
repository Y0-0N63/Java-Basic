package com.hw2.model.dto;

public abstract class Person {
	protected String id;
	protected String name;
	
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public abstract String getInfo();
}
