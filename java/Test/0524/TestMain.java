package com.lect.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-24"),
							new Friend("나길동", "010-8888-8888", "11-23"),
							new Friend("김하나", "010-7777-7777", "04-30"),
							new Friend("이두나", "010-6666-7777", "08-05"),
							new Friend("홍세나", "010-5555-5555", "07-28"),
							new Friend("이하나", "018-234-5555", "06-11")};
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("검색할 전화번호 뒷자리(단, 종료를 원하시면 x를 입력하시오) : ");
			String inputTel = sc.next();
			if(inputTel.equalsIgnoreCase("x")) {
				System.out.println("종료합니다."); //-----------불필요
				break;
			} //종료 if
			boolean searchOk = false;
			for (int idx=0 ; idx<friends.length ; idx++) {
				String postTel = friends[idx].getPhone().substring(friends[idx].getPhone().length()-4);
				if(postTel.equals(inputTel)) {
					System.out.println(friends[idx]);
					searchOk = true;
				}
			} //for
			if(!searchOk) {
				System.out.println("해당 전화번호의 친구는 없습니다.");
			} 
		} while(true);

		
	} //main

} //class
