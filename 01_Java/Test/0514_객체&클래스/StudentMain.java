package com.lect.ex0_quiz;

public class StudentMain {
	public static void main(String[] args) {
		
		Student[]  report = {new Student("���켺", 90,80,95), new Student("���ϴ�", 100,80,95), new Student("Ȳ����", 95,80,90),
				                new Student("������", 95,90,99), new Student("������", 90,90,90)};
		String[] title = {"��ȣ", "�̸�", "����", "����", "����", "����", "���"}; 
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
		
		System.out.println("�������������������������������������������������������");
		System.out.println("\t\t\t����ǥ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		
		for (String t : title) {
			System.out.print(t+"\t");
		} //for �׸�
		System.out.println(); 
		for (Student r : report) {
			r.infoPrint();
		} // for �л�����
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.print("\t�� ��\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		} //for ����
		System.out.println(); 
		System.out.print("\t�� ��\t");
		for (int a : avg) {
			System.out.print(a+"\t");
		} //for ���
		System.out.println();
		System.out.println("�������������������������������������������������������");
		
				
	} //main

} //class
