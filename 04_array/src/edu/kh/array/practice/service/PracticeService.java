package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	Scanner sc = new Scanner(System.in);

	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1);
			System.out.print(arr[i] + " ");

			if (i % 2 == 0) {
				sum += arr[i];
			}
		}

		System.out.println("\n짝수 번째 인덱스 합 : " + sum);
	}

	public void practice2() {
		int[] arr = new int[9];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (9 - i);
			System.out.print(arr[i] + " ");

			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.println("\n홀수 번째 인덱스 합 : " + sum);
	}

	public void practice3() {
		System.out.print("양의 정수 : ");
		int num = sc.nextInt();

		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1);
			System.out.print(arr[i] + " ");
		}
	}

	public void practice4() {
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			System.out.print("입력 " + i + " : ");
			int input = sc.nextInt();
			arr[i] = input;
		}
		System.out.print("검색할 값 : ");
		int search = sc.nextInt();

		boolean exist = false;

		for (int i = 0; i < arr.length; i++) {
			if (search == arr[i]) {
				System.out.println("인덱스 : " + i);
				exist = true;
			}
		}
		if (!exist) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}

	public void practice5() {
		System.out.print("문자열 : ");
		String input = sc.nextLine();

		char[] arr = new char[input.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}

		System.out.print("문자 : ");
		char search = sc.next().charAt(0);
		int count = 0;

		System.out.print(input + "에 " + search + "가 존재하는 위치(인덱스) : ");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println("\n" + search + " 개수 : " + count);
	}

	public void practice6() {
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int sum = 0;

		for (int i = 0; i < num; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			int input = sc.nextInt();
			arr[i] = input;
			sum += input;
		}

		for (int i = 0; i < num; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n총 합 : " + sum);
	}

	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String num = sc.nextLine();
		char[] arr = new char[num.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = num.charAt(i);

			if (i < 8) {
				System.out.print(arr[i]);
			} else {
				System.out.print("*");
			}
		}
	}

	public void practice8() {
		int input;
		while (true) {
			System.out.print("정수 : ");
			input = sc.nextInt();

			if (input >= 3 && input % 2 == 1) {
				break;
			} else {
				System.out.println("다시 입력하세요.");
			}
		}

		int[] arr = new int[input];
		int j = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i < (int) (input / 2)) {
				arr[i] = j;
				j++;
			} else {
				arr[i] = j;
				j--;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}
	
	public void practice9() {
		int arr[] = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
		
		int max = 1;
		int min = 1;
		for(int i = 0; i < arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
			
			if(min > arr[i])
				min = arr[i];
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

}
