package com.lec.ex;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.print("몇단을 출력할까요? ");
		do {
			su = sc.nextInt();
			if (su>=2 && su<=9) {
				multiple(su);
				break;
			}
			System.out.print("2~9의 정수를 입력하셔야 합니다");
		} while(true);
		
		sc.close();
	} //main

	private static void multiple(int su) {
		for (int i=1 ; i<=9 ; i++) {
			System.out.printf("%d X %d = %d \n", su, i, su * i);
		} //for
			
		
	} //multiple
		
} //class
