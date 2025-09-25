package edu.kh.oarr.run;

import edu.kh.oarr.model.service.MemberService;

public class MemberRun {

	public static void main(String[] args) {
		MemberService service = new MemberService();
								   // ㄴ기본 생성자 > 미리 배열에 3명 집어넣기 수행
		service.displayMenu();
	}
}
