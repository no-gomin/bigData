package com.lec.quiz;
//입력한 수가 짝수인지 홀수인지 출력

import java.util.Scanner;

public class Quiz2 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요:");
		int su = scanner.nextInt(); 
		String result = (su %2 == 0)? "짝수 입니다." : "홀수 입니다.";
		System.out.println("입력하는 수는 " + result);
		scanner.close();
		
	}
	
}
