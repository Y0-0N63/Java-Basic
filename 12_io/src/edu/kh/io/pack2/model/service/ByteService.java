package edu.kh.io.pack2.model.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteService {
	/**
	 * 바이트 기반 스트림을 이용한 파일 출력 + 데이터 출력
	 */
	public void fileByteOutput() {
		// FileOutputStream 참조 변수 선언 (OutputStream 상속받은 자식 클래스)
		FileOutputStream fos = null;

		try {
			// FileNotFoundExcption : 경로성 파일을 찾을 수 없음 (자식/ 부모 : IOException)

			// new FileOutputStream("경로") : 경로에 작성된 파일과 연결된 파일 출력 스트림 객체 생성
			// > 출력 스트림에 연결된 파일이 존재하지 않으면 자동 생성 *단, 파일은 자동생성해주지 않음
			// 기존 파일이 존재하면 > 내용 덮어쓰기 진행
			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트.txt");

			// String 불변성 문제를 해결한 객체
			// StringBuilder(비동기) / StringBuffer(동기)
			StringBuilder sb = new StringBuilder();
			// 1byte짜리 > 입력한 그대로 출력됨
			sb.append("Hello World!!\n");
			sb.append("123456789\n");
			sb.append("!@~#$%^&*(<>?{}+_=\n");

			// 1byte가 아닌 경우 > 섆|??@Y~~~...처럼 깨져서 출력됨
			sb.append("가나다라마바사\n");
			sb.append("와앙~~~\n");
			sb.append("자바 공부\n");
			sb.append("오늘 저녁 뭐 먹지\n");

			// 출력 방법 1 : 한 글자씩(2byte(char)) 파일로 출력
			// StringBuilder > String으로 변환 > charAt() > char로 변환
			String content = sb.toString();
			// 아래 for문의 내용 사용시 > 2byte짜리 글자들은 깨짐
//				for(int i = 0; i < content.length(); i++) {
//					char ch = content.charAt(i);
//					// fos > 1byte, char > 1(영어)~2(한글)byte >> 2byte의 경우는 통과하게 됨
//					fos.write(ch);
//				}

			// 출력 방법 2 : String을 byte[] 변환 후 출력 (내부적으로 인코딩 과정을 거치기 때문에 깨지지 않고 출력 가능)
			// 수행 시간(
			// System.nanoTime() : 1970.01.01 오전 9:00:00부터 현재 시간까지의 차이를 nano second(ns)로 반환
			// + 1ms == 1/1000s 1us(마이크로) == 1/1000ms 1ns == 1/1000us
			long startTime = System.nanoTime();
			fos.write(content.getBytes());
			long endTime = System.nanoTime();
			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");

			// **flush** : 스트림 안에 남아있는 모든 데이터를 외부로 모두 밀어냄
			fos.flush(); // FileOutputStream에서는 선택 사항이나, 대체로 작성해줌
			System.out.println("출력 완료!");

		} catch (IOException e) {
			e.printStackTrace();
		} finally { // try 예외 발생 여부 관계 없이 무조건적으로 수행 구간
			// 메모리 누수를 막기 위해, String에서는 사용하는 편이 좋음 (사용 완료한 스트림 제거(닫기, 메모리 반환))
			if (fos != null) { // 초기 fos는 null > new 연산자(new FileOutputStream)를 통해 열어줌 >> fos가 열려있다면 ==
								// !null이라면
				try {
					// 스트림이 정상 생성된 경우 > 스트림을 닫아줌
					// fos.close()만 작성하면 오류 발생 (Unhandled exception type IOException) > try-catch
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 버퍼를 이용한 파일 출력 + BufferedOutputStream 보조 스트림(바이트 기반) 이용 - 버퍼(Buffer) : 데이터를
	 * 모아두는 공간 (바구니 같은 메모리 공간)
	 * 
	 * BufferedOutputStream(출력용 보조 스트림) <-> BufferedInputStream(입력용 보조 스트림)
	 * 
	 * FileOutputStream : 1바이트씩 데이터 입출력 -> 통로가 좁아서 데이터 입출력 시 속도가 느림 > 보조 스트림 이용 시 :
	 * 버퍼에 입출력할 내용 모아 한 번에 입출력 가능 > 기반 스트림(FileOutputStream)을 이용하는 횟수, 시간이 줄어듦 > 성능,
	 * 시간 효율 향상
	 */
	public void bufferedFileByteOutput() {
		FileOutputStream fos = null; // 기반 스트림 참조 변수 선언
		BufferedOutputStream bos = null; // 보조 스트림 참조 변수 선언

		try {
			fos = new FileOutputStream("/io_test/20251014/바이트기반_테스트_buffered.txt");
			// BufferedOutputStream : 기반 스트림 참조변수를 전달해줘야 함
			bos = new BufferedOutputStream(fos);

			StringBuilder sb = new StringBuilder();
			sb.append("Hello World!!\n");
			sb.append("123456789\n");
			sb.append("!@~#$%^&*(<>?{}+_=\n");

			sb.append("가나다라마바사\n");
			sb.append("와앙~~~\n");
			sb.append("자바 공부\n");
			sb.append("오늘 저녁 뭐 먹지\n");

			String content = sb.toString();

			long startTime = System.nanoTime();
			// fos가 아닌 bos로 작성 > 버퍼에 저장(파일에 즉시 기록 X)
			bos.write(content.getBytes());
			long endTime = System.nanoTime();
			System.out.println("[수행시간] : " + (endTime - startTime) + "ns");

			// 스트림 안에 남아있는 모든 데이터를 밀어냄
			// close할 때, 자동으로 flush되지만 **BufferedOutputStream 사용시 flush() 작성이 권고됨**
			bos.flush(); // 이 부분이 없으면 txt 파일에 입력한 데이터가 보이지 않음
			System.out.println("출력 완료!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 스트림 객체 미생성 시 > close() 구간에서 NullPointerException 발생 가능 > 조건문 추가
				// 보조 스트림(bos) close()시, 보조 스트림 생성에 사용된 기반 스트림(fos)도 함께 close()됨
				// > clse()시 버퍼에 남아있는 내용 모두 flush()
				if (bos != null)
					bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 바이트 기반 파일 입력 - 외부 파일의 내용을 자바 프로그램 내부로 읽어오기
	 */
	public void fileByteInput() {
		// 파일 입력용 바이트 기반 스트림 선언 (참조 변수만 존재)
		FileInputStream fis = null;

		try {
			// inputStream 객체 만들어주기 (어디서 읽어오는지 경로 작성해야)
			// 경로에 존재하지 않는 파일 작성할 경우 > java.io.FileNotFoundException 오류 발생
			// OutputStream은 파일을 생성해주지만 InputStream은 그렇지 않음 (반드시 해당 경로에 실제 파일이 존재해야 함)
			fis = new FileInputStream("/io_test/20251014/노래가사.txt");

//				// 방법 1. 파일 내부 내용을 1byte씩 끊어서 가져오기 > 2byte 범주의 글자는 깨지는 문제 발생
//				// byte(자바에서 정수형) > 다루기 까다로워 정수형 기본형인 int로 변환해서 사용
//				int value = 0; // 읽어온 바이트 값 저장할 변수
//				
//				StringBuilder sb = new StringBuilder();
//				
//				// 노래가사 1byte씩 읽어오기
//				while(true) {
//					// read() : 1byte씩 읽어오고 더이상 읽엉로 값이 없으면 -1 반환
//					value = fis.read();
//					
//					// 저장된 노래 가사를 다 읽었다면
//					if(value == -1) break;
//					
//					// char로 강제 형변환 후 > 문자 형태로 sb에 추가
//					sb.append((char)value);
//				}
//				
//				System.out.println(sb.toString()); // 읽어온 내용을 콘솔에 출력
//				// InputStream은 flush 없음 (flush()는 출력 스트림과만 관련된 동작) > 읽어오는 동작만 작성하면 됨

			// 방법 2. 파일에 저장된 모든 byte값을 다 읽어와 > byte[] 형태로 반환 > byte[] 이용해 String 객체 생성
			byte[] bytes = fis.readAllBytes();

			// String 생성자의 전달인자에 bytes 작성 > 내부적으로 문자열 생성해줌
			String content = new String(bytes);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용 완료된 Stream 메모리 반환 (통로 닫기)
			try {
				if (fis != null)
					fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * BufferedInputStream 보조 스트림을 이용한 성능 향상
	 * 
	 * InputStream의 경우, 외부 파일의 데이터를 읽어올 때 사용 > 읽어오는 파일 내부의 데이터 크기가 작으면 보조 스트림의 성능
	 * 이점이 크게 눈에 띄지 않음
	 */
	public void bufferedFileByteInput() {
		// 파일 입력용 바이트 기반 스트림 선언
		FileInputStream fis = null;

		// 파일 입력용 바이트 보조 스트림 선언 > 보조 스트림은 홀로 사용 X (기본적으로 기반 스트림이 존재해야)
		BufferedInputStream bis = null;

		try {
			// 기반 스트림 객체 생성
			fis = new FileInputStream("/io_test/20251014/노래가사.txt");

			// 보조 스트림 객체 생성
			bis = new BufferedInputStream(fis);

			byte[] bytes = bis.readAllBytes();
			String content = new String(bytes);
			System.out.println(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 보조 스트림만 close()해도 > 기반 스트림도 함께 close()됨
				if (bis != null)
					bis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 파일 복사
	 *
	 * 파일 경로를 입력받아 지정된 파일과 같은 경로에 복사된 파일 출력하기
	 *
	 * [실행화면] 파일 경로 입력 : /io_test/20251014/노래가사.txt 복사 완료 :
	 * /io_test/20251014/노래가사_copy.txt
	 *
	 * 1) 입력된 경로에 파일이 있는지 검사
	 * 2) 있으면 파일 내용을 모두 읽어오기 : FileInputStream + BufferedInputStream
	 * 3) 읽어온 내용을 같은 경로 위치에 "파일명_copy.확장자" 이름으로 출력 :
	 * FileOutputStream + BufferedOutputStream
	 * 
	 * + Scanner 대신 BufferedReader(문자열 입력용 스트림) 이용
	 *  -> BufferedReader는 보조스트림으로 단독사용 불가능!
	 *  -> BufferedReader 생성 시 보조스트림인 InputStreamReader
	 *  -> InputStream가 기반
	 */
	public void fileCopy() {
		// 스트림 참조 변수 선언
		BufferedReader br = null; // 문자열 입력용 스트림 (Scanner 대신 사용)
		
		FileInputStream fis = null; // 파일 입력 기반 스트림
		BufferedInputStream bis = null; // 파일 입력 보조 스트림
		
		FileOutputStream fos = null; // 파일 출력 기반 스트림
		BufferedOutputStream bos = null; // 파일 출력 보조 스트림
		
		try {
			// 키보드 입력 받기 위한 스트림 객체 생성 (Scanner 대신)
			br = new BufferedReader(new InputStreamReader(System.in));
			
			// 경로 입력받기
			System.out.print("파일 경로 입력 : ");
			String target = br.readLine(); // 입력된 한 줄 읽어오기
			
			// 해당 경로에 파일이 존재하는지 확인
			File file = new File(target);
			
			// 해당 경로에 파일이 존재하지 않으면 > 해당 메서드 바로 종료
			if (!file.exists()) {
				// 프린트 구문 출력
				System.out.println("[해당 경로에 파일이 존재하지 않습니다.]");
				return;
			}
			
			// 해당 경로에 파일이 존재하면 > target이 가리키는 파일을 입력받을 수 있도록 > 입력용 스트림 생성
			fis = new FileInputStream(target);
			bis = new BufferedInputStream(fis);
			
			// 입력용 스트림 이용해 target 파일의 내용 입력받기
			byte[] bytes = bis.readAllBytes();
			
			// 입력 완료
			
			// (출력할 파일의 경로 + _copy) 이름의 파일 생성하기 .../원본_copy.txt
			StringBuilder sb = new StringBuilder();
			sb.append(target);
			
			// int String.lastIndexOf("문자열")
			// : 전달인자 문자열이 마지막으로 등장하는 인덱스 찾아 > int 값으로 반환 (찾지 못하면, -1)
			int insertPoint = target.lastIndexOf(".");
			sb.insert(insertPoint, "_copy");
			
			// 출력용 스트림 생성
			// StringBuilder 타입을 String으로 바꾸어서
			fos = new FileOutputStream(sb.toString());
			bos = new BufferedOutputStream(fos);
			
			// 원본에서 읽어온 내용 bytes를 bos를 이용해 출력(쓰기)
			bos.write(bytes);
			bos.flush();
			
			System.out.println("복사 완료 : " + sb.toString()); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(bis != null) bis.close(); // fis도 함께 닫힘
				if(bos != null) bos.close(); // bis도 함께 닫힘
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}