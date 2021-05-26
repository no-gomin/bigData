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
		
		
		BookLib[] books = {new BookLib("890ㄱ-01", "java", "홍길동"),
					new BookLib("990ㄴ-02", "oracle", "김하나"),
					new BookLib("790ㄷ-03", "physon", "이두리"),
					new BookLib("690ㄹ-04", "web", "양인터")};
		
		do {
			System.out.println("1.도서현황 / 2.도서검색 / 3.도서대출 / 4.도서반납 / 5.종료");
			try{
				fn = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("[ERROR] 잘못된 입력입니다. 초기화면으로 돌아갑니다.");
				System.out.println("1.도서현황 / 2.도서검색 / 3.도서대출 / 4.도서반납 / 5.종료");
				fn = sc.nextInt();
			}
			switch(fn) {
			case 1:
				for(BookLib b : books) {
					System.out.println(b);
				}
				break; //case
				
			case 2:
				System.out.println("확인하려는 도서를 입력하세요");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("본 도서관에는 해당 도서가 없습니다. 죄송합니다.");
				} else {
					System.out.println(books[idx]);
					System.out.println("1.도서 대출 2.초기 화면으로");
					int tempFn = sc.nextInt();
					if(tempFn==1) {
						System.out.print("성함을 알려주세요. ");
						borrower = sc.next();
						books[idx].checkOut(borrower);
					} else if(tempFn ==2) {
						
					} else {
						System.out.println("유효한 번호가 아닙니다. 초기화면으로 돌아갑니다.");
					}
				}
				break; //case		
				
			case 3:
				System.out.println("대출할 도서를 입력하세요.");
				bTitle = sc.next(); 
				for(idx=0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("본 도서관에는 해당 도서가 없습니다. 죄송합니다.");
				} else {
					System.out.print("성함을 알려주세요. ");
					borrower = sc.next();
					books[idx].checkOut(borrower);
					books[idx].setCheckOutDate(new Date(new GregorianCalendar(2021, 4, 1).getTimeInMillis()));  //날짜 강제 조정
				}
				break; //case
			
			case 4:
				System.out.println("반납할 도서를 입력하세요.");
				bTitle = sc.next();
				for(idx=0 ; idx<books.length ; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break; //for
					} //if
				} //for
				if(idx==books.length) {
					System.out.println("해당 도서는 본 도서관의 도서가 아닙니다.");
				} else {
					books[idx].checkIn();
				}
				break; //case
			
			case 5:
				System.out.println("종료됩니다.");
				break; //case
				
				
			default : 
				System.out.println("유효한 번호가 아닙니다. 초기화면으로 돌아갑니다.");
						
			} //switch
			
			
		} while (fn !=5 ); {
						
		} //while
		
		
					
	} //main

} //class
