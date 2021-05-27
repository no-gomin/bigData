package com.lect.ex09store;

public class Staff extends Person {

	// ������
	public String department;

	// ������
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	// �޼ҵ�
	public void print() {
		super.print();
		System.out.printf("\t(�μ�)%s",department);
	}

	// set get
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}


}
