package edu.kh.network.server.model.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerService {
	/*
	 * TCP
	 * - 서버, 클라이언트간 1:1 소켓통신 (연결 지향적 프로토콜)
	 * - 서버가 먼저 실행되어 있는 상태에서 클라이언트가 연결해야 함.
	 * - 데이터 전송 순서가 보장되고, 수신 여부를 판단하여 오류 발생 시 재전송함.
	 * - java.net 패키지에서 제공하는 Socket(Client용), ServerSocket 클래스를 사용해야함.
	 *   Socket
	 * - 프로세스의 양 끝단(프로세스간의 통신을 담당) > Input/OutputStream 보유하고 있음.
	 *   ServerSocket
	 * - 포트와 연결되어 외부 요청을 기다리는 객체 (하나의 포트에는 하나의 ServerSocket만 연결 가능)
	 * - 클라이언트의 연결 요청이 들어오면 > 클라이언트의 소켓을 얻어와 연결하게 된다.
	 * >> TCP 통신 = 소켓 간 연결 + 데이터 주고받기
	 * */

	// TCP 통신을 하기 위한 서버
	public void serverStart() {
		// 1. 서버의 포트번호 정하기 : port : 0~65535 사이 값으로 지정 가능
		// 단, 1023 이하는 이미 사용 중인 경우가 많으니 피하는 게 좋음
		int port = 8500;
		
		// 소켓용 참조 변수 선언
		ServerSocket serverSocket = null;
		// 클라이언트가 요청을 보낼 때 클라이언트의 소켓이 서버측으로 넘어올 때 그것을 받아주는 변수
		Socket clientSocket = null; 
		
		// 입/출력용 참조 변수 선언 > 바이트 기반 스트림 or 문자 기반 스트림 어느 측이 넘어올지 모르니 부모 타입으로 선언
		InputStream is = null;
		OutputStream os = null;
		
		// 보조 스트림 참조 변수 선언
		BufferedReader br = null;
		
		// PrintWriter : 문자 기반 보조 스트림 > 파일, 콘솔, 네트워크 소켓 등 다양한 출력 스트림에서 데이터를 쉽게 출력할 수 있도록 함
		PrintWriter pw = null;
		
		try {
			// 2. 서버용 소켓 객체(8500번 번호를 가진 서버 소켓) 생성
			serverSocket = new ServerSocket(port);
			
			// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
			// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			System.out.println("[Server]");
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			
			// (클라이언트의 요청이 오고 수락이 될 때까지 무한 대기 후) 클라이언트의 요청 수락
			// 수락 시 > 클라이언트의 socket을 전달받음
			clientSocket = serverSocket.accept();
			System.out.println("[클라이언트 접속 성공]");
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성 > 클라이언트가 서버로 요청 시 소켓 전달
			// 해당 소켓에는 입/출력 스트림이 담겨있는 상태
			is = clientSocket.getInputStream();
			os = clientSocket.getOutputStream();
			
			// 6. 보조 스트림을 통해 성능 개선
			// InputStreamReader : 문자 기반 BufferedReader와 바이트 기반 InputStream을 연결할 수 있게 함
			// 클라이언트-서버는 한글 기반의 메시지를 주고받는데 > 문자로써의 성능 향상을 위해 '바이트 -> 문자'를 수행
			br = new BufferedReader(new InputStreamReader(is));
			
			pw = new PrintWriter(os);
			
			// 7. 스트림을 통해 읽고 쓰기
			// 서버 -> 클라이언트 메세지 전송(출력)
			// java.util.Date : 자바에서 시간을 나타내는 객체 > new Date()를 통해 객체 생성 시 현재 시간이 저장되어 있음
			Date now = new Date();
			
			// SimpleDateFormat : 날짜 형식을 간단히 지정하는 객체
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
			
			String msg = sdf.format(now) + " [서버 접속 성공]";
			// 서버 -> 클라이언트로 데이터 출력(전송)
			// PrintWriter.println(문자열) : 주어진 데이터를 문자 형태로 출력 후 > 줄바꿈
			pw.println(msg);
			// flush() : 스트림의 모든 내용을 밀어냄
			pw.flush();
			
			// 서버 -> 클라이언트로 메시지 전송 완료
			// 클라이언트에서 작성한 메시지 전달받아 서버에서 출력하기
			String clientMsg = br.readLine();
			
			// 서버의 콘솔창에 클라이언트가 보낸 메시지와 IP 출력
			// 클라이언트의 IP 주소 정보 얻어오기
			// getAddress() : 클라이언트에 대한 IP 주소 정보를 포함한 InetAddress 객체 반환
			// getHostAddress() : InetAddress 객체에서 IP 주소를 문자열 형식으로 반환
			String clientIP = clientSocket.getInetAddress().getHostAddress();
			
			System.out.println(clientIP + "가 보낸 메시지 : " + clientMsg);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 8. 통신 종료
			try {
				// 스트림과 소켓 닫아주기
				if (br != null) br.close(); // + is.close();
				if (pw != null) pw.close();  // + os.close();
				
				if (serverSocket != null) serverSocket.close();
				if (clientSocket != null) clientSocket.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
