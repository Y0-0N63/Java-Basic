package edu.kh.control.branch;

import java.util.Scanner;

public class RSPGame {

	public static void main(String[] args) {
		System.out.println("[가위 바위 보 게임~!]");
		System.out.print("몇 판? : ");
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		int win = 0;
		int draw = 0;
		int loose = 0;
		
		for(int i = 1; i <= repeat; i++) {
			System.out.println("\n" + i + "번째 게임");
			System.out.print("가위/바위/보 중 하나 입력 : ");
			String input = sc.next();
			
			String com = "";
			int random = (int)(Math.random() * 3 + 1);
			switch(random) {
			case 1 : com = "가위"; break;
			case 2 : com = "바위"; break;
			case 3 : com = "보"; break;
			}
			
			System.out.println("컴퓨터가 " + com + "를 골랐습니다.");
			if(input.equals(com)) {
				System.out.println("비겼습니다.");
				draw++;
			} else {
				boolean win1 = input.equals("가위") && com.equals("보");
				boolean win2 = input.equals("바위") && com.equals("가위");
				boolean win3 = input.equals("보") && com.equals("가위");
				
				if(win1 || win2 || win3) {
					System.out.println("이겼습니다.");
					win++;
				} else {
					System.out.println("졌습니다.");
					loose++;
				}	
			}
			System.out.printf("현재 기록 : %d승 %d무 %d패\n", win, draw, loose);
		}
	}
}
