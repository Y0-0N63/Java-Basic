package edu.kh.op.practice;

import java.util.Scanner;

public class OperationPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int person = sc.nextInt();
		sc.nextLine();
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		System.out.println();
		System.out.printf("1인당 사탕 개수 : %d\n남는 사탕 개수 : %d\n", (candy/person), (candy%person));
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(정수만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(정수만) : ");
		int stuClass = sc.nextInt();
		
		System.out.print("번호(정수만) : ");
		int stuNum = sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		// 입력 버퍼에 남은 개행 문자 지우기
		sc.nextLine();
		String sex = sc.nextLine();
		
		System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.println();
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade, stuClass, stuNum, name, sex, score);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		System.out.println();
		System.out.printf("합계 : %d\n평균 : %.1f\n", sum, avg);
		
		// 각 과목이 40점 이상이고, 평균 60점 이상이어야 합격
		String result = (kor >= 40 && eng >= 40 && math >= 40) && (avg >= 60)? "합격입니다." : "불합격입니다";
		// boolean result = (kor >= 40) && (eng >= 40) && (math >= 40) && (avg >= 60)
		// System.out.println(result ? "합격" : "불합격");
		System.out.println(result);
	}
}


