package com.lec.quiz;
// 나이를 입력받아,65세 이상이면 "경로우대" 그외는 "일반" 출력

import java.util.Scanner;

public class Quiz4 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("나이를 입력하세요. :");
		int age = scanner.nextInt(); 
		String result = (age >= 65)? "경로우대" : "일반";
		System.out.println(result);
		scanner.close();
		
	}

}
