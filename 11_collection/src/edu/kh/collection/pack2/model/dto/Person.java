package edu.kh.collection.pack2.model.dto;

import java.util.Objects;

public class Person {
	private String name;
	private int age;
	private char gender;
	
	public Person() {}
	
	public Person(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	// 객체가 같다(동일, 동등)의 차이
	// 동일 : 메모리 주과 같음, hashCode(), 동등 : 각 객체 내부에 저장된 값이 같음, equals()

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}
	
}
