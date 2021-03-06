package com.lect.ex0_quiz;

public class StudentMain {
	public static void main(String[] args) {
		
		Student[]  report = {new Student("薑辦撩", 90,80,95), new Student("梯ж棺", 100,80,95), new Student("?笠允?", 95,80,90),
				                new Student("鬼翕錳", 95,90,99), new Student("嶸嬴檣", 90,90,90)};
		String[] title = {"廓??", "檜葷", "措橫", "艙橫", "熱з", "識薄", "ゎ敕"}; 
		int[] tot = new int[report.length];
		int[] avg = new int[report.length];
		
		for (Student r : report) {
			tot[0] += r.getKor(); 
			tot[1] += r.getEng();
			tot[2] += r.getMath();
			tot[3] += r.getTot();
			tot[4] += r.getAvg();
		} //for tot
		
		for (int idx=0 ; idx<avg.length ; idx++) {
			avg[idx] = tot[idx] / report.length; 
		} //for avg
		
		System.out.println("﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥");
		System.out.println("\t\t\t撩瞳ル");
		System.out.println("天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天");
		
		for (String t : title) {
			System.out.print(t+"\t");
		} //for о跡
		System.out.println(); 
		for (Student r : report) {
			r.infoPrint();
		} // for з儅撩瞳
		System.out.println("天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天天");
		System.out.print("\t識 薄\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		} //for 識м
		System.out.println(); 
		System.out.print("\tゎ 敕\t");
		for (int a : avg) {
			System.out.print(a+"\t");
		} //for ゎ敕
		System.out.println();
		System.out.println("﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥");
		
				
	} //main

} //class
