package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Student;

public class StudentService {
	
	// <E> : 제네릭 : 타입을 제한하는 문법, 객체(Reference Type)만 허용 > 다이아몬드 연산자로 생략 가능
	// java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	private List<Object> testList = new ArrayList<>();
	//							 	ㄴ List를 상속받아 Class로 구현한 자식들 중 하나(ArrayList)를 사용해야만
    // 인터페이스 객체 생성 X, 부모 참조 변수 O
	
	// List 테스트용 메서드
	public void ex() {
		// List.add(E e) : 리스트에 객체 추가하는 메서드
		// 매개변수 타입이 Object라는 것은 모든 객체 타입을 매개변수로 전달할 수 있다는 의미
		testList.add("문자열");
		testList.add(new Scanner(System.in));
		testList.add(100); // 자동으로 기본자료형을 객체 형태로 변환시킴 (int -> Integer) (AutoBoxing)
		testList.add(new Object());
		
		// 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있다.
		
		// Object List.get(int index) : 리스트에서 index번째에 있는 객체 반환
		// 반환형이 Object == 모든 객체를 반환할 수 있다.
		
		System.out.println(testList.get(0));
		System.out.println(testList.get(1));
		System.out.println(testList.get(2));
		System.out.println(testList.get(3));
			
		for(Object e : testList) {
			System.out.println(e);
		}
	}
	
	private Scanner sc = new Scanner(System.in);

	// 학생 정보를 저장할 List 생성
	private List<Student> studentList = new ArrayList<>();
	
	/**
	 * 메뉴 출력용 메서드
	 * alt + shift + j : 메서드용 주석
	 * 
	 * @author boyun
	 */
	public void displayMenu() {
		int menuNum = 0; // 메뉴 선택용 변수
		do {
			try {
				System.out.print("\n==========학생 관리 프로그램==========\n");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 정보 전체 조회");
				System.out.println("3. 학생 정보 수정");
				System.out.println("4. 학생 정보 제거");
				System.out.println("5. 이름으로 검색(완전 일치)");
				System.out.println("6. 이름으로 검색(포함(부분 일치))");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 번호 선택 : ");
				menuNum = sc.nextInt();
				sc.nextLine(); // 입력버퍼 개행 문자 제거용
				
				switch (menuNum) {
				case 1: System.out.println(addStudent()); break;
				case 2: /* selectAll(); */ break;
				case 3: /* updateStudent(); */ break;
				case 4: /* removeStudent(); */ break;
				case 5: /* searchName1(); */ break;
				case 6: /* searchName2(); */ break;
				case 0 : System.out.println("프로그램 종료..."); break;
				default: System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해 주세요.");
				// 입력 버퍼에 남아있는 잘못된 코드 + 개행 문자 제거
				sc.nextLine();
				
				// 첫 반복 시 잘못 입력하는 경우, menuNum이 초기값인 0을 가지고 있어 반복문이 종료됨 > 방지하기 위해 임의의 값 대입
				menuNum = -1;
			}
		} while(menuNum != 0);
	}
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * @return 삽입 성공 시 "성공", 실패 시에는 "실패" 반환
	 */
	public String addStudent() {
		System.out.println("==========학생 정보 추가란==========");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine(); // 입력 버퍼 개행 문자 제거 (다음 nextLine을 위해)
		
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// Student 새 객체 생성 후 > studentList에 추가
		if (studentList.add(new Student(name, age, region, gender, score))) {
			return "성공";
		} else {
			return "실패";
		}
	}
}