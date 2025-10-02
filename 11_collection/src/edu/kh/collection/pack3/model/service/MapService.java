package edu.kh.collection.pack3.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.kh.collection.pack3.model.dto.Member;

public class MapService {
	public void ex1() {
		// HashMap<K, V> : Map의 자식 클래스 중 가장 대표되는 Map
		Map<Integer, String> map = new HashMap<>();

		// Map.put(Integer Key, String Value) : 요소 추가 메서드
		map.put(1, "홍길동"); // { 1=홍길동 } > 엔트리 생성
		map.put(2, "고길동");
		map.put(3, "김길동");
		map.put(4, "박길동");
		map.put(5, "이길동");
		map.put(6, "최길동");

		// key 중복 테스트 > 중복 허용 X > 새로운 Value 값으로 덮어쓰기
		map.put(1, "최보윤");

		// value 중복 테스트 > 중복 허용 O
		map.put(7, "최길동");

		System.out.println(map);
	}

	public void ex2() {
		// VO, DTO와 같은 값 저장용 객체 : 특정 데이터 묶음의 재사용이 많은 경우 사용
		// > 재사용이 적은 VO는 오히려 코드 낭비 > Map을 이용해 VO와 비슷한 코드 작성 가능

		// 1) VO 버전
		Member member = new Member();

		member.setId("userId");
		member.setPw("pass01");
		member.setAge(30);
		// 필드-값이 Map의 엔트리처럼 하나로 묶여있음

		// 2) Map 버전
		// Value가 Object Type == 어떤 객체든 Value에 들어올 수 있다!
		Map<String, Object> map = new HashMap<>();

		map.put("id", "user02");
		map.put("pw", "pass02");
		map.put("age", 25);

		// map 값 출력 : Object(Value) Map.get(Key) : 배개변수로 전달받은 Key와 대응되는 Value 반환
		System.out.println(map.get("id"));
		System.out.println(map.get("pw"));
		System.out.println(map.get("age"));

		System.out.println("----------------------");

		// Map에 저장된 데이터 순차적으로 접근하기 > keySet() : Key만 모아서 Set으로 반환
		// id, pw, age라는 key가 저장된 Set 반환
		Set<String> set = map.keySet();

		System.out.println("keySet() : " + set);

		for (String key : set) {
			System.out.println(map.get(key));
		}
	}

	public void ex3() {
		// List에 Map을 여러 개 추가하여 다뤄보기
		// List 객체 생성 > 해당 list에는 Map만 들어올 수 있게 제한
		List<Map<String, Object>> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			// Map 객체 생성
			// LinkedHashMap : put한 순서 유지
			Map<String, Object> map = new LinkedHashMap<>();
			
			// Map에 데이터 추가
			map.put("id", "user0" + i);
			map.put("pw", "pass0" + i);
			
			// Map을 list에 추가
			list.add(map);
		}
		
		// for문 종료 시 > list에 10개의 Map 객체 추가되어있음
		System.out.println(list);
		
		// 향상된 for문 이용 > key가 "id"에 대응되는 value 값 전부 출력하기
		for(Map<String, Object> temp : list) {
			System.out.println(temp.get("id"));
		}
	}
}
