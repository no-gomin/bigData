package com.lec.quiz;
// �μ��� �Է¹޾�,
// �μ��� ������ ���� O, X�� ���
// ù��° ���� �� ū�� ���� O, X�� ���

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("ù ��° ���� �Է��ϼ���:");
		int numFirst = scanner1.nextInt();	

		Scanner scanner2 = new Scanner(System.in);
		System.out.println("�� ��° ���� �Է��ϼ���:");
		int numSecond = scanner2.nextInt();
		
		scanner1.close();		
		scanner2.close();
				
		String result1 = (numFirst == numSecond)? "O" : "X";
		System.out.println("�� ���� ������?" + result1);
		
		String result2 = (numFirst > numSecond)? "O" : "X";
		System.out.println("ù ��° ���� �� ū����??" + result2);
			
	}

}
