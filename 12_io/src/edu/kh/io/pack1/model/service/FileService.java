package edu.kh.io.pack1.model.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileService {
	/**
	 * File 클래스로 객체 생성  > 폴더가 존재하지 않으면 > 원하는 경로에 폴더 생성해주기
	 */
	public void method1() {
		// C:/io_test/20251014 폴더를 지정
		// "/"로 시작한다 == 현재 실행중인 프로제트의 루트 디렉토리 == 최상위 폴더 == (여기서는) C 드라이브
		// 	io_test/29251914 작성 시 > 해당 프로젝트가 현재 위치 == 해당 프로젝트(12_io) 안에 io_test... 생성
		// 상대 경로 작성법
		// 현재 프로젝트 :  12_io
		//					  ㄴ io_test
		//						ㄴ 20251014
		
		File directory = new File("C:/io_test/20251014");
		
		// 폴더가 존재하지 않으면 > 생성
		if(!directory.exists()) {
			// 폴더를 모두 생성
			directory.mkdirs();
			
			System.out.println(directory.getName());
			System.out.println(directory.getPath());
		}
	}

	/**
	 * File 객체 이용해 > 지정된 위치에 파일 생성
	 */
	public void method2() {
		// 문자열에서 '\'는 이스케이프 문자로 사용됨 > 문자로 사용하고 싶을 때 '\\'
		File file = new File("\\io_test\\20251014\\파일생성.txt");
		
		// 해당 위치에 파일이 존재하지 않는다면
		if(!file.exists()) {
			// 파일 생성
			try {
				// 파일이 정상적으로 생성된 경우
				if(file.createNewFile()) {
					System.out.println(file.getName() + "파일이 생성됨");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void method3() {
		File directory = new File("\\workspace\\01_Java\\12_io");
		
		// 지정된 경로에 있는 모든 파일/디렉토리를 File[] 형태로 얻어오기
		File[] files = directory.listFiles();
		
		for(File f : files) {
			// 파일명 조회해 > 가져오기
			String fileName = f.getName();
			
			// 마지막으로 수정한 날짜
			long lastModified = f.lastModified();
			
			// java.text.SimpleDateFormat : 간단히 날짜 형식을 지정할 수 있는 객체 (사람이 볼 수 있게 수정)
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm"); // a : 오전, 오후
			
			// String SimpleDateFormat.format(long) : 매개변수 long 값을 지정된 패턴 형식으로 변환해 문자열 형태로 반환
			String date = sdf.format(lastModified);
			
			// 파일 유형
			String type = null;
			if(f.isFile())  type = "파일";
			else			type = "폴더";
			
			// 파일 크기(byte)
			String size = f.length() + "B";
			
			// 폴더 크기를 구하는 메서드 존재 X > 폴더라면 사이즈 빈 문자열로 변경
			// 만약 폴더 크기 구하고 싶으면 > 폴더 안 모든 파일 순회 > 각 파일 크기 합산해 사용
			if(f.isDirectory()) size = "";
			
			// - : 왼쪽 정렬
			String result = String.format("%-20s %-20s %-5s %10s", fileName, date, type, size);
			System.out.println(result);
			
			
		}
	}
}