package com.lec.quiz;
//�Է��� ���� ¦������ Ȧ������ ���

import java.util.Scanner;

public class Quiz2 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���:");
		int su = scanner.nextInt(); 
		String result = (su %2 == 0)? "¦�� �Դϴ�." : "Ȧ�� �Դϴ�.";
		System.out.println("�Է��ϴ� ���� " + result);
		scanner.close();
		
	}
	
}
