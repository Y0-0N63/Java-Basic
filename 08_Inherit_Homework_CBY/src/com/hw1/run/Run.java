package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 3명의 학생 정보 기록할 수 있게 객체 배열 할당
		Student[] stuArr = new Student[3];

		// 3명의 학생 정보 초기화
		stuArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stuArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stuArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");

		// 학생 정보 모두 출력
		// 향상된 for문
		// : 자바에서 배열, 컬렉션과 같은 데이터를 순차적으로 간단하게 반복할 수 있는 구조 제공
		// 일반적인 for문에 비해, 코드가 더 간결하고 가독성이 좋아 반복 작업을 쉽게 작성 가능
		// for(자료형 변수명 : 배열 또는 컬렉션) {
		// ~반복해서 실행할 코드 작성~
		// }

		for (Student std : stuArr) {
			System.out.println(std.information());
		}

		System.out.println("=========================");

		// 최대 10명의 사원 정보 기록할 수 있게 배열 할당
		Employee[] empArr = new Employee[10];

		// 현재 몇 명?
		int count = 0;

		// 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
		// 사원 정보 키보드로 입력 (while(true))
		while (true) {
			// 계속 추가할 것인지 질문 > 대소문자 관계 없이 'y'면 계속 객체 추가

			System.out.print("이름 : ");
			String inputName = sc.next();

			System.out.print("나이 : ");
			int inputAge = sc.nextInt();

			System.out.print("신장 : ");
			double inputHeight = sc.nextDouble();

			System.out.print("몸무게 : ");
			double inputWeight = sc.nextDouble();

			System.out.print("급여 : ");
			int inputSalary = sc.nextInt();

			System.out.print("부서 : ");
			String inputDept = sc.next();

			empArr[count] = new Employee(inputName, inputAge, inputHeight, inputWeight, inputSalary, inputDept);
			count++;

			// 배열이 차면 반복 종료
			if (count == empArr.length) {
				break;
			}

			System.out.print("\n사원 정보를 추가할까요? : ");
			String input = sc.next().toUpperCase();

			if (input.equals("N"))
				break;
		}

		// 현재 기록된 사원 정보 모두 출력
		for (Employee emp : empArr) {
			// NullPointerException 방지
			if(emp == null) break;
			System.out.println(emp.information());
		}
	}
}