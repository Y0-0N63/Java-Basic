package edu.kh.array2.ex;

import java.util.Arrays;

public class Array2Example {
	public void ex1() {
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 할당
		arr = new int[2][3];
	
		// 2차원 배열 초기화
		// 1) 행, 열 인덱스 이용해 직접 초기화
//		arr[0][0] = 10;
//		arr[0][1] = 20;
//		arr[0][2] = 30;
//		
//		arr[1][0] = 40;
//		arr[1][1] = 50;
//		arr[1][2] = 60;
		
		// 2) 2중 for문을 이용한 초기화
//		int num = 10;
//		// 행 길이 (배열이 참조하고 있는 2차원 배열의 행 길이)
//		System.out.println(arr.length);
//		// 열 길이 (참조하고 있는 1차원 배열의 값을 문자열로 반환)
//		System.out.println(arr[0].length);
//		System.out.println(arr[0].length);
//		
//		for(int row = 0; row < arr.length; row++) {
//			for(int col = 0; col < arr[row].length; col++) {
//				arr[row][col] = num;
//				num += 10;
//			}
//		}
		
		// 3) 선언과 동시에 초기화
		int[][] arr2 = {{10, 20, 30}, {40, 50, 60}};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr));		
		
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.deepToString(arr2));		
	}
	
	public void ex2() {
		// 2차원 배열 선언과 동시에 초기화 : 3행 3열짜리 정수 형태의 2차원 배열
		// 1~9까지 초기화
		int[][] arr = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		
		// 행별로 합출력 6, 15, 24
		for(int row = 0; row < arr.length; row++) {
			int sum = 0;
			for(int col = 0; col < arr[row].length; col++) {
				sum += arr[row][col];
			}
			System.out.printf("%d행의 합 : %d\n", row, sum);
		}
		
		System.out.println("===============");
		
		// 열 별로 합 출력
		// arr[0][0] + arr[1][0] + arr[2][0]
		//
		for(int col = 0; col < arr[0].length; col++) {
			int sum = 0;
			for(int row = 0; row < arr.length; row++) {
				sum += arr[row][col];
			}
			System.out.printf("%d열의 합 : %d\n", col, sum);
		}
	}
	
	public void ex3() {
		// char 2차원 배열 생성 시 행 부분만 생성
		char[][] arr = new char[4][];
		arr[0] = new char[3]; 
		arr[1] = new char[4]; 
		arr[2] = new char[5];
		arr[3] = new char[2];
		
		char ch = 'a';
		for(int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] = ch++;
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}
}
