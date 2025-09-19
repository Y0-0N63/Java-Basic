package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
	Scanner sc = new Scanner(System.in);

	public void ex1() {
		// 변수 vs 배열

		// 변수 선언
		int num;

		// 변수 대입
		num = 10;

		// 변수 사용
		System.out.println("num에 저장된 값 : " + num);

		System.out.println("==========");

		// 배열 선언
		int[] arr;

		// 배열 할당
		arr = new int[3];

		// 주소값이 출력됨
		System.out.println("arr : " + arr);

		// Heap 영역에 생성된 공간은 비어있지 않음 -> JVM이 지정한 기본값인 0 출력
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println("-----------");

		// 배열 요소 값 대입
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 100;

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println("-----------");

		// 배열이 가진 모든 요소의 실제 값을 알고 싶을 때
		// >> Arrays*클래스*.toString([배열명])*메서드*; => String 형태로 반환
		System.out.println(Arrays.toString(arr));
	}

	public void ex2() {
		// 배열의 선언 및 할당
		int[] arr = new int[4];
		// arr[0~3] 전부 JVM에 의해 0으로 초기화 되어 있는 상태
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		arr[3] = 400;

		// 배열과 for문
		// 배열의 길이 : 배열이 몇 칸으로 이루어져있는가 >> 배열명.length;
		System.out.println("배열의 길이 : " + arr.length);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 100;
			System.out.printf("arr[%d]에 저장된 값 :  %d\n", i, arr[i]);
		}

		System.out.println("=============");

		// stack 영역에 int[] 자료형 공간을 4byte 할당 >> arr2라는 이름 부여
		// >> Heap 메모리 영역에 int 5칸짜리 배열 생성 >> 0번 인덱스부터 1~5 정수값 대입
		// int[] 주소값을 arr2 참조변수가 참조 중
		int[] arr2 = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(arr2));
	}

	public void ex3() {
		double[] height = new double[5];
		double sum = 0;

		// 5명의 키(cm)를 입력받고 평균 구하기
		for (int i = 0; i < height.length; i++) {
			System.out.print((i + 1) + "번 키 입력 : ");
			height[i] = sc.nextDouble();
			sum += height[i];
		}

		System.out.printf("\n평균 : %.2f cm", sum / height.length);
	}

	public void ex4() {
		// 입력 받은 인원 수 만큼의 점수를 입력받아 배열에 저장
		// 입력 완료 >> 점수 합계, 평균 출력
		System.out.print("입력 받을 인원 수 : ");
		int student = sc.nextInt();
		int[] score = new int[student];
		int scoreSum = 0;

		System.out.println();
		for (int i = 0; i < score.length; i++) {
			System.out.print((i + 1) + "번 점수 입력 : ");
			score[i] = sc.nextInt();
			scoreSum += score[i];
		}

		System.out.println();
		System.out.println("합계 : " + scoreSum);
		System.out.printf("평균 : %.2f\n", (double) scoreSum / student);
	}

	public void ex5() {
		// 점심 메뉴 뽑기 프로그램
		String[] arr = { "김밥", "서브웨이", "햄버거", "백반", "국법", "짜장면" };

		System.out.println("오늘 점심 메뉴 : " + arr[(int) (Math.random() * 6)]);
	}

	public void ex6() {
		// 배열을 이용한 검색
		int[] arr = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

		System.out.print("정수 입력 : ");
		int input = sc.nextInt();

		// 검사 전 >> 못 찾았다고 가정
		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {
			if (input == arr[i]) {
				System.out.println(i + "번째 인덱스에 존재");
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("존재하지 않음");
		}
	}

	public void ex7() {
		// 입력받은 값과 일치하는 값이 있으면 인덱스 번호 출력, 없으면 "존재하지 않음"
		String[] arr = { "사과", "딸기", "바나나", "키위", "멜론", "아보카도" };

		System.out.print("과일 입력 : ");
		String input = sc.next();
		System.out.println();

		boolean exist = false;

		for (int i = 0; i < arr.length; i++) {
			if (input.equals(arr[i])) {
				System.out.println(i + "번째 인덱스에 존재");
				exist = true;
			}
		}

		if (!exist) {
			System.out.println("존재하지 않음");
		}
	}

	public void ex8() {
		// 문자열 입력 > 알파벳 한 글자씩 잘라내어 > char 배열에 순서대로 저장 >
		// 문자 하나를 입력받아 > 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		// 일치하는 문자가 없음 >> "존재하지 않습니다"
		// 배열 검색, 문자열의 길이 구하기(String.length)
		// String.charAt : 문자열에서 특정 index에 위치한 문자 하나 얻어옴
		// count(숫자세기)

		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();

		// 1. 입력받은 문자 한 글자씩 잘라 char 배열에 순서대로 저장
		// 1-1. 입력받은 문자열 길이만큼의 char 배열 선언 및 할당하기
		char[] arr = new char[input.length()];

		// 1-2. 입력한 문자열을 한 글자씩 잘라내어 char 배열의 모든 요소에 순서대로 값 대입
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		System.out.println(Arrays.toString(arr));

		// 2. 문자 하나 입력받아 일치하는 문자가 char 배열에 몇 개 존재하는지?
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.next().charAt(0);
		// String.charAt(index) -> 문자형 ''
		// Scanner에는 char 형태의 입력받을 수 있는 메서드가 없어
		// String으로 우선 입력 >> 입력받은 String에서 CharAt(index)메서드 이용
		// 해당 index번째에 존재하는 문자 하나 떼어 char 자료형 형태로 반환

		// arr이라는 배열에 입력한 문자가 몇 개 존재하는지
		// 0번~index 마지막 번호 순회하며 검색
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			// arr[i] 값과 검색할 문자 ch가 같은 경우 >> count + 1
			if (ch == arr[i]) {
				count++;
			}
		}

		if (count > 0) {
			System.out.println(count + "개 있음");
		} else {
			System.out.println("존재하지 않음");
		}
	}

	public void ex8_1() {
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		System.out.println(Arrays.toString(arr));

		System.out.print("검색할 문자 입력 : ");
		char ch = sc.next().charAt(0);
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (ch == arr[i]) {
				count++;
			}
		}

		if (count > 0) {
			System.out.println(count + "개 있음");
		} else {
			System.out.println("존재하지 않음");
		}
		
		System.out.println("Hello WOrld");
	}

}
