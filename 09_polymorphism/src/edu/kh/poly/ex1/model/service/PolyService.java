package edu.kh.poly.ex1.model.service;

import edu.kh.poly.ex1.model.dto.Car;
import edu.kh.poly.ex1.model.dto.Spark;
import edu.kh.poly.ex1.model.dto.Tesla;

public class PolyService {

	// 다형성 확인 예
	public void ex1() {
		// Car 객체 생성
		// 부모타입 참조변수 = 부모객체주소
		Car car = new Car();
		
		// Tesla 객체 생성
		// 자식타입 참조변수 = 자식객체주소
		Tesla tesla = new Tesla();
		
		// ************** 다형성 **************
		
		// 부모타입 참조변수 = 자식객체주소
		// Tesla 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에
		// Tesla 객체가 Car(부모) 객체로 변화함 >> 업캐스팅
		Car car2 = new Tesla();
		
		// Spark 객체를 참조하는 변수의 타입이 Car(부모)이기 때문에 Spark 객체가 Car 객체로 변화
		// >> 업캐스팅
		Car car3 = new Spark();
		
		// 1. 자식 객체가 부모 객체로 변화 > 자식만의 고유 필드, 메서드 사용 불가
		
		// 1-1) car (부모 = 부모)
		car.setEngine("V6 6기통 엔진");
		car.setFuel("휘발유");
		car.setWheel(4);
		
		// 1-2) tesla (자식 = 자식, 일반적인 상속 관계)
		tesla.setEngine("전기모터");
		tesla.setFuel("전기");
		tesla.setWheel(4);
		tesla.setBatteryCapacity(1000000);
		
		// 1-3) car2 (부모 = 자식(Tesla))
//		car2.setBatteryCapacity(1000);
		car2.setEngine("전기모터");
		car2.setFuel("전기");
		car2.setWheel(4);
		
		// car3 (부모 = 자식(Spark))
//		car3.setDiscountOffer(0.5);
		car3.setEngine("경차엔진");
		car3.setFuel("휘발유");
		car3.setWheel(4);
		
		// 2. 다형성을 이용한 객체 배열
		// 각 요소가 Car 객체만 들어올 수 있는 객체 배열 선언 및 할당
		Car[] arr = new Car[3];
		
		// Car 타입의 car 객체 >> 당연히 들어감
		arr[0] = car;
		
		// Car 타입 참조변수 = 자식(Tesla) 객체주소
		arr[1] = car2;	
		arr[2] = car3;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i + "번째 인덱스의 엔진 : " + arr[i].getEngine());
		}
	}

	// 전달 받은 Car 또는 자식 객체(Tesla, SSpark)의 엔진, 연료, 바퀴 개수 출력 메서드 
	public void printCar(Car temp) {
		// Car temp = t > s > c (업캐스팅의 형태, 부모타입 참조변수 = 자식타입객)
		// Car - Spark/Tesla는 상속 관계 > temp라는 Car타입(부모타입) 매개변수에 의해
		// Car, Teslar, Spark의 주소 참조가 가능해짐
		System.out.println("엔진 : " + temp.getEngine());
		System.out.println("연료 : " + temp.getFuel());
		System.out.println("바퀴 개수 : " + temp.getWheel());
		System.out.println();
	}	
	
	// 매개변수로 전달받은 정수값에 따라 Ca, Tesla, Spark 중 객체 만들어 반환
	public Car createCar(int num) {
		Car result = null;
		
		switch(num) {
		case 1 : result = new Car(); break;
		case 2 : result = new Tesla(); break;
		case 3 : result = new Spark(); break;
		}
		
		return result;
	}
	
	// 다형성(업캐스팅)을 이용한 매개변수 사용법
	public void ex2() {
		Tesla t = new Tesla("전기모터", "전기", 4, 1000000);
		Spark s = new Spark("경차엔진", "휘발유", 4, 0.5);
		Car c = new Car("경유엔진", "경유", 12);
		
		printCar(t);
		printCar(s);
		printCar(c);
		
		// 다형성을 이용한 반환형 사용법
		// Car[] arr = { new Car(), new Teslar(), new Spark() }
		Car[] arr = {createCar(1), createCar(2), createCar(3)};
						// Car		Car(Tesla)	  Car(Spark)
		
		// 객체가 어떤 타입(자료형)인지 검사 > instanceof 연산자
		// >> 참조하는 객체가 특정 자료형이거나 상속 관계인지 확인
		System.out.println(arr[1] instanceof Tesla); // true (자기 본인 맞음)
		System.out.println(arr[1] instanceof Spark); // false
		// > Tesla와 Spark는 같은 부모 Car을 갖고 있을 뿐, 아무런 관계가 아님
		
		System.out.println(arr[1] instanceof Car); // true (상속 관계에 있음)
	}

	// 다형성 중 다운캐스팅 확인 예제
	public void ex3() {
		// 다운캐스팅을 위해 우선 업캐스팅부터 해주기 (Tesla 자식 > Car 부모)
		Car c1 = new Tesla("전기모터", "전기", 4, 50000);
		// 우선순위에 주의! `.`이 형변환 연산자보다 우선순위가 높음
		System.out.println(((Tesla)c1).getBatteryCapacity());
		
		Tesla t1 = (Tesla)c1; // 다운캐스팅
		System.out.println(t1.getBatteryCapacity());
	}
	
	// 다운캐스팅 주의사항 확인 예제
	public void ex4() {
		// Tesla 객체를 만들어 Car 타입 참조변수 c1에담음 >> 업캐스팅 상태
		Car c1 = new Tesla();
		
		// c1을 관계 없는 Spark로 다운캐스팅하려고 함
		// 다운캐스팅은 잘못 작성해도 > 컴파일 에러 발생 X > 실행 시 런타임 에러로 발생!
		// ClassCastException : 형변환 예외
//		Spark s1 = (Spark) c1; 
		
		// 예외 처리 방법 >> instanceof와 같이 사용하기
		// c1이 Spark이거나, 상속관계인가?
		if(c1 instanceof Spark) {
			// 다운캐스팅
			Spark s1 = (Spark) c1;
			System.out.println("성공");
		} else {
			System.out.println("실패. c1은 Spark 타입이거나 상속 관계가 아님");
		}
		
	}

	// 바인딩 확인 예제
	public void ex5() {
		Car c1 = new Car("경유엔진", "경유", 8);
		System.out.println(c1.toString());
		// toString) String edu.kh.poly.ex1.model.dto.Car.toString ()
		// 반환형 출처 : Car 객체에 있는 toString() 메서드 호출
		// 프로그램 실행 전, 컴파일러는 toString()메서드가 Car에 있는 것으로 인식해
		// c1.toSring() 호출코드와 edu.kh.poly.ex1.model.dto.Car.toString () 메서드
		// 선언부 코드를 연결한 것 >> 정적 바인딩
		
		// **다형성 적용 시 바인딩**
		Car c2 = new Spark("경차엔진", "휘발유", 4, 0.5);
		// 업캐스팅 적용 상태 >> 부모 부분만 참조 가능 상태
		System.out.println(c2.toString());
		// String edu.kh.poly.ex1.model.dto.Car.toString ()
		// 실행 시) 경차엔진 / 휘발유 / 4 / 0.5 >> Spark 클래스에 오버라이딩된 toString()
		// >> 동적바인딩
	}
}
