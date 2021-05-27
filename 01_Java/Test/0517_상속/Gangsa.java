package com.lect.ex09store;

public class Gangsa extends Person {
	
	// ������
	private String subject;

	// ������
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	// �޼ҵ�
	public void print() {
		super.print();
		System.out.printf("\t(�μ�)%s", subject);
	}

	
	// set get
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}



}
