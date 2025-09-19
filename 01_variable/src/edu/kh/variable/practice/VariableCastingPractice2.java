package edu.kh.variable.practice;

public class VariableCastingPractice2 {

	public static void main(String[] args) {
		// 문제 1
		String name = "영숙";
		int age = 28;
		double height = 165.7;
		
		// 문제 2
		System.out.printf("출연자 이름 : %s \n나이 : %d \n키 : %.1fcm \n", name, age, height);
		
		// 문제 3
		double age2 = age;
		System.out.println("자동 형변환된 나이(double) : " + age2);
		
		// 문제 4
		int height2 = (int)height;
		System.out.println("자동 형변환된 키(int) : " + height2);
		
		// 매칭 점수 평균	
		int score1 = 87, score2 = 92;
		double avg = ((double)score1 + (double)score2)/2;
		double avg2 = (score1 + score2)/2.0;
		System.out.println("영숙 님의 매칭 점수 평균은 " + avg + "점입니다!");
		System.out.println("영숙 님의 매칭 점수 평균은 " + avg2 + "점입니다!");
	}

}
