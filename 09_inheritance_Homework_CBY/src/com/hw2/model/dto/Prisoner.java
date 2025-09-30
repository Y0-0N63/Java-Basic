package com.hw2.model.dto;

public class Prisoner extends Person {
	private String position;
	
	public Prisoner(String id, String name, String position) {
		super(id, name);
		this.position = position;
	}

	@Override
	public String getInfo() {
		return "ID : " + id + " , 이름 : " + name + " , 죄목 : " + position;
	}
}
