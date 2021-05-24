package com.lect.ex09store;

public class Staff extends Person {

	// 데이터
	public String department;

	// 생성자
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	// 메소드
	public void print() {
		super.print();
		System.out.printf("\t(부서)%s",department);
	}

	// set get
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


}
