package edu.kh.oop.practice.run;

import edu.kh.oop.practice.model.service.BookService;
import edu.kh.oop.practice.model.service.HeroService;

public class PracticeRun {

	public static void main(String[] args) {
		BookService book = new BookService();
		book.practice();
		
		HeroService hero = new HeroService();
//		hero.practice();
	}

}
