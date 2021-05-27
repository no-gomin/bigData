package com.lect.ex4_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String fn = null;
		HashMap<String, Customer> customer = new HashMap<String, Customer>();
		
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
			customer.put(tempName, new Customer(tempName, tempTel, tempAddress));
		} //while
		
		Iterator<String> iterator = customer.keySet().iterator();
		
		if(!iterator.hasNext()) {
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
		}
			
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customer.get(key));
		}
		
	}

}
