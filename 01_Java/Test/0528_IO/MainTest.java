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
				System.out.print("회원가입을 하시려면 아무 버튼이나 누르세요. (종료 : N) : ");
				answer = scanner.next();
				
				if(answer.equalsIgnoreCase("N")) {
					break;
				}
				System.out.print("이름을 입력하세요. (예:홍길동) : ");
				String tempName = scanner.next();
				System.out.print("연락처를 입력하세요. (예:010-1234-5678) : ");
				String tempTel = scanner.next();
				System.out.print("생일을 입력하세요. (예:MM-DD) : ");
				String tempBirthDay = scanner.next();
				System.out.print("주소를 입력하세요. (예:서울시 마포구) : ");
				scanner.nextLine(); // 버퍼 정리
				String tempAddress = scanner.nextLine();
				customers.add(new Customer(tempName, tempTel, tempBirthDay, tempAddress));
								
				byte[] bs = customers.get(idx).toString().getBytes();
				os.write(bs);
				idx++;
				
				if(tempBirthDay.equals(sdf.format(today))) {
					System.out.println(tempName +"님, 생일을 축하합니다. 케이크 쿠폰 발송하여 드립니다.");
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
			System.out.println("등록된 회원이 없습니다.");
		} else {
			for(Customer c : customers) {
				System.out.print(c);
			}
			System.out.println("....이상 "+customers.size()+"명 가입");
		}
		
		
		
	}

}
