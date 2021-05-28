package com.lect.ex5_quiz;

public class Customer {
	
	//单捞磐
	private String name;
	private String tel;
	private String birthDay;
	private String address;
	
	
	//积己磊
	public Customer() {
	}
	public Customer(String name, String tel, String birthDay, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.birthDay = birthDay;
		this.address = address;
	}
	
	
	//皋家靛
	@Override
	public String toString() {
		return name + "\t" + tel + "\t" + birthDay + "积\t" + address+"\n";
	}

	
	
}
