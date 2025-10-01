package com.hw1.run;

import java.util.ArrayList;
import java.util.List;

import com.hw1.model.dto.Friend;

public class Run {

	public static void main(String[] args) {
		// Friend 객체만 넣을 수 있는 ArrayList 객체 생성
		List<Friend> arr = new ArrayList<>();
		
		// 짱구, 철수, 유리, 훈이, 맹구 객체 생성 > ArrayList에 추가
		arr.add(new Friend("짱구"));
		arr.add(new Friend("철수"));
		arr.add(new Friend("유리"));
		arr.add(new Friend("훈이"));
		arr.add(new Friend("맹구"));
		
		// List에서 다섯 객체 중 랜덤으로 하나 뽑아 > 골목 대장 누군지 출력
		int random = (int)(Math.random() * 5);
		System.out.println(arr.get(random).getName() + "가 떡잎방법대 대장이다!");
		
	}

}
