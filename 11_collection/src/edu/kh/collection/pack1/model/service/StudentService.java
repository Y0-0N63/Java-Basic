package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.dto.Student;

/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
/**
 * 
 */
public class StudentService {

	// <E> : 제네릭 : 타입을 제한하는 문법, 객체(Reference Type)만 허용 > 다이아몬드 연산자로 생략 가능
	// java.util.List 인터페이스 : List에 반드시 필요한 필수 기능을 모아둔 인터페이스
	private List<Object> testList = new ArrayList<>();
	// ㄴ List를 상속받아 Class로 구현한 자식들 중 하나(ArrayList)를 사용해야만
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

		for (Object e : testList) {
			System.out.println(e);
		}
	}

	private Scanner sc = new Scanner(System.in);

	public StudentService() {
		studentList.add(new Student("홍길동", 23, "서울시 중구", 'M', 100));
		studentList.add(new Student("이수지", 20, "경기도 안산", 'F', 100));
		studentList.add(new Student("강하늘", 25, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 24, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울시 서대문구", 'F', 70));
	}

	// 학생 정보를 저장할 List 생성
	private List<Student> studentList = new ArrayList<>();

	/**
	 * 메뉴 출력용 메서드 alt + shift + j : 메서드용 주석
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
				// Comparable 사용
				System.out.println("7. 나이순으로 정렬");
				// Comparator 사용
				System.out.println("8. 이름순으로 정렬");
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴 번호 선택 : ");
				menuNum = sc.nextInt();
				sc.nextLine(); // 입력버퍼 개행 문자 제거용

				switch (menuNum) {
				case 1:
					System.out.println(addStudent());
					break;
				case 2:
					selectAll();
					break;
				case 3:
					System.out.println(updateStudent());
					break;
				case 4:
					System.out.println(removeStudent()); break;
				case 5:
					searchName1(); break;
				case 6:
					searchName2(); break;
				case 7:
					sortByAge(); break;
				case 8 :
					sortByName(); break;
				case 0:
					System.out.println("프로그램 종료...");
					break;
				default:
					System.out.println("메뉴에 작성된 번호만 입력하세요!");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해 주세요.");
				// 입력 버퍼에 남아있는 잘못된 코드 + 개행 문자 제거
				sc.nextLine();

				// 첫 반복 시 잘못 입력하는 경우, menuNum이 초기값인 0을 가지고 있어 반복문이 종료됨 > 방지하기 위해 임의의 값 대입
				menuNum = -1;
			}
		} while (menuNum != 0);
	}

	/**
	 * 1. 학생 정보 추가 메서드
	 * 
	 * @return 삽입 성공 시 "성공", 실패 시에는 "실패" 반환
	 */
	public String addStudent() {
		System.out.println("\n==========학생 정보 추가란==========");

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

	/**
	 * 2. 학생 전체 조회 메서드 - List가 비어있는 경우 "학생 정보가 없습니다" - else : 전체 학생 출력
	 */
	public void selectAll() {
		System.out.println("\n==========학생 전체 조회==========");
		// studentList가 비어있는지 확인 == List에 저장된 데이터 개수 얻어오기 > int List.size()
		// or boolean List.isEmpty(); : 컬렉션이 비어있다면 true 반환

//		if(studentList.size() == 0)
		if (studentList.isEmpty()) {
			System.out.println("학생 정보가 없습니다");
			// 현재 메서드 종료하고 호출한 곳으로 돌아감
			return;
		}

		// 반복문을 이용해 studentList에 있는 전체 학생 정보 출력
		// 일반 for문
//		for(int i = 0; i < studentList.size(); i++) {
//			System.out.println(studentList.get(i));
//		}

		// 향상된 for문 : 컬렉션, 배열의 모든 요소를 순차적으로 반복 접근할 수 있는 for문
		int index = 0;
		for (Student std : studentList) {
			System.out.print((index++) + "번 : ");
			System.out.println(std);
		}
	}

	/**
	 * 3. 학생 정보 수정 메서드 - 학생 정보가 studentList에 하나라도 있는지 검사 > 없다면 "입력된 학생 정보가 없습니다" 반환
	 * 
	 * - 인덱스 번호로 선택하여 학생을 수정 - 입력된 숫자가 0보다 작은지 검사 > 작다면 : "음수는 입력할 수 없습니다" 반환 -
	 * studentList 범위 내 인덱스 번호인지 검사 > 이상이라면 "범위를 넘어선 값을 입력할 수 없습니다" 반환
	 * 
	 * - 수정할 때 - index 번째 저장된 학생 정보를 수정 전에 한 번 출력 > 이름, 나이, 사는 곳, 성별, 점수 수정할 값 입력 받기
	 * > 수정이 완료되었다면 "000의 정보가 변경되었습니다" 반환
	 * 
	 * @return
	 */
	public String updateStudent() {
		System.out.println("\n==========학생 정보 수정==========");

		if (studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
		}

		System.out.print("인덱스 번호 : ");
		int index = sc.nextInt();

		// index 번호 범위 검사
		if (index < 0)
			return "음수는 입력할 수 없습니다";

		if (index >= studentList.size())
			return "범위를 넘어선 값을 입력할 수 없습니다";

		// index 번째 저장된 학생 정보 출력
		System.out.println(index + "번째에 저장된 학생 정보");
		System.out.println(studentList.get(index));

		// 수정할 내용 입력받기
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.print("사는 곳 : ");
		String regionString = sc.nextLine();

		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);

		System.out.print("점수 : ");
		int score = sc.nextInt();

		// 입력받은 index 번째에 수정할 학생 정보 세팅(수정)
		Student temp = studentList.set(index, new Student(name, age, regionString, gender, score));
		// E List.set(int index, E e) : 주어진 index 번째에 주어진 객체로 덮어쓰기 (수정) > 기존 객체 반환
		return temp.getName() + "의 정보가 변경되었습니다.";
	}
	
	/**
	 * 4. 학생 정보 제거 메서드
	 * 수정과 같은 검사 후 (인덱스 범위 등) > 삭제 시 "정말 삭제하시겠습니까? (Y/N) : "
	 * Y 입력 > 해당 인덱스에 있는 객체 삭제 후 > "000님의 정보가 제거되었습니다" 반환
	 * N 입력 > "취소" 리턴
	 * @return
	 */
	public String removeStudent() {
		System.out.println("\n==========학생 정보 제거==========");
		
		if (studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다";
		}

		System.out.print("인덱스 번호 : ");
		int index = sc.nextInt();

		if (index < 0)
			return "음수는 입력할 수 없습니다";

		if (index >= studentList.size())
			return "범위를 넘어선 값을 입력할 수 없습니다";

		// 삭제
		System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
		char ch = sc.next().toUpperCase().charAt(0);
		
		// E List.remove(int index) : 리스트에서 index 번째 요소를 제거 > 제거된 요소가 반환됨
		// List 중간에 비어있는 인덱스가 없게 하기 위해 > remove() 동작 시 뒤쪽 요소를 한 칸씩 자동으로 당겨오는 동작 수행
		if(ch == 'Y') {
			Student temp = studentList.remove(index);
			return temp.getName() + "의 정보가 제거되었습니다.";
		}
		
		return "취소";
	}

	/**
	 * 5. 이름이 일치하는 학생을 찾아 조회하는 메서드(완전 일치)
	 * - 검색할 이름을 입력받아 studentList에서 꺼내온 Student 객체의 name 값이 같은지 비교
	 * - 일치 > Student 객체 출력
	 * - 불일치 > "검색 결과가 없습니다"
	 */
	public void searchName1() {
		System.out.println("\n==========이름으로 검색(완전 일치)==========");
		System.out.print("검색할 이름 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for(Student std : studentList) {
			if(input.equals(std.getName())){
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("검색 결과가 없습니다");
		}
	}

	/**
	 * 6. 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 */
	public void searchName2() {
		System.out.println("==========이름으로 검색(부분 일치)==========");
		System.out.println("이름에 포함되는 문자열 입력 : ");
		String input = sc.next();
		
		boolean flag = true;
		
		for(Student std : studentList) {
			// boolean String.contains(문자열) : String에 문자열이 포함되어 있으면 true, else : false
			// std.getName()에 input이 포함되었는지
			if(std.getName().contains(input)) {
				System.out.println(std);
				flag = false;
			}
		}
		
		if(flag) System.out.println("검색 결과가 없습니다");
	}

	/**
	 * 7. 나이에 따라 오름차순 정렬(Comparable 인터페이스 사용)
	 */
	public void sortByAge() {
		// The method sort(List<T>) in the type Collections is not applicable for the arguments (List<Student>)
		// > Student 클래스에 implements Comparable<Student> 작성
		Collections.sort(studentList);
		
		for(Student std : studentList) {
			System.out.println(std);
		}
	}

	public void sortByName() {
		// 익명 내부 클래스
		// Comparator이라는 인터페이스를 익명 클래스가 상속받고 > 익명이기 때문에 클래스 타입 존재하지 않음
		// 객체화를 할 때 (new ~) 익명 클래스라 작성해줄 게 없음 > 그래서 비움
		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 이름 비교 : String 형인 name을 compareTo()로 비교해야 > String.compareTo() : 자바에서 객체 비교하는 메서드
				// == String이 COmparable을 상속받아 재정의해둔 compareTo() 메서드 이용하는 것
				// >> 두 객체를 비교하고 문자열의 순서를 결정
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
}