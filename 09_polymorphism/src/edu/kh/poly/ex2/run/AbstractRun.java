package edu.kh.poly.ex2.run;

import edu.kh.poly.ex2.model.service.Calculator;
import edu.kh.poly.ex2.model.service.HGDCalculator;

public class AbstractRun {

	public static void main(String[] args) {
//		new AbstractService().ex1();
		
		Calculator cal = new HGDCalculator();
		System.out.println("합 : " + cal.plus(20, 30));
		System.out.println("차 : " + cal.minus(20, 30));
		System.out.println("곱 : " + cal.multiple(20, 30));
		System.out.println("몫 : " + cal.divide(20, 30));
		
		// 인터페이스 == 미완성 설계도 == 객체 생성은 불가능
		// 그러나, 참조 변수로는 사용 가능
		// 자식 객체 생성 코드만 바꾸면 > 새로운 클래스 코드 수행 가능!
	}
}
