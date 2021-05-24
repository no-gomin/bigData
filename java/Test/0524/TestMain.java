package com.lect.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		
		Friend[] friends = {new Friend("ȫ�浿", "010-9999-9999", "05-24"),
							new Friend("���浿", "010-8888-8888", "11-23"),
							new Friend("���ϳ�", "010-7777-7777", "04-30"),
							new Friend("�̵γ�", "010-6666-7777", "08-05"),
							new Friend("ȫ����", "010-5555-5555", "07-28"),
							new Friend("���ϳ�", "018-234-5555", "06-11")};
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("�˻��� ��ȭ��ȣ ���ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String inputTel = sc.next();
			if(inputTel.equalsIgnoreCase("x")) {
				System.out.println("�����մϴ�."); //-----------���ʿ�
				break;
			} //���� if
			boolean searchOk = false;
			for (int idx=0 ; idx<friends.length ; idx++) {
				String postTel = friends[idx].getPhone().substring(friends[idx].getPhone().length()-4);
				if(postTel.equals(inputTel)) {
					System.out.println(friends[idx]);
					searchOk = true;
				}
			} //for
			if(!searchOk) {
				System.out.println("�ش� ��ȭ��ȣ�� ģ���� �����ϴ�.");
			} 
		} while(true);

		
	} //main

} //class
