package com.lect.quiz;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookTestMain {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int fn, idx;
		String bTitle, borrower;
		
		
		BookLib[] books = {new BookLib("890��-01", "java", "ȫ�浿"),
					new BookLib("990��-02", "oracle", "���ϳ�"),
					new BookLib("790��-03", "physon", "�̵θ�"),
					new BookLib("690��-04", "web", "������")};
		
		do {
			System.out.println("1.������Ȳ / 2.�����˻� / 3.�������� / 4.�����ݳ� / 5.����");
			try{
				fn = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("[ERROR] �߸��� �Է��Դϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
				System.out.println("1.������Ȳ / 2.�����˻� / 3.�������� / 4.�����ݳ� / 5.����");
				fn = sc.nextInt();
			}
			switch(fn) {
			case 1:
				for(BookLib b : books) {
					System.out.println(b);
				}
				break; //case
				
			case 2:
				System.out.println("Ȯ���Ϸ��� ������ �Է��ϼ���");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("�� ���������� �ش� ������ �����ϴ�. �˼��մϴ�.");
				} else {
					System.out.println(books[idx]);
					System.out.println("1.���� ���� 2.�ʱ� ȭ������");
					int tempFn = sc.nextInt();
					if(tempFn==1) {
						System.out.print("������ �˷��ּ���. ");
						borrower = sc.next();
						books[idx].checkOut(borrower);
					} else if(tempFn ==2) {
						
					} else {
						System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
					}
				}
				break; //case		
				
			case 3:
				System.out.println("������ ������ �Է��ϼ���.");
				bTitle = sc.next(); 
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("�� ���������� �ش� ������ �����ϴ�. �˼��մϴ�.");
				} else {
					System.out.print("������ �˷��ּ���. ");
					borrower = sc.next();
					books[idx].checkOut(borrower);
					books[idx].setCheckOutDate(new Date(new GregorianCalendar(2021, 4, 1).getTimeInMillis()));  //��¥ ���� ����
				}
				break; //case
			
			case 4:
				System.out.println("�ݳ��� ������ �Է��ϼ���.");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("�ش� ������ �� �������� ������ �ƴմϴ�.");
				} else {
					books[idx].checkIn();
				}
				break; //case
			
			case 5:
				System.out.println("����˴ϴ�.");
				break; //case
				
				
			default : 
				System.out.println("��ȿ�� ��ȣ�� �ƴմϴ�. �ʱ�ȭ������ ���ư��ϴ�.");
						
			} //switch
			
			
		} while (fn !=5 ); {
						
		} //while
		
		
					
	} //main

} //class
