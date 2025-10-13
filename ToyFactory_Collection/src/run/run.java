package run;

import model.service.ToyFactory;

public class run {

	public static void main(String[] args) {
		// getIngredient + 연령별 >> 출력 양식 바꾸기
		ToyFactory toy = new ToyFactory();
		toy.displayMenu();
	}
}
