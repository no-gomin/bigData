package com.lec.quiz;
// 두수를 입력받아,
// 두수가 같은지 여부 O, X로 출력
// 첫번째 수가 더 큰지 여부 O, X로 출력

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("첫 번째 수를 입력하세요:");
		int numFirst = scanner1.nextInt();	

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("두 번째 수를 입력하세요:");
		int numSecond = scanner2.nextInt();
		
		scanner1.close();		
		scanner2.close();
				
		String result1 = (numFirst == numSecond)? "O" : "X";
		System.out.println("두 수가 같나요?" + result1);
		
		String result2 = (numFirst > numSecond)? "O" : "X";
		System.out.println("첫 번째 수가 더 큰가요??" + result2);
			
	}

}
