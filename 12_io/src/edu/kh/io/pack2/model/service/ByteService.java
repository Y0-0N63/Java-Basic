package edu.kh.io.pack2.model.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
				// > 출력 스트림에 연결된 파일이 존재하지 않으면 자동 생성	*단, 파일은 자동생성해주지 않음
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
				// + 1ms == 1/1000s   1us(마이크로) == 1/1000ms   1ns == 1/1000us
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
				if(fos != null) { // 초기 fos는 null > new 연산자(new FileOutputStream)를 통해 열어줌 >> fos가 열려있다면 == !null이라면 
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
		 * 버퍼를 이용한 파일 출력 + BufferedOutputStream 보조 스트림(바이트 기반) 이용
		 * - 버퍼(Buffer) : 데이터를 모아두는 공간 (바구니 같은 메모리 공간)
		 * 
		 * BufferedOutputStream(출력용 보조 스트림) <-> BufferedInputStream(입력용 보조 스트림)
		 * 
		 * FileOutputStream : 1바이트씩 데이터 입출력 -> 통로가 좁아서 데이터 입출력 시 속도가 느림
		 * > 보조 스트림 이용 시 : 버퍼에 입출력할 내용 모아 한 번에 입출력 가능
		 * > 기반 스트림(FileOutputStream)을 이용하는 횟수, 시간이 줄어듦 > 성능, 시간 효율 향상	
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
					if(bos != null)	bos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
}
