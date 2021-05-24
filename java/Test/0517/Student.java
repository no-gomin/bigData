package com.lect.ex09store;

public class Student extends Person {
	
	// ������
	private String ban;
	
	// ������
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	
	// �޼ҵ�
	public void print() {
		super.print();
		System.out.printf("\t(��)%s", ban);
	}

	
	// set get
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}

	
}
