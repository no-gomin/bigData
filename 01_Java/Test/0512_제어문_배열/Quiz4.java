package com.lec.ex;

public class Quiz4 {
	public static void main(String[] args) {
		
		int money = 2680;
		int[] coinUnit = {500, 100, 50, 10};
		int[] su;
		su = new int[coinUnit.length];
		
		for (int i = 0 ; i<coinUnit.length; i++) {
			while(money>=coinUnit[i]) {
				money -= coinUnit[i];
				su[i]++;
			}
			
		} //for i
		
		for (int j=0; j<coinUnit.length; j++) {
			System.out.printf("%d원짜리 %d개, ", coinUnit[j], su[j]);	
		} //for j
		
		
	} //main

} //class


