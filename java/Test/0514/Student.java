package com.lect.ex0_quiz;

public class Student {
	
	/// 데이터
	static StudentNo studentNo = new StudentNo();   // 번호(스태틱으로 공유하도록함)
	private int num;    // 각객체별 할당될 번호
	private String name;  // 이름
	private int kor; // 국어
	private int eng; // 영어
	private int math; // 수학
	private int tot;  // 총점
	private int avg;  // 평균
		
	// 생성자 함수
	public Student() {
	}
	public Student(String name, int kor, int eng, int math) {
		num = studentNo.Num++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math= math;
		tot = kor + eng + math;
		avg = tot / 3;
	}
	
	// 메소드
	public void infoPrint() {
		System.out.printf("%d \t%s \t%d \t%d \t%d \t%d \t%d \n", num, name, kor, eng, math, tot, avg);
	}
	
	// set & get
	public void setName(String name) {
		this.name=name;
	}
	public void setKor (int kor) {
		this.kor = kor;
	}
	public void setEng (int eng) {
		this.eng = eng;
	}
	public void setMath (int math) {
		this.math = math;
	}  
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return tot;
	}
	public int getAvg() {
		return avg;
	}
	
} //class
