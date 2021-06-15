package com.lect.exam;

public class StudentDto {
	
	private int mno;
	private String mname;

	private int sno;
	private String sname;
	// private int mno;
	private int score;
	private int sexpel;
	private int rank;
	private String mnameMno;
	
	// 입력
	public StudentDto(String sname, int mno, int score, int sexpel) {
		this.sname = sname;
		this.mno = mno;
		this.score = score;
		this.sexpel = sexpel;
	}
	
	// 학번 검색
	public StudentDto(String sname, String mname, int score) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	
	// 이름 검색
	public StudentDto(int sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	// 전공검색
	public StudentDto(String rank, String sname, String mnameMno, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mnameMno = mnameMno;
		this.score = score;
	}	
	
	// 출력	
	public StudentDto(int mno, String mname, int sno, String sname, int score, int sexpel) {
		this.mno = mno;
		this.mname = mname;
		this.sno = sno;
		this.sname = sname;
		this.score = score;
		this.sexpel = sexpel;
	}

	
	// 학생 수정
	public StudentDto(int sno, int score) {
		this.score = score;
		this.sno = sno;
	}
	
	// 제적 수정
	public StudentDto(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "StudentDto [mno=" + mno + ", mname=" + mname + ", sno=" + sno + ", sname=" + sname + ", score=" + score
				+ ", sexpel=" + sexpel + ", rank=" + rank + ", mnameMno=" + mnameMno + "]";
	}

	public int getMno() {
		return mno;
	}

	public String getMname() {
		return mname;
	}

	public int getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public int getScore() {
		return score;
	}

	public int getSexpel() {
		return sexpel;
	}

	public int getRank() {
		return rank;
	}

	public String getMnameMno() {
		return mnameMno;
	}


	
	
	
	
	

}
