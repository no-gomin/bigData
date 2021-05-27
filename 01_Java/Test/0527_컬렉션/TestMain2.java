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
			System.out.print("회원을 입력시려면 아무 버튼이나 누르십시오. (종료 : N)");
			fn = scanner.next();
			if (fn.equalsIgnoreCase("N")) {
				break;
			}
			System.out.print("이름을 입력하세요. ");
			String tempName = scanner.next();
			System.out.print("전화번호를 입력하세요. ");
			String tempTel = scanner.next();
			scanner.nextLine();  // 버퍼 정리용
			System.out.print("주소를 입력하세요. ");
			String tempAddress = scanner.nextLine();
			customer.put(tempName, new Customer(tempName, tempTel, tempAddress));
		} //while
		
		Iterator<String> iterator = customer.keySet().iterator();
		
		if(!iterator.hasNext()) {
			System.out.println("등록된 회원이 없습니다.");
		}
			
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(customer.get(key));
		}
		
	}

}
