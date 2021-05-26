package com.lect.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookLib implements ILendable {
	
	//데이터
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkOutDate;
	private byte state; // 대출상태(0(NORMAL):대출가능, 1(BORROWED):대출중)
	
	//생성자
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		borrower = null;
		checkOutDate = null;
		state = 0;
	}

	
	//메소드
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state != STATE_NORMAL) {
			throw new Exception("[ERROR] 대출중인 도서입니다."); // 강제오류 발생
		} 
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.printf("[%s] 도서가 대출되었습니다.\n", getBookTitle());
	}


	@Override
	public void checkIn() throws Exception {
		if(state != STATE_BORROWED) {
			throw new Exception("[ERROR] 이미 반납된 도서입니다."); // 강제오류 발생
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (24*60*60*1000);
		if(day>14) {
			System.out.println("연체료 일일 100원이 부과됩니다.");
			System.out.println("내셔야 할 연체료는 :"+(100*(day-14)));
			Scanner sc = new Scanner(System.in);
			System.out.print("연체료를 내셨나요?");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.println("엽체료 납부를 확인하였습니다.");
			} else {
				System.out.println("연체료를 내셔야 반납됩니다. 꼭 납부하여 주시기 바랍니다.");
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.printf("[%s] 도서가 반납되었습니다.\n", bookTitle);
	}
	
	@Override
	public String toString() {
		String tempState;
		if (state==STATE_BORROWED) {
			tempState = "대여중";
		} else if (state==STATE_NORMAL) {
			tempState = "대여가능";					
		} else {
			tempState = "직원문의";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				
		return String.format("\"%s(%s)\" %s著, 상태:%s(%s)", bookTitle, bookNo, writer, tempState);
//		return bookTitle+"("+bookNo+") "+writer+"著 "+tempState+sdf.format(checkOutDate.getTime());
				
	}

	
	
	//get set
	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	
	
	
	
	
	
	
}
