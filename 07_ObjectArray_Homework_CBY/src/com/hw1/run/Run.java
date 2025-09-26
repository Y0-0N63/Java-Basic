package com.hw1.run;

import com.hw1.model.vo.Employee;

public class Run {

	public static void main(String[] args) {
		// 객체 배열을 크기 3으로 할당한 뒤, 3개의 생성자를 각각 이용해 객체 생성 후 출력
		Employee employee = new Employee();
		Employee [] emps = new Employee [3];
		
		emps[0] = new Employee();
		emps[1] = new Employee(1, "홍길동", 19, 'M', "01022223333", "서울 잠실");
		emps[2] = new Employee(2, "강말순", "교육부", "강사", 20, 'F', 1000000, 0.01, "01011112222", "서울 마곡");
		
		for(Employee emp : emps) {
			if(emp == null) break;
			System.out.println(emp.information());
		}
		
		System.out.println("===============================================================================");

		// 3개의 객체 중 값이 없는 필드에 각각 값을 넣은 뒤 출력
		emps[0] = new Employee(0, "김말똥", "영업부", "팀장", 30, 'M', 3000000, 0.2, "91955559999", "전라도 광주");
		emps[1] = new Employee(1, "홍길동", "기획부", "부장", 19, 'M', 4000000, 0.3, "01022223333", "서울 잠실");
		System.out.println(emps[0].information());
		System.out.println(emps[1].information());
		
		System.out.println("===============================================================================");

		// 직원 각각의 보너스가 적용된 1년 연봉을 계산하여 출력
		// 연봉 = (급여 + (급여 * 보너스포인트)) * 12
		double total = 0;
		for(Employee emp : emps) {
			double year = (emp.getSalary() + (emp.getSalary() * emp.getBonusPoint())) * 12;
			total += year;
			System.out.printf("%s의 연봉 : %.0f원\n", emp.getEmpName(), year);
		}

		System.out.println("===============================================================================");

		// 3명의 직원의 연봉 평균 구해 출력
		System.out.printf("직원들의 연봉의 평균 : %d원\n", (int)(total / emps.length));
	}
}
