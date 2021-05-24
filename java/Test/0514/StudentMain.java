package com.lect.ex0_quiz;

public class StudentMain {
	public static void main(String[] args) {
		
		Student[]  report = {new Student("Á¤¿ì¼º", 90,80,95), new Student("±èÇÏ´Ã", 100,80,95), new Student("È²Á¤¹Î", 95,80,90),
				                new Student("°­µ¿¿ø", 95,90,99), new Student("À¯¾ÆÀÎ", 90,90,90)};
		String[] title = {"¹øÈ£", "ÀÌ¸§", "±¹¾î", "¿µ¾î", "¼öÇÐ", "ÃÑÁ¡", "Æò±Õ"}; 
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
		
		System.out.println("¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á");
		System.out.println("\t\t\t¼ºÀûÇ¥");
		System.out.println("¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ");
		
		for (String t : title) {
			System.out.print(t+"\t");
		} //for Ç×¸ñ
		System.out.println(); 
		for (Student r : report) {
			r.infoPrint();
		} // for ÇÐ»ý¼ºÀû
		System.out.println("¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ¤Ñ");
		System.out.print("\tÃÑ Á¡\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		} //for ÃÑÇÕ
		System.out.println(); 
		System.out.print("\tÆò ±Õ\t");
		for (int a : avg) {
			System.out.print(a+"\t");
		} //for Æò±Õ
		System.out.println();
		System.out.println("¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á");
		
				
	} //main

} //class
