package com.lect.ex09store;

public class Main {
	public static void main(String[] args) {
		
//		Person person1 = new Student("A01","���л�", "JAVA��");
//		Person person2 = new Student("A02", "ȫ�浿", "C++qks");
//		Person person3 = new Staff("S01", "������", "������");
//		Person person4 = new Staff("S02", "������", "���������");
//		Person person5 = new Gangsa("G01", "������", "���α׷���");
		
		Person[] person = {new Student("A01","���л�", "JAVA��"), new Student("A02", "ȫ�浿", "C++��"),
							new Staff("S01", "������", "������"), new Staff("S02", "������", "���������"),
							new Gangsa("G01", "������", "���α׷���")}; 
			
		for (Person p : person) {
			p.print();
			System.out.println();	
		} //for
		
	} //main

} //class


