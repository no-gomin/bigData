package com.lect.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookLib implements ILendable {
	
	//������
	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkOutDate;
	private byte state; // �������(0(NORMAL):���Ⱑ��, 1(BORROWED):������)
	
	//������
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		borrower = null;
		checkOutDate = null;
		state = 0;
	}

	
	//�޼ҵ�
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state != STATE_NORMAL) {
			throw new Exception("[ERROR] �������� �����Դϴ�."); // �������� �߻�
		} 
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		System.out.printf("[%s] ������ ����Ǿ����ϴ�.\n", getBookTitle());
	}


	@Override
	public void checkIn() throws Exception {
		if(state != STATE_BORROWED) {
			throw new Exception("[ERROR] �̹� �ݳ��� �����Դϴ�."); // �������� �߻�
		}
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (24*60*60*1000);
		if(day>14) {
			System.out.println("��ü�� ���� 100���� �ΰ��˴ϴ�.");
			System.out.println("���ž� �� ��ü��� :"+(100*(day-14)));
			Scanner sc = new Scanner(System.in);
			System.out.print("��ü�Ḧ ���̳���?");
			if(sc.next().equalsIgnoreCase("y")) {
				System.out.println("��ü�� ���θ� Ȯ���Ͽ����ϴ�.");
			} else {
				System.out.println("��ü�Ḧ ���ž� �ݳ��˴ϴ�. �� �����Ͽ� �ֽñ� �ٶ��ϴ�.");
			}
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.printf("[%s] ������ �ݳ��Ǿ����ϴ�.\n", bookTitle);
	}
	
	@Override
	public String toString() {
		String tempState;
		if (state==STATE_BORROWED) {
			tempState = "�뿩��";
		} else if (state==STATE_NORMAL) {
			tempState = "�뿩����";					
		} else {
			tempState = "��������";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				
		return String.format("\"%s(%s)\" %s��, ����:%s(%s)", bookTitle, bookNo, writer, tempState);
//		return bookTitle+"("+bookNo+") "+writer+"�� "+tempState+sdf.format(checkOutDate.getTime());
				
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
