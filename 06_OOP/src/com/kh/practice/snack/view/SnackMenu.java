package com.kh.practice.snack.view;

import java.util.Scanner;

import com.kh.practice.snack.controller.SnackController;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : ");
		String snackKind = sc.next();
		
		System.out.print("이름 : ");
		String snackName = sc.next();
		
		System.out.print("맛 : ");
		String snackFlavor = sc.next();
		
		System.out.print("개수 : ");
		int snackAmount = sc.nextInt();
		
		System.out.print("가격 : ");
		int snackPrice = sc.nextInt();

		System.out.println(scr.saveData(snackKind, snackName, snackFlavor, snackAmount, snackPrice));
		
		System.out.print("저장한 정보를 확인하시겠습니까?(y/n) : ");
		char input = sc.next().charAt(0);
		
		if(input == 'y') {
			System.out.println(scr.confirmData());
		}
		
	}
}
