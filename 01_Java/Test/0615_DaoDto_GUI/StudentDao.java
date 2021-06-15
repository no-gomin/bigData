package com.lect.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	// 결과 확인을 위한 상수 선언
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	// 싱글톤
	private static StudentDao INSTANCE;
	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public static StudentDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	
	// 콤보박스 생성을 위한 전공 목록
	public Vector<String> getMNamelist(){
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "scott","tiger");
			stmt = conn.createStatement();
			rs   = stmt.executeQuery(sql); 
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return mnames;
	}
		
	// 학번검색
	public StudentDto searchSNO(int sno){
		StudentDto student = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNAME, MNAME, SCORE" + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO = M.MNO AND SNO = ?"; 
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				student = new StudentDto(sname, mname, score);
			} else {
				// student는 그대로 null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return student;
	} // 학번검색 끝
	
	// 이름검색
	public ArrayList<StudentDto> searchSNAME(String sname){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE\r\n" + 
				"    FROM STUDENT S, MAJOR M\r\n" + 
				"    WHERE S.MNO = M.MNO AND SNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int sno = rs.getInt("sno");
					String mname = rs.getString("mname");
					int score = rs.getInt("score");
					student.add(new StudentDto(sno, sname, mname, score));	
				} while(rs.next());
			} else {
				// student는 그대로 null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return student;
	} // 이름검색 끝
	
	// 전공검색
	public ArrayList<StudentDto> searchMNAME(String mname){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK, A.* " + 
				"    FROM (SELECT SNAME, MNAME ||'('|| M.MNO ||')' MNAMEMNO, SCORE " + 
				"                FROM STUDENT S, MAJOR M " + 
				"                WHERE S.MNO = M.MNO AND MNAME = ? AND SEXPEL = 0" + 
				"                ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					int rank = rs.getInt("rank");
					String sname = rs.getString("sname");
					String mnameMno = rs.getString("mnameMno");
					int score = rs.getInt("score");
					student.add(new StudentDto(rank, sname,  mnameMno, score));
				} while(rs.next());
			} else {
				// student는 그대로 null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return student;
	} // 전공검색 끝
	
	// 학생입력
	public int insertSNAME(StudentDto student) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE)\r\n" + 
				"    VALUES (TO_CHAR(SYSDATE, 'YYYY') || TRIM(TO_CHAR(STUDENT_SQ.NEXTVAL, '000')),\r\n" + 
				"            ?, (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSname());
			pstmt.setString(2, student.getMname());
			pstmt.setInt(3, student.getScore());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} // 학생입력 끝
	
	// 학생 수정
	public int modifySNAME(StudentDto student) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SCORE = ? WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getScore());
			pstmt.setInt(2, student.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} // 학생수정 끝
	
	// 학생 출력(제적자 제외)
	public ArrayList<StudentDto> studentPrint(){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK, A.* " + 
				"    FROM (SELECT SNAME, MNAME ||'('|| M.MNO ||')' MNAMEMNO, SCORE " + 
				"                FROM STUDENT S, MAJOR M " + 
				"                WHERE S.MNO = M.MNO AND SEXPEL = 0" + 
				"                ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					String rank = rs.getString("rank");
					String sname = rs.getString("sname");
					String mnameMno = rs.getString("mnameMno");
					int score = rs.getInt("score");
					student.add(new StudentDto(rank, sname,  mnameMno, score));
				} while(rs.next());
			} else {
				// student는 그대로 null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return student;
	} // 학생 출력 끝
	
	// 제적처리
	public int modifySEXPEL(StudentDto student) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE SNAME = ?'";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSname());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	} // 제적처리 끝
	
	// 제적자 출력
	public ArrayList<StudentDto> sexpelPrint(){
		ArrayList<StudentDto> student = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM||'등' RANK, A.* " + 
				"    FROM (SELECT SNAME, MNAME ||'('|| M.MNO ||')' MNAMEMNO, SCORE " + 
				"                FROM STUDENT S, MAJOR M " + 
				"                WHERE S.MNO = M.MNO AND SEXPEL = 1" + 
				"                ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					String rank = rs.getString("rank");
					String sname = rs.getString("sname");
					String mnameMno = rs.getString("mnameMno");
					int score = rs.getInt("score");
					student.add(new StudentDto(rank, sname,  mnameMno, score));
				} while(rs.next());
			} else {
				// student는 그대로 null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return student;
	} // 제적자 출력 끝 
	

}
