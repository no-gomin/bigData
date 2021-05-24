package com.lect.ex09store;

public class Gangsa extends Person {
	
	// 데이터
	private String subject;

	// 생성자
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	
	// 메소드
	public void print() {
		super.print();
		System.out.printf("\t(부서)%s", subject);
	}

	
	// set get
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}



}
