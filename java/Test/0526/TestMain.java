package com.lect.quiz;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		BookLib book = new BookLib("890��-01", "java", "ȫ�浿");
		BookLib book1 = new BookLib("890��-02", "hadoop", "ȫ�ϵ�");
		try {
			book.checkOut("kim");
			book1.checkOut("lee");
			book.setCheckOutDate(new Date(
			new GregorianCalendar(2020, 10, 30).getTimeInMillis())); //������ ����
			book.checkIn();
			} catch (Exception e) { 
			System.out.println(e.getMessage());
		}//try
		System.out.println(book);
		System.out.println(book1);
		
		
		
	}

}
