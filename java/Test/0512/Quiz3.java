package com.lec.ex;

public class Quiz3 {
	public static void main(String[] args) {
		
		int[] num = {76,45,34,89,100,50,90,92};
		int minNum = 0, maxNum = 0, sumNum = 0;
		double avgNum;
		
		for (int idx = 0 ; idx<num.length; idx++) {
			if (minNum>num[idx]) {
				minNum = num[idx];
			} //if �ּҰ�
			if (maxNum<num[idx]) {
				maxNum = num[idx];
			} //if �ִ밪
			sumNum += num[idx];
		} //for
		avgNum = sumNum / num.length; 
		System.out.printf("����:%d, ���:%.2f, �ִ밪:%d, �ּҰ�:%d", sumNum, avgNum, maxNum, minNum );
		
				
		
	} //main

} //class
