package edu.kh.control.condition;

import java.util.Scanner;

public class ConditionExample {
	// field 변수, 클래스 안에 들어오자마자 전역적으로 만들어주는 변수
	Scanner sc = new Scanner(System.in);
	
	// 메서드 (+ 생성자)
	public void ex1() {
		// 입력받은 정수가 양수인지 검사 > "양수입니다"
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다.");
		} 
		
		if(input <= 0) {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	public void ex2() {
		// 홀짝 검사 > "홀수입니다", "짝수입니다", "0입니다"
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		if(input % 2 != 0) {
			System.out.println("홀수입니다.");
		} else {
			if(input % 2 == 0) {
				System.out.println("짝수입니다.");
			} else {
				if(input == 0) {
					System.out.println("0입니다.");
				} else {
					System.out.println("짝수입니다.");
				}
			}
		}
//		if(input % 2 == 0) {
//			System.out.println("짝수입니다.");
//		} else if (input % 2 != 0) {
//			System.out.println("홀수입니다.");
//		} else if (input == 0) {
//			System.out.println("0입니다.");
//		}
		
	}
	
	public void ex3() {
		// if(조건식) - else if(조건식) - else
		// 양수, 음수, 0 판별
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다.");
		} else if(input < 0) {
			System.out.println("음수입니다.");
		} else {
			System.out.println("0입니다.");
		}
	}
	
	public void ex4() {
		// 달(month)을 입력받아 해당 달에 맞는 계절 출력
		// 1, 2, 12 : 겨울 / 3, 4, 5 : 봄 / 6, 7, 8 : 여름 / 9, 10, 11 : 가을
		// 겨울, 여름 온도 입력 > -15도 이하 "겨울 한파 경보", -12도 이하 "겨울 한파 주의보"
		// 35도 이상 "여름 폭염 경보", 33도 이상 "여름 폭염 주의보"
		// 1~12가 아닌 수 > "해당하는 계절이 없습니다"
		
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		
		String season;
		
		if(month == 1 || month == 2 || month == 12) {
			season = "겨울";
			System.out.print("온도 입력 : ");
			int temp = sc.nextInt();
			if(temp <= -15) {
				season += " 한파 경보";
			} else if(temp <= -12) {
				season += " 한파 주의보";
			}
		} else if(month >= 3 && month <= 5) {
			season = "봄";
		} else if(month >= 6 && month <=8) {
			season = "여름";
			System.out.print("온도 입력 : ");
			int temp2 = sc.nextInt();
			if(temp2 >= 35) {
				season += "  폭염 경보";
			} else if(temp2 >= 33) {
				season += " 폭염 주의보";
			}
		} else if(month >= 9 && month <= 11) {
			season = "가을";
		} else {
			season = "해당하는 계절이 없습니다.";
		}
		System.out.println(season);
	}

	public void ex5() {
		// 나이 입력>13세 이하 "어린이 입니다", 13세 초과 19세 이하 "청소년", 19세 초과 "성인"
		System.out.print("나이 입력 : ");
		String result;
		int age = sc.nextInt();
		if(age <= 13) {
			result = "어린이";
		} else if(age <= 19) {
			result = "청소년";
		} else {
			result = "성인";
		}
		System.out.println(result + "입니다.");
	}
	
	public void ex6() {
		// 점수 입력> 90점 이상 : A, 80이상~90 : B, 70~80 : C, 60~70 : D, 60 미만 : F
		// 0점 미만, 100점 초과 : "잘못 입력하셨습니다."
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		String grade = "";
		if (score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다.");
		} else if (score >= 90) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 70) {
			grade = "C";
		} else if (score >= 60) {
			grade = "D";
		} else if (score < 60) {
			grade = "F";
		} 
		System.out.print(grade);
	}
	
	public void ex7() {
		System.out.print("나이 입력 : ");
		int age1 = sc.nextInt();
		String result;
		
		if(age1 < 0 || age1 > 100) {
			result = "잘못 입력하셨습니다.";
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextInt();
			
			if(age1 < 12) {
				result = "적정 연령이 아닙니다.";
			} else if(height < 140.0) {
				result = "적정 키가 아닙니다.";
			} else {
				result = "탑승 가능";
			}	
		}
		
		System.out.println(result);
	}
	
	public void ex8() {
		System.out.print("나이 입력 : ");
		int age2 = sc.nextInt();
		String result2 = "";
		
		if (age2 < 0 || age2 >100) {
			result2 = "나이를 잘못 입력하셨습니다.";
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			
			if(height < 0 || height > 250.0) {
				result2 = "키를 잘못 입력하셨습니다.";
			} else {
				if(age2 < 12) {
					if(height < 140.0) {
						result2 = "나이와 키 모두 적절치 않음";
					} else {
						result2 = "키는 적절하나, 나이는 적절하지 않음";
					}
				} else {
					if(height < 140.0) {
						result2 = "나이는 적절하나, 키가 적절치 않음";
					} else {
						result2 = "탑승 가능!!!";
					}
				}
			}
		}
		System.out.println(result2);
	}

	public void ex9() { 
		// switch : 여러 case 중 하나를 선택해 수행하는 조건문
		// 요일 번호(1~7) ex) 3 선택 > 수요일
		System.out.print("요일 번호 입력 : ");
		int day = sc.nextInt();
		
		switch(day) {
		case 1 : System.out.println("월요일"); break;
		case 2 : System.out.println("화요일"); break;
		case 3 : System.out.println("수요일"); break;
		case 4 : System.out.println("목요일"); break;
		case 5 : System.out.println("금요일"); break;
		case 6 : System.out.println("토요일"); break;
		case 7 : System.out.println("일요일"); break;
		default : System.out.println("잘못된 입력입니다.");
		}
	}

	public void ex10() {
		// 0~100 사이 나눈 점수 입력받아>10으로 나눈 몫이>10, 9 : A
		// 8 > B, 7 > C, 6 > D, 그 외(5~0) F 출력
		
		System.out.print("점수 입력(0~100) : ");
		int score = sc.nextInt();
		
		switch(score/10) {
		case 10, 9 : System.out.println("학점 : A"); break;
		case 8 : System.out.println("학점 : B"); break;
		case 7 : System.out.println("학점 : C"); break;
		case 6 : System.out.println("학점 : D"); break;
		case 5, 4, 3, 2, 1, 0 : System.out.println("학점 : F"); break;
		default : System.out.println("잘못된 점수");
		}
	}
}
