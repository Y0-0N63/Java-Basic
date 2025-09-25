package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		// 객체 배열을 크기 3으로 할당한 뒤, 3개의 생성자를 각각 이용해 객체 생성 후 출력
		Employee employee = new Employee();
		Employee [] emp = new Employee [3];

		
		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
		
		// 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
		// 연봉 = (급여 + (급여 * 보너스포인트)) * 12
		// 3명의 직원의 연봉 평균 구해 출력
		
		emp[0] = new Employee();
		emp[1] = new Employee();
		
		emp[2] = new Employee();
		
		emp[0].information();
	}

}
