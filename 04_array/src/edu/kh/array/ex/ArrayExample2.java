package edu.kh.array.ex;

import java.util.Arrays;

public class ArrayExample2 {
	
	public void shallowCopy() {
		// 얕은 복사
		// : 주소 복사 > 서로 다른 두 참조 변수가 > 하나의 배열(or 객체) 참조하는 상태
		int[] arr = { 1, 2, 3, 4, 5 };

		int[] copyArr = arr;

		System.out.println("arr 주소 : " + arr);
		System.out.println("copyArr 주소 : " + copyArr);
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr 요소 : " + Arrays.toString(copyArr));

		// 복사본 배열 값을 변경
		copyArr[2] = 999;

		System.out.println("\n 변경 후 \n");
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr 요소 : " + Arrays.toString(copyArr));
	}

	public void deepCopy() {
		// 깊은 복사
		// : 같은 자료형의 새로운 배열을 만들어 기존 배열의 데이터를 모두 복사하는 방법

		int[] arr = { 1, 2, 3, 4, 5 };

		// 1. for문을 이용한 깊은 복사
		int[] copyArr1 = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			copyArr1[i] = arr[i];
		}

		System.out.println("arr 주소 : " + arr);
		System.out.println("copyArr1 주소 : " + copyArr1);
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr 요소 : " + Arrays.toString(copyArr1));

		System.out.println("=============");
		// 2. System.arraycopy(원본배열명, 원본 복사 시작 인덱스,
		// 복사할 배열명, 복사배열의 삽입 시작 인덱스 번호, 복사 길이);
		int[] copyArr2 = new int[arr.length];
		System.arraycopy(arr, 0, copyArr2, 0, arr.length);
		System.out.println("arr 주소 : " + arr);
		System.out.println("copyArr2 주소 : " + copyArr2);
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr2 요소 : " + Arrays.toString(copyArr2));

		System.out.println("==============");
		// 3. 복사할 참조변수 = Arrays.copyOf(원본배열명, 복사할 길이);
		int[] copyArr3 = Arrays.copyOf(arr, arr.length);
		System.out.println("arr 주소 : " + arr);
		System.out.println("copyArr2 주소 : " + copyArr3);
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr3 요소 : " + Arrays.toString(copyArr3));

		System.out.println("==============");
		copyArr1[2] = 0;
		copyArr2[2] = 999;
		copyArr3[2] = 5000;
		System.out.println("arr 요소 : " + Arrays.toString(arr));
		System.out.println("copyArr1 요소 : " + Arrays.toString(copyArr1));
		System.out.println("copyArr2 요소 : " + Arrays.toString(copyArr2));
		System.out.println("copyArr3 요소 : " + Arrays.toString(copyArr3));
	}

	public void createLottoNum() {
		// 배열을 이용한 중복 데이터 제거 + 정렬
		// 1~45 사이, 중복되지 않은 난수 6개 생성 > 생성된 난수를 오름차순으로 정렬

		// 1. 6개 정수 저장할 배열 선언 및 할당
		int[] lotto = new int[6];

		// 2. 생성된 배열(lotto)을 처음부터 끝까지 순차 접근하는 for문 작성
		for (int i = 0; i < lotto.length; i++) {
			// 3. 1~45 난수 생성
			int random = (int)(Math.random() * 45 + 1);
			// 4. 생성된 난수를 순서대로 배열 요소에 대입
			lotto[i] = random;
			
			// 5. 중복 검사를 위한 for문 작성
			for(int x = 0; x < i; x++) {
				// 6. 현재 생성된 난수가 배열의 요소에 존재하는지
				if(random == lotto[x]) {
					// 만약 존재할 때 > 난수를 새로 하나 더 생성해야 하므로
					// i의 값을 인위적으로 감소시켜 > 난수 발생 기회를 다시 +1
					i--;
					// 앞쪽에서 중복 데이터 발견 > 남은 값 비교할 필요 X
					// => 효율 향상을 위해 중복 검사용 for문 종료
					break;
				}
			}
		}
		
		// 7. 정렬 : 선택, 삽입, 버블, 퀵 등... > 미리 만들어서 제공 중
		// Arrays.sort(배열명) : 배열 내 요소값들이 오름차순 정렬됨
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
}
