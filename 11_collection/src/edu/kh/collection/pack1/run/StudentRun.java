package edu.kh.collection.pack1.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.kh.collection.pack1.model.service.StudentService;

public class StudentRun {

	public static void main(String[] args) {
		StudentService service = new StudentService();
//		service.ex();
		service.displayMenu();
		
//		List<Integer> numberList = new ArrayList<>();
//		numberList.add(5);
//		numberList.add(3);
//		numberList.add(1);
//		numberList.add(4);
//		numberList.add(2);
//		
//		System.out.println(numberList);
//
//		// List의 요소들을 오름차순으로 정렬해줌 > Integer는 이미 Comparable을 상속받아 compareTo()를 재정의해뒀기 때문
//		Collections.sort(numberList);
//		System.out.println(numberList);
	}
}
