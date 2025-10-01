package com.hw3.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class Library {
	Scanner sc = new Scanner(System.in);
	int menuNum = 0;

	private List<Book> books = new ArrayList<>();
	private List<Book> favorites = new ArrayList<>();

	public Library() {
		books.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		books.add(new Book(2222, "문과 남자의 과학 공부", "유시민", 15750, "돌베개"));
		books.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		books.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		books.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}

	public void displayMenu() {
		do {
			try {
				System.out.println("\n=== 도서 목록 프로그램 ===");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 즐겨찾기 추가");
				System.out.println("6. 즐겨찾기 삭제");
				System.out.println("7. 즐겨찾기 조회");
				System.out.println("8. 추천 도서 뽑기");
				System.out.println("0. 프로그램 종료");

				System.out.print("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();
				sc.nextLine();

				switch (menuNum) {
				case 1:
					System.out.println(createBook());
					break;
				case 2:
					lookBook();
					break;
				case 3:
					updateBook();
					break;
				case 4:
					System.out.println(removeBook());
					break;
				case 5:
					createFavorite();
					break;
				case 6:
					System.out.println(removeFavorite());
					break;
				case 7:
					lookFavorite();
					break;
				case 8:
					selectRecommend();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다...");
					break;
				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}
			} catch (Exception e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다.");
				sc.nextLine();
			}
		} while (menuNum != 0);
	}
	

	public String createBook() {
		System.out.println("\n===== 도서 등록 =====");
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 제목 : ");
		String bookTitle = sc.nextLine();

		System.out.print("도서 저자 : ");
		String bookAuthor = sc.nextLine();

		System.out.print("도서 가격 : ");
		int bookPrice = sc.nextInt();
		sc.nextLine();

		System.out.print("도서 출판사 : ");
		String publisher = sc.nextLine();

		if (books.add(new Book(bookNum, bookTitle, bookAuthor, bookPrice, publisher))) {
			return "등록 완료";
		} else {
			return "등록 실패";
		}
	}

	public void lookBook() {
		System.out.println("\n===== 도서 조회 =====");
		if (books.isEmpty()) {
			System.out.println("등록된 도서 정보가 없습니다.");
			return;
		}

		for (Book book : books) {
			System.out.println(book.toString());
		}
	}

	public void updateBook() {
		System.out.println("\n=====도서 수정=====");

		if (books.isEmpty()) {
			System.out.println("일치하는 도서 번호가 없습니다.");
			return;
		}

		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();

		boolean flag = true;

		for (Book book : books) {
			if (bookNum == book.getNum()) {
				int index = books.indexOf(book);
				flag = false;

				System.out.println("1. 도서명");
				System.out.println("2. 도서 저자");
				System.out.println("3. 도서 가격");
				System.out.println("4. 도서 출판사");
				System.out.println("0. 수정 종료");
				System.out.print("어떤 정보를 수정하시겠습니까? : ");
				int num = sc.nextInt();
				sc.nextLine();

				switch (num) {
				case 1:
					System.out.print("수정할 도서명을 입력하세요 : ");
					String title = sc.nextLine();
					book.setTitle(title);
					break;

				case 2:
					System.out.print("수정할 도서 저자를 입력하세요 : ");
					String author = sc.nextLine();
					book.setAuthor(author);
					break;

				case 3:
					System.out.print("수정할 도서 가격을 입력하세요 : ");
					int price = sc.nextInt();
					book.setPrice(price);
					break;

				case 4:
					System.out.println("수정할 도서 출판사를 입력하세요 : ");
					String publisher = sc.nextLine();
					book.setPublisher(publisher);
					break;

				case 0:
					System.out.println("수정을 종료합니다...");
					break;

				default:
					System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				}

				System.out.println("수정 완료");
				return;
			}
		}

		if (flag) {
			System.out.println("해당 도서가 존재하지 않습니다.");
			return;
		}
	}

	public String removeBook() {
		System.out.println("\n===== 도서 삭제 =====");

		for (Book book : books) {
			System.out.println(book);
		}

		System.out.print("삭제할 도서의 번호를 입력하세요 : ");
		int num = sc.nextInt();

		for (Book book : books) {
			if (book.getNum() == num) {
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				char input = sc.next().toUpperCase().charAt(0);
				if (input == 'Y') {
					books.remove(book);
					return "삭제가 완료되었습니다";
				} else {
					return "삭제를 취소합니다";
				}
			}
		}
		return "일치하는 도서 번호가 없습니다.";

	}

	public void createFavorite() {
		System.out.println("===== 즐겨찾기 추가 =====");
		System.out.print("즐겨찾기 할 도서 번호 : ");
		int bookNum = sc.nextInt();
		boolean flag = true;
		sc.nextLine();

		if (books.isEmpty()) {
			System.out.println("등록된 도서 정보가 없습니다.");
		}

		for (Book book : books) {
			if (bookNum == book.getNum()) {
				favorites.add(book);
				System.out.println(bookNum + "번 도서가 즐겨찾기에 추가되었습니다.");
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println("해당 번호의 도서가 존재하지 않습니다.");
	}

	public String removeFavorite() {
		System.out.println("\n=====즐겨찾기 삭제=====");

		if (favorites.isEmpty()) {
			return "즐겨찾기에 추가된 도서 정보가 없습니다.";
		}

		System.out.print("삭제할 도서 번호 : ");
		int bookNum = sc.nextInt();

		for (Book book : favorites) {
			if (book.getNum() == bookNum) {
				favorites.remove(book);
				return bookNum + "번 도서가 삭제되었습니다.";
			}
		}
		return "해당 번호의 도서가 존재하지 않습니다.";
	}

	
	public void lookFavorite() {
		System.out.println("===== 즐겨찾기 조회 =====");

		if (favorites.isEmpty()) {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해주세요!");
			return;
		}

		for (Book favorite : favorites) {
			System.out.println(favorite.toString());
		}
	}

	public void selectRecommend() {
		System.out.println("\n===== 추천 도서 뽑기 =====");
		if (books.isEmpty()) {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해주세요!");
		}
		
		int random = (int) (Math.random() * books.size() + 1);
		System.out.println(books.get(random).getTitle());
	} 
}