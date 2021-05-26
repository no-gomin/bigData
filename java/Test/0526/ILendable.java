package com.lect.quiz;

public interface ILendable {
	
	public byte STATE_BORROWED = 1; // 대출중=1
	public byte STATE_NORMAL = 0;  // 대출가능=0
	
	public void checkOut(String borrower) throws Exception;  // 도서 대출 (+예외발생)	
	public void checkIn() throws Exception;  // 도서 반납 (+예외발생)
	

}
