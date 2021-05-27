package com.lect.ex4_test;

public class Customer {
	
	//데이터
	private String name;
	private String tel;
	private String address;
	
	//생성자
	public Customer(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	//메소드
	@Override
	public String toString() {
		return name+"\t"+tel+"\t"+address;
	}
	
	
	//set get
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
