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
			if (i == arr.length - 1) {
				System.out.println(arr[i]);
			} else {
				System.out.print(arr[i] + ", ");
			}
		}
	}

	public void practice9() {
		int arr[] = new int[10];
		System.out.print("발생한 난수 : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}

	public void practice10() {
		int arr[] = new int[10];
		System.out.print("발생한 난수 : ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}

		int max = 1;
		int min = 10;
		
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];

			if (min > arr[i])
				min = arr[i];
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}

	public void practice11() {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);

			// `j < i`를 `j < arr.length`라고 작성할 경우
			// 배열이 채워지지 않은 상태에서 배열 전체를 순회하며 중복을 검사하게 되어 작동 X
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice12() {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);

			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(lotto);

		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}

	public void practice13() {
		System.out.print("문자열 : ");
		String input = sc.nextLine();
		char[] arr = new char[input.length()];

		char alphabet = 'a';
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.charAt(i);
		}
		
		char[] result = new char[input.length()];
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] == input.charAt(j)) {
					break;
				} else {
					result[i] += arr[i]; 
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	public void practice14() {
		// 1. 첫 번째 배열 크기 지정
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼에 남은 개행 문자 제거
		
		String[] arr = new String[size];
		
		// 2. 첫 배열에 저장할 문자열 입력받기
		for(int i = 0; i < arr.length; i++) {
			System.out.print((i + 1) + "번째 문자열 : ");
			arr[i] = sc.nextLine();
		}
		
		// 3. 반복이 시작되는 구간부터 while 작성 > 내부에 종료 조건 만들어 break;
		while(true) {
			System.out.print("더 값을 입력하시겠습니까?(Y/N) : ");
			char input = sc.next().charAt(0);
			
			// 4. 값을 더 입력할 겅우
			if(input == 'y' || input == 'Y') {
				// 5. 더 입력받을 개수 입력받기
				System.out.print("더 입력받을 개수 입력받기 : ");
				int addSize = sc.nextInt();
				sc.nextLine(); // 입력 버퍼~
				
				// 6. 새로 값을 입력받을 배열 생성 >> 기존 배열 + addSize(추가 입력)의 크기
				String[] newArr = new String[arr.length + addSize];
				
				// 7. 배열 복사 + 새로운 문자열 입력받기
				for(int i = 0; i < newArr.length; i++) {
					// 현재 인덱스 값 < 기존 배열 >> 깊은 복사
					if(i < arr.length) {
							newArr[i] = arr[i];						
					}
					// 현재 인덱스 값 > 기존 배열 >> 새로운 값 입력받기
					else {
						System.out.print((i + 1) + "번째 문자열 : ");
						newArr[i] = sc.nextLine();
					}
				}
				
				// 8. 기존 배열 공간 참조하던 변수 arr에 새로운 배열 공간의 주소 가진 newArr 대입 (얕은 복사)
				arr = newArr;
				
			} else if(input == 'n' || input == 'N') {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		
		
		// 9. 배열 값 출력
		System.out.println(Arrays.toString(arr));
	}
}
