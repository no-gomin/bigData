package com.lect.ex0_quiz;

public class Student {
	
	/// ������
	static StudentNo studentNo = new StudentNo();   // ��ȣ(����ƽ���� �����ϵ�����)
	private int num;    // ����ü�� �Ҵ�� ��ȣ
	private String name;  // �̸�
	private int kor; // ����
	private int eng; // ����
	private int math; // ����
	private int tot;  // ����
	private int avg;  // ���
		
	// ������ �Լ�
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
	
	// �޼ҵ�
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
