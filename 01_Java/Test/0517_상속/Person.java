package com.lect.ex09store;

public class Person {
	
	// 데이터
	private String id;
	private String name;
	
	// 생성자
	public Person(String id, String name) {
		this.id = id;
		this.name=name;
	}
	
	// 메소드
	public void print() {
		System.out.printf("(ID)%s\t\t(이름)%s", id, name);
	}

	// set get
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
