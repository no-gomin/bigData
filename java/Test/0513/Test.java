package com.lec.ex;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.print("����� ����ұ��? ");
		do {
			su = sc.nextInt();
			if (su>=2 && su<=9) {
				multiple(su);
				break;
			}
			System.out.print("2~9�� ������ �Է��ϼž� �մϴ�");
		} while(true);
		
		sc.close();
	} //main

	private static void multiple(int su) {
		for (int i=1 ; i<=9 ; i++) {
			System.out.printf("%d X %d = %d \n", su, i, su * i);
		} //for
			
		
	} //multiple
		
} //class
