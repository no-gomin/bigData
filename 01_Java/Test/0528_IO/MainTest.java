package com.lect.ex5_quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String answer = null;
		Date today = new Date();
		SimpleDateFormat  sdf = new SimpleDateFormat("MM-dd");
		ArrayList<Customer> customers = new ArrayList<Customer>();
		OutputStream os = null;
		
						
		try {
			os = new FileOutputStream("txtText/customer.txt", true);
			int idx = 0;
			while(true) {
				System.out.print("ȸ�������� �Ͻ÷��� �ƹ� ��ư�̳� ��������. (���� : N) : ");
				answer = scanner.next();
				
				if(answer.equalsIgnoreCase("N")) {
					break;
				}
				System.out.print("�̸��� �Է��ϼ���. (��:ȫ�浿) : ");
				String tempName = scanner.next();
				System.out.print("����ó�� �Է��ϼ���. (��:010-1234-5678) : ");
				String tempTel = scanner.next();
				System.out.print("������ �Է��ϼ���. (��:MM-DD) : ");
				String tempBirthDay = scanner.next();
				System.out.print("�ּҸ� �Է��ϼ���. (��:����� ������) : ");
				scanner.nextLine(); // ���� ����
				String tempAddress = scanner.nextLine();
				customers.add(new Customer(tempName, tempTel, tempBirthDay, tempAddress));
								
				byte[] bs = customers.get(idx).toString().getBytes();
				os.write(bs);
				idx++;
				
				if(tempBirthDay.equals(sdf.format(today))) {
					System.out.println(tempName +"��, ������ �����մϴ�. ����ũ ���� �߼��Ͽ� �帳�ϴ�.");
				}			
			} //while
			
	
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null) os.close(); 
			} catch (Exception e2) {
				
			}
		}
		
		
		if(customers.isEmpty()) {
			System.out.println("��ϵ� ȸ���� �����ϴ�.");
		} else {
			for(Customer c : customers) {
				System.out.print(c);
			}
			System.out.println("....�̻� "+customers.size()+"�� ����");
		}
		
		
		
	}

}
