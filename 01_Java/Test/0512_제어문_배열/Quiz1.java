package com.lec.ex;

public class Quiz1 {
	public static void main(String[] args) {
		
		int[] arr = {10, 20, 30, 40, 50};
		int tot = 0;
		
		for (int temp : arr){
			tot += temp; 
		} //for
		
		System.out.println("�迭�� ��� ���� ������? " + tot);
	} //main
	
} //class
