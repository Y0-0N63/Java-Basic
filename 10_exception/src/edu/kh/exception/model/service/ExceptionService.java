package edu.kh.exception.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	// 예외 (Exception) : 소스 코드 수정으로 해결 가능한 오류
	// Unchecked Exception : 선택적으로 예외 처리 (ex_ RuntimeException)
	// Checked Exception : 필수적으로 예외 처리 (ex_ IOException, ...)

	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		// 두 정수를 입력받아 나누기한 몫을 출력
		System.out.print("정수 1 입력 : ");
		// int형이 아닌 다른 자료형을 대입했을 때 >> Exception in thread "main" java.util.InputMismatchException
		
		int input1 = sc.nextInt();

		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
//		System.out.println("결과 : " + input1 / input2);
		// input2에 0이 들어왔을 때(== 0으로 나눌 때) 발생하는
		// Exception in thread "main" java.lang.ArithmeticException: / by zero >> 산술적 예외
		
		if(input2 != 0) {
			System.out.println("결과 : " + input1 / input2);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		// ====================================
		
		try {
			// 예외가 발생할 것 같은 코드
			System.out.println("결과 : " + input1 / input2); // 산술적 예외 발생 가능
		} catch (ArithmeticException e) {
			// try에서 던져진 예외를 catch문의 매개변수 e로 잡음
			// e를 사용해 > 예외 추적 코드 작성 가능 > 예외 어떻게 해결할지 작성하는 구문
			System.out.println("0으로 나눌 수 없음");
			e.printStackTrace();
			// 발생한 예외에 대한 메서드와 위치에 대한 모든 내용을 출력
			// 예외 발생 지점 추적 메서드
		}
		//발생하는 예외 중 일부 예외는 try-catch가 아닌 if-else를 사용해서도 예외 상황 방지 가능
		// 일부 예외 == 대부분 UncheckedException
	}
	
	public void ex2() {
		try {
			System.out.print("정수 1 입력 : ");
			int input1 = sc.nextInt(); // InputMissmatchException
			
			System.out.print("정수 2 입력 : ");
			int input2 = sc.nextInt(); // InputMissmatchException
			
			System.out.println("결과 : " + input1 / input2); // ArithmeticException
			
			String str = null;
			// NullPointerExcepton
			System.out.println(str.charAt(0));
		} catch(InputMismatchException e) {
			System.out.println("타입에 맞는 값만 입력하세요!");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다!");
		} catch (RuntimeException e) {
			// catch문 중 가장 위에 작성 시 InputMismatchException, ArithmeticException에서
			// > Unreachable catch block for InputMismatchException. It is already handled by the catch block for RuntimeException 오류 발생
			// Input, Arith-와 비교했을 때, RuntimeException이 상속 관계에서 부모로 존재하기 때문
			
			// 정수를 정상적으로 입력했을 때 > 결과를 출력해준 후 > NullPointerException에 의해 '잡았다!'메세지 출력
			System.out.println("잡았다!");
		} catch (Exception e) {
			System.out.println("뭔지 모르겠으나 예외가 발생하여 처리함");
			e.printStackTrace();
		}
	}

	public void ex3() {
		// try - catch - finally
		// finally : try 구문에서 예외 발생 유무와 관계 없이 무조건 마지막에 수행하는 구문
		try {
			System.out.print("정수 1 입력 : ");
			int input1 = sc.nextInt();

			System.out.print("정수 2 입력 : ");
			int input2 = sc.nextInt();
			
			System.out.println("결과 : " + input1 / input2);
		} catch (Exception e) {
			// 매개변수 e : 예외 관련된 정보 + 예외 관련 기능
			System.out.println(e.getClass()); // 어떤 예외 클래스인지
			System.out.println(e.getMessage()); // 예외 발생시 출력된 내용 (어떤 문제 때문에 발생했는지)
			System.out.println(e); // e.toString()과 동일
			e.printStackTrace(); // 예외에 대한 상세한 추적
		} finally {
			// 예외 발생이 있든 없든 무조건 수행됨
			System.out.println("무조건 수행됨");
			sc.close(); // 스캐너 종료 > 메모리 누수 방지
		}
		
		// try-with-resources : finally에서 일일이 close() 호출하지 않아도 자동으로 리소스 닫아주는 방식
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.println("안녕~ " + name);
		} catch (Exception e) {
			System.out.println("예외 발생 : " + e.getMessage());
		}
	}

	// Exception 처리를 호출한 메소드에게 계속 위임하기
	public void ex4() {
		try {
			methodA();
		} catch (Exception e) {
			System.out.println("methodC()에서부터 발생한 예외 > ex4()에서 잡아 처리");
			e.printStackTrace();
		}
	}
	
	// Exception(FileNotFoundException 작성 불가) 작성 > methodA();에 오류 발생
	public void methodA() throws Exception {
		methodB();
	}
	
	// IOException(FileNotFoundException의 부모) 작성하는 > methodB();에 오류 발생
	public void methodB() throws IOException {
		methodC();
	}
	
	// FileNotFoundException 작성 > methodC();에 오류 발생
	// throws : 호출한 메서드에게 예외 던짐 > 호출한 메서드에게 예외 처리 위임
	public void methodC() throws FileNotFoundException {
		// throw : 예외 강제 발생 구문
		throw new FileNotFoundException(); // Checked Exception
	}
	
	// 발생한 상황에 맞춰 예외 발생시키고 싶은데 > 자바가 미리 만들어둔 예외 클래스 중 마땅한 게 없을 때
	// 사용자가 원하는 모양새의 예외 클래스를 만들어 쓸 수 있다 >> 사용자 정의 예외 클래스
	// UserException 만들어 강제 예외 발생시키기
	public void ex5() throws UserException {
		throw new UserException("내가 만든 예외 처리해라!");
	}
}
