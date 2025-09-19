package edu.kh.control.branch;

import java.util.Scanner;

public class BranchExample {
	Scanner sc = new Scanner(System.in);

	public void ex1() {
		// 1부터 10까지 1씩 증가하며 출력하는 반복문 증가
		// 단, 5를 출력하면 반복문 종료

		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				break;
			}
			System.out.print(i + " ");
		}
	}

	public void ex2() {
		// 입력받은 모든 문자열 누적 > exit@ 입력 시, 문자열 누적 종료 > 결과 출력
		String str = "";
		while (true) {
			System.out.print("문자열 입력 (exit@ 입력 시 종료) : ");
			String input = sc.nextLine();

			if (input.equals("exit@")) {
				break;
			}
			str += input + "\n";
		}

		System.out.println("------------");
		System.out.println(str);
	}

	public void ex3() {
		// 1~10 : 1씩 증가하며 출력, 3의 배수 제외하고 출력
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				continue;
			}

			System.out.print(i + " ");
		}
	}

	public void ex4() {
		// 1~100 : 1씩 증가하며 출력하는 반복문
		// 단, 5의 배수 건너뛰고, 증가하는 값이 40이 되었을 때 반복 멈춤
		for(int i = 1; i <= 100; i++) {
			if (i == 40) {
				break;
			} else if(i % 5 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
	public void RSPGame() {
		// 가위바위보 게임 
		// 몇 판 할지 입력 > 입력받은 판 수만큼 반복 > 컴퓨터 : 가/바/보 셋 중 하나 선택 (Math.random())
		// math.ramdom() : 0.0 ~ 1.0사이 난수 생성 > 1~3 사이 난수 생성으로 변경 > 1 : 가위, 2: 바위, 3 : 보
		// 컴퓨터와 플레이어 가위바위보 판별 > 플레이어 승! / 졌습니다 ㅠㅠ / 비겼습니다
		// 매 판마다 > 현재 기록 : 2승 1무 0패 출력
		System.out.println("[가위 바위 보 게임~!]");
		System.out.print("몇 판? : ");
		int round = sc.nextInt();
		int win = 0;
		int loose = 0;
		int draw = 0;
		
		for(int i = 1; i <= round; i++) {
			System.out.println("\n" + i + "번째 게임");
			System.out.print("가위/바위/보 중 하나 입력 : ");
			String input = sc.next();
			
			int random = (int)(Math.random() * 3 + 1);
			String com = null;
			
			switch(random) {
			case 1 : com = "가위"; break;
			case 2 : com = "바위"; break;
			case 3 : com = "보"; break;
			}
			
			System.out.printf("컴퓨터는 [%s]를 선택했습니다. \n", com);
			
			// 컴퓨터와 플레이어 가위바위보 판별
			if(input.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else {
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("바위");
				
				if(win1 || win2 || win3) {
					System.out.println("플레이어 승!");
					win++;
				} else {
					System.out.println("졌습니다ㅜㅜ");
					loose++;
				} 
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, loose);
		}
	}
}