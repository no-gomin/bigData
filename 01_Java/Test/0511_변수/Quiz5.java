package com.lec.quiz;
// 국어, 영어, 수학 점수 할당후	
// 각 점수, 총점, 평균(소수2자리) 출력

public class Quiz5 {
	public static void main(String[] args) {
		
		int korean = 90;
		int english = 80;
		int math = 70;
		
		System.out.printf("국어 : %d점, 영어 : %d점, 수학 : %d점 \n", korean, english, math);
		
		int total = korean + english + math;
		int average = (korean + english + math) / 3;
				
		System.out.printf("총점은 %d점 입니다. \n", total);
		System.out.printf("평균은 %d점 입니다. \n", average);
			
		
	}

}
