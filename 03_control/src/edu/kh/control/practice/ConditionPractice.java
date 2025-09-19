package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {
	// 필드	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.print("숫자를 한 개 입력하세요 : ");
		int input = sc.nextInt();
		
		if (input <= 0) {
			System.out.println("양수만 입력해주세요.");
		} else {
			if(input % 2 == 0) {
				System.out.println("짝수입니다.");
			} else {
				System.out.println("홀수입니다.");
			}
		}
	}
	
	public void practice2() {
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor + math + eng;
		double avg = sum/3.0;
		
		if (kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.printf("국어점수 : %d\n수학점수 : %d\n영어점수 : %d\n합계 : %d\n평균 : %.1f\n축하합니다, 합격입니다!", kor, math, eng, sum, avg);
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	public void practice3() {
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12 :  System.out.println(month + "월은 31일까지있습니다.") ; break;
		case 4, 6, 9, 11 : System.out.println(month + "월은 30일까지있습니다."); break;
		case 2 : System.out.println(month + "월은 28일까지있습니다."); break;
		default : System.out.println(month + "월은 잘못 입력된 달입니다.");
		}
	}
	
	public void practice4() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		double bmi = weight / (height*height);
		
		System.out.println("BMI 지수 : "+ bmi);
		
		if (bmi < 18.5) {
			System.out.println("저체중");
		} else if(bmi < 23) {
			System.out.println("정상체중");
		} else if(bmi < 25) {
			System.out.println("과체중");
		} else if(bmi < 30) {
			System.out.println("비만");
		} else {
			System.out.println("고도 비만");
		}
	}
	
	public void practice5() {
		System.out.print("중간 고사 점수 : ");
		double mid = sc.nextDouble() * 0.2;
		System.out.print("기말 고사 점수 : ");
		double fin = sc.nextDouble() * 0.3;
		System.out.print("과제 점수 : ");
		double assign = sc.nextDouble() * 0.3;
		System.out.print("출석 횟수 : ");
		double attend = sc.nextDouble();
		double score = mid + fin + assign + attend;
		
		System.out.println("================= 결과 =================");
		
		if(attend <= 20*0.7) {
			System.out.printf("Fail [출석 횟수 부족 (%.0f/20)]", (int) attend);
		} else {
			System.out.printf("중간 고사 점수(20) : %.1f\n기말 고사 점수(30) : %.1f\n과제 점수 (30) : %.1f\n출석 점수(20) : %.1f\n총점 : %.1f\n", mid, fin, assign, attend, score);
			if(score < 70) {
				System.out.println("Fail [점수 미달]");
			} else {
				System.out.println("PASS");
			}
		}
			}
}
