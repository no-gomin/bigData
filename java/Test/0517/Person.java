package com.lect.ex09store;

public class Person {
	
	// ������
	private String id;
	private String name;
	
	// ������
	public Person(String id, String name) {
		this.id = id;
		this.name=name;
	}
	
	// �޼ҵ�
	public void print() {
		System.out.printf("(ID)%s\t\t(�̸�)%s", id, name);
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
