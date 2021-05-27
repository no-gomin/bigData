package com.lect.ex01_string;

public class Friend {
	
	//데이터
	private String name;
	private String phone;
	private String birthday;
	
	//생성자
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	
	//메소드
	@Override
	public String toString() {
		return "이 름 : "+name+"\n핸드폰 : "+phone+"\n생일 : "+birthday+"\n";
	}

	//get set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



}
