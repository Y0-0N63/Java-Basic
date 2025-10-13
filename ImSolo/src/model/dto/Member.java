package model.dto;

import java.util.List;

public class Member {
	private String name;
	private int age;
	private String job;
	private String residence;
	private char gender;
	private List<String> hobby;
	
	public Member() {}

	public Member(String name, int age, String job, String residence, char gender, List<String> hobby) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.residence = residence;
		this.gender = gender;
		this.hobby = hobby;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return String.format("%s(%d, %s, %s) | 취미 : %s", name, age, job, residence, printHobby());
	}

	private Object printHobby() {
		// 전달된 List 객체의 요소를 연결해 하나의 문자열로 변환하기
		return String.join(", ", hobby);
	}
}
