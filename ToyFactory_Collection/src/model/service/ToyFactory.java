package model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import model.dto.Toy;

/**
 * 
 */
public class ToyFactory {
	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toySet = new HashSet<Toy>();
	private Map<Integer, String> ingredientMap = new HashMap<Integer, String>();

	public ToyFactory() {
		ingredientMap.put(1, "면직물");
		ingredientMap.put(2, "플라스틱");
		ingredientMap.put(3, "유리");
		ingredientMap.put(4, "고무");

		// 전달인자 (1, 4)
		toySet.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, addIngredients(1, 4)));
		toySet.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, addIngredients(1, 2)));
		toySet.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, addIngredients(1, 2)));
		toySet.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, addIngredients(1, 2)));
		toySet.add(new Toy("파피", 12, 57000, "빨간색", 19931225, addIngredients(1, 2, 4)));
	}

	// 매개변수 (int i, int j) > 매개변수의 개수가 고정일 때 오류가 생김 > 가변인자 사용
	// 가변인자 : 매개변수의 수가 정확히 몇 개인지 특정할 수 없을 때 사용 : 자료형...변수명
	// 가변인자를 통해 들어온 매개변수의 데이터 타입 == 배열
	/**
	 * 매개변수로 전달받은 값들이 ingredientMap에 있는지 확인 > Set 형태로 반환
	 * 
	 * @param ingredients
	 * @return
	 */
	private Set<String> addIngredients(int... ingredients) {
		// 1. 매개변수로 전달받은 ingredients > 배열로 정수형 데이터가 여러 개 들어옴
		// 재료를 저장해 반환할 Set 객체 생성 (Set<String> ingredient)
		Set<String> addedIngredients = new HashSet<String>();

		// 2. addedIngredients에 Map에 존재하는 재료명인지 검사 후 추가
		for (int ingredientKey : ingredients) {
			// .get() : key로 value 가져오기 > Map에서 재료 고유 번호(key)에 대응하는 재료명 (value)가져와서 Set에
			// 추가하기
			// if) map에 없는 key 입력 > value값으로 null
			String ingredientValue = ingredientMap.get(ingredientKey);

			if (ingredientValue != null) {
				// 재료 존재 > Set(addedIngredients)에 추가
				addedIngredients.add(ingredientValue);
			}
		}

		// Set 형태로 반환 ex) addIngredients(1, 4) >> [면직물, 플라스틱]
		return addedIngredients;
	}

	public void displayMenu() {
		int input = 0;
		do {
			System.out.println("\n<<플레이타임 공장>>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			input = sc.nextInt();

			switch (input) {
			case 1:
				lookToy();
				break;
			case 2:
				System.out.println(makeNewToy());
				break;
			case 3:
				System.out.println(deleteToy());
				break;
			case 4:
				lookDate();
				break;
			case 5:
				lookAge();
				break;
			case 6:
				System.out.println(addIngredient());
				break;
			case 7:
				System.out.println(removeIngredient()); break;
			case 0:
				System.out.println("프로그램 종료...");
				break;
			default:
				System.out.println("해당하는 번호만 써주세요.");
			}
		} while (input != 0);
	}

	public void lookToy() {
		System.out.println("\n<전체 장난감 목록>");
		if (toySet.isEmpty()) {
			System.out.println("등록된 장난감이 없습니다.");
		} else {
			Iterator<Toy> it = toySet.iterator();
			int i = 1;
			while (it.hasNext()) {
				Toy temp = it.next();
				System.out.println(i++ + ". " + temp.toString());
			}
		}
	}

	public String makeNewToy() {
		Set<String> ingredients = new HashSet<>();

		System.out.println("\n<새로운 장난감 추가>");

		System.out.print("장난감 이름 : ");
		String name = sc.next();

		System.out.print("사용 가능 연령 : ");
		int age = sc.nextInt();

		System.out.print("가격 : ");
		int price = sc.nextInt();

		System.out.print("색상 : ");
		String color = sc.next();

		System.out.print("제조일 (YYYYMMDD 형식으로 입력) : ");
		int date = sc.nextInt();

		while (true) {
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			String input = sc.next();

			if (input.equals("q")) {
				break;
			}

			// 입력한 재료가 ingredientMap에 존재 > Set에 추가
			if (ingredientMap.containsValue(input)) {
				ingredients.add(input);
			} else {
				// 존재하지 않으면 > 재료 추가
				System.out.println("존재하지 않는 재료");
			}
		}

		if (toySet.add(new Toy(name, age, price, color, date, ingredients))) {
			return "새로운 장난감이 추가되었습니다.";
		} else {
			return "추가 실패";
		}
	}

	public String deleteToy() {
		System.out.print("\n삭제할 장난감의 이름을 입력하세요 : ");
		String input = sc.next();

		for (Toy toy : toySet) {
			if (toy.getToyName().equals(input)) {
				toySet.remove(toy);
				return "장난감이 삭제되었습니다.";
			}
		}
		return "일치하는 장난감이 없습니다.";
	}

	public void lookDate() {
		System.out.println("\n<제조일 순으로 장난감들을 정렬>");

		// toySet을 list로 변환 > comparator 사용해서 Toy의 제조일을 기준으로 정렬하기
		List<Toy> list = new ArrayList<>(toySet);

		Collections.sort(list, new Comparator<Toy>() {
			@Override
			public int compare(Toy o1, Toy o2) {
				return o1.getDate() - o2.getDate();
			}
		});

		if (list.isEmpty()) {
			System.out.println("등록된 장난감이 없습니다.");
		} else {
			int i = 1;
			for (Toy toy : list) {
				System.out.println(i++ + ". " + toy.toString());
			}
		}
	}

	public void lookAge() {
		System.out.println("<연령별로 사용 가능한 장난감>");

		// Map 사용하기(key : 연령, value : 장난감이 저장된 배열)
		Map<Integer, List<Toy>> toyMap = new HashMap<>();
		// toySet을 순회하며 > 해당 연령이 toyMap의 key에 존재하는지 확인
		for (Toy toy : toySet) {
			int age = toy.getAge();
			// 존재하면 > toy를 toyMap 중 age 키에 연결된 value 객체(List) 가져와 > list에 추가해주기
			if (toyMap.containsKey(age)) {
				toyMap.get(age).add(toy);
			} else {
				// 존재하지 않으면 > 새로운 list 생성해 현재 toy 추가하기
				List<Toy> newList = new ArrayList<>();
				newList.add(toy);
				// Map에 age(key)와 list 추가해주기
				toyMap.put(age, newList);
			}
		}

		// 연령별로 출력하기
		for
		Set<Integer> keySet = toyMap.keySet();
		for (Integer key : keySet) {
			System.out.println(toyMap.get(key));
		}
	}

	public String addIngredient() {
		System.out.println("<재료 추가>");
		
		// 현재 재료 보여주기
		System.out.println("---현재 등록된 재료---");
		Set<Integer> keySet = ingredientMap.keySet();

		int i = 1;
		for (Integer key : keySet) {
			System.out.println(i++ + ". " + ingredientMap.get(key));
		}

		// 재료 추가하기
		System.out.print("재료 고유 번호(key) 입력 : ");
		int input = sc.nextInt();

		System.out.print("재료명 입력 : ");
		String ingredient = sc.next();

		// 해당 키가 있는 경우 > ingredientMap
		if (ingredientMap.containsKey(input)) {
			System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
			System.out.print("덮어쓰시겠습니까? (Y/N) : ");
			char answer = sc.next().toUpperCase().charAt(0);

			if (answer == 'Y') {
				ingredientMap.put(input, ingredient);
				return "재료가 성공적으로 덮어쓰기 되었습니다.";
			} else {
				return "재료 추가를 종료합니다.";
			}
		} else {
			// ingredientMap에 해당 키 값이 없을 경우 > ingredientMap에 추가
			ingredientMap.put(input, ingredient);
		}
		return "새로운 재료가 성공적으로 등록되었습니다.";
	}
	
	public String removeIngredient() {
		System.out.println("<재료 삭제>");
		
		// 현재 재료 보여주기
		Set<Integer> keySet = ingredientMap.keySet();
		
		int i = 1;
		for(Integer key : keySet) {
			System.out.println(i++ + ". " + ingredientMap.get(key));
		}
		
		// 재료 삭제하기
		System.out.print("삭제할 재료명 입력 : ");
		String ingredient = sc.next();
		
		for(Integer key : keySet) {
			// 해당 재료명을 value로 가진 key가 있는지 확인
			if(ingredientMap.get(key).equals(ingredient)) {
				ingredientMap.remove(key);
				return "재료 '" + ingredient + "'가 성공적으로 제거되었습니다.";
			}
		}
		return "해당 이름의 재료가 존재하지 않습니다.";
	}
}
