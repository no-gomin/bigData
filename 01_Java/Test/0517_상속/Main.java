package com.lect.ex09store;

public class Main {
	public static void main(String[] args) {
		
//		Person person1 = new Student("A01","나학생", "JAVA반");
//		Person person2 = new Student("A02", "홍길동", "C++qks");
//		Person person3 = new Staff("S01", "나직원", "교무팀");
//		Person person4 = new Staff("S02", "나도요", "취업지원팀");
//		Person person5 = new Gangsa("G01", "나선생", "프로그래밍");
		
		Person[] person = {new Student("A01","나학생", "JAVA반"), new Student("A02", "홍길동", "C++반"),
							new Staff("S01", "나직원", "교무팀"), new Staff("S02", "나도요", "취업지원팀"),
							new Gangsa("G01", "나선생", "프로그래밍")}; 
			
		for (Person p : person) {
			p.print();
			System.out.println();	
		} //for
		
	} //main

} //class


