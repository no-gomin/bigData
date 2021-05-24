package com.lect.ex09store;

public class Student extends Person {
	
	// 데이터
	private String ban;
	
	// 생성자
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	
	// 메소드
	public void print() {
		super.print();
		System.out.printf("\t(반)%s", ban);
	}

	
	// set get
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}

	
}
