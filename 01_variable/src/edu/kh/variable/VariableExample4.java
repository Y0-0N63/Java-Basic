package edu.kh.variable;

public class VariableExample4 {

	public static void main(String[] args) {
		// 값의 범위 큰(double) > 작은(int)
		double temp = 3.14;
		int num = (int)temp;
		// 3 출력 -> 데이터 손실 발생 (소수점 아래 자리 손실)
		System.out.println(num);
		
		// int -> byte
		int iNum = 290;
		byte bNum = (byte)iNum;
		// 34 출력 (4byte -> 1byte, 앞의 3byte는 손실이 나고 뒤의 1byte만 출력됨)
		System.out.println(bNum);
		
		System.out.println();
		
		// 출력되는 데이터 표기법 변환
		char ch = 'A';
		System.out.println((int)ch);
		
		// int(44085) -> char 강제형변환
		int iNum2 = 44085;
		System.out.println((char)iNum2);
		
		// int형의 최대값
		int i6 = 2147483647;
		// i6가 2147483648일 때에는 오류가 발생하나, result2에서는 오류가 발생하지 않음
		int result2 = i6 + 1;
		// -2147483648 : 반대편의 가장 첫번째 숫자(int형의 최소값)로 넘어감
		System.out.println(result2);
	}
}
