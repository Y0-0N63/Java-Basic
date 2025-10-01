package edu.kh.collection.pack1.model.dto;

// 인터페이스를 상속받았으므로 > 추상 메서드 오버라이딩 필수!
public class Student implements Comparable<Student> {
	
	// 속성
	private String name;
	private int age;
	private String region;
	private char gender;
	private int score;
	
	public Student() {}
	
	public Student(String name, int age, String region, char gender, int score) {
		super();
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.score = score;
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", score="
				+ score + "]";
	}

	@Override
	public int compareTo(Student o) {
		// compareTo() : 두 객체 비교하고 순서 결정 > 반환값 : 0(같음), 양수(왼쪽 객체가 더 큼), 음수(왼쪽 객체가 더 작음)
		// o == other
		// 나이를 기준으로 오름차순 정렬
//		return this.age - o.age;
		
		// 나이를 기준으로 내림차순 정렬
		return o.age - this.age;
	}
}
