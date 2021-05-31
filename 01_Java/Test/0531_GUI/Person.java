package com.lect.ext2_swing;

public class Person {
	
	private String name;
	private String tel;
	private int age;
	
	public Person(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "이름 : "+name + " \t 전화 : " + tel + " \t 나이 : " + age+"\n";
	}
	

}
