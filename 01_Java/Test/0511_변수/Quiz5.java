package com.lec.quiz;
// ����, ����, ���� ���� �Ҵ���	
// �� ����, ����, ���(�Ҽ�2�ڸ�) ���

public class Quiz5 {
	public static void main(String[] args) {
		
		int korean = 90;
		int english = 80;
		int math = 70;
		
		System.out.printf("���� : %d��, ���� : %d��, ���� : %d�� \n", korean, english, math);
		
		int total = korean + english + math;
		int average = (korean + english + math) / 3;
				
		System.out.printf("������ %d�� �Դϴ�. \n", total);
		System.out.printf("����� %d�� �Դϴ�. \n", average);
			
		
	}

}
