package com.lect.ex5_quiz;

public class Customer {
	
	//������
	private String name;
	private String tel;
	private String birthDay;
	private String address;
	
	
	//������
	public Customer() {
	}
	public Customer(String name, String tel, String birthDay, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthDay = birthDay;
		this.address = address;
	}
	
	
	//�޼ҵ�
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + birthDay + "��\t" + address+"\n";
	}

	
	
}
