package run;

import model.service.ToyFactory;

public class run {

	public static void main(String[] args) {
		ToyFactory toy = new ToyFactory();
		toy.displayMenu();
	}
}
