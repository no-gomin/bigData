package com.lect.ex4_test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String fn = null;
		ArrayList<Customer> customer = new ArrayList<Customer>();
				
		while(true) {
			System.out.print("ȸ���� �Է½÷��� �ƹ� ��ư�̳� �����ʽÿ�. (���� : N)");
			fn = scanner.next();
			if (fn.equalsIgnoreCase("N")) {
				break;
			}
			System.out.print("�̸��� �Է��ϼ���. ");
			String tempName = scanner.next();
			System.out.print("��ȭ��ȣ�� �Է��ϼ���. ");
			String tempTel = scanner.next();
			scanner.nextLine();  // ���� ������
			System.out.print("�ּҸ� �Է��ϼ���. ");
			String tempAddress = scanner.nextLine();
			customer.add(new Customer(tempName, tempTel, tempAddress));
		} //while
		
		if (customer.size() != 0) {
			for (Customer c : customer) {
				System.out.println(c);		
			}
		} else {	
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
		}
		
		
	}

}
