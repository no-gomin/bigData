package com.lect.exam;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentMng extends JFrame implements ActionListener{
	
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSno, txtSname, txtScore;
	private Vector<String> mNames;
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMnameSearch;
	private JButton btnInput, btnUpdate, btnStudentOut, btnExpelOut, btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private StudentDao studentDao = StudentDao.getInstance();
	private ArrayList<StudentDto> student;
	
	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(4,3));
		txtSno = new JTextField(10);
		txtSname = new JTextField(10);
		mNames = studentDao.getMNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMnameSearch = new JButton("전공검색");
				
		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
			
		jpbtn = new JPanel(new FlowLayout());
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
				
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		
		setSize(new Dimension(600, 400));
		setLocation(200, 200);
		setVisible(true);

		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	} // GUI 작업
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSNoSearch) { // ------------------------- 학번 검색
			String nullCheck = txtSno.getText().trim();
			if(nullCheck.equals("")) {
				txtPool.setText("학번을 입력 후 검색하세요");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
				return;
			}
			int sno = Integer.parseInt(txtSno.getText().trim());
			StudentDto studentDto = studentDao.searchSNO(sno);
			if(studentDto != null) {
				txtSname.setText(studentDto.getSname());
				comMname.setSelectedItem(studentDto.getMname());
				txtScore.setText(Integer.toString(studentDto.getScore()));
				txtPool.setText(sno+" 검색 완료");
			} else {
				txtPool.setText(sno+"은 유효하지 않는 학번입니다.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
			}
									
		} else if (e.getSource() == btnSNameSearch) { // ------------------------- 이름 검색
			String sname = txtSname.getText().trim();
			if(sname.equals("")) {
				txtPool.setText("이름을 입력 후 검색하세요");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
				return;	
				}
			student = studentDao.searchSNAME(sname);
			if(student.size() == 0) {
				txtPool.setText("해당 이름의 학생이 없습니다.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
			} else if (student.size() == 1) {
				txtSno.setText(Integer.toString(student.get(0).getSno()));
				comMname.setSelectedItem(student.get(0).getMname());
				txtScore.setText(Integer.toString(student.get(0).getScore()));
			} else if (student.size() > 1) {
				txtPool.setText("학번\t 이름\t 학과명\t 점수\n");
				for (StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMname()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			}	
					
			
		} else if (e.getSource() == btnMnameSearch) {// ------------------------- 전공 검색
			String mname = (String) comMname.getSelectedItem();
			student = studentDao.searchMNAME(mname);
			if(student.size() != 0) {
				txtPool.setText("등수\t 이름\t 학과명\t 점수\n");
				for (StudentDto s : student) {
					String temp = s.getRank()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("해당학과의 학생이 없습니다.");
			}
			// 등수가 null값으로 들어옴.
						
			
		} else if (e.getSource() == btnInput) { // ------------------------- 학생 입력
			String sname = txtSname.getText().trim();
			String mname = (String) comMname.getSelectedItem();
			int score = Integer.parseInt(txtScore.getText().trim()); 
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = studentDao.insertSNAME(newStudent);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" 학생 입력 성공" : "학생 입력 실패");
						
		} else if (e.getSource() == btnUpdate) { // ------------------------- 학생 수정
			int sno = Integer.parseInt(txtSno.getText().trim());
			int score = Integer.parseInt(txtScore.getText().trim()); 
			String sname = txtSname.getText().trim();
			StudentDto modiStudent = new StudentDto(sno, score);
			int result = studentDao.modifySNAME(modiStudent);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" 학생 수정 성공" : "학생 수정 실패");
						
		} else if (e.getSource() == btnStudentOut) { // ------------------------- 학생 출력
			student = studentDao.studentPrint();
			if(student.size() != 0) {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				txtPool.append("──────────────────────────\n");
				for(StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("학생이 없습니다.");
			}
			
		} else if (e.getSource() == btnExpelOut) { // ------------------------- 제적자 출력
			student = studentDao.sexpelPrint();
			if(student.size() != 0) {
				txtPool.setText("학번\t이름\t학과명\t점수\n");
				txtPool.append("──────────────────────────\n");
				for(StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("학생이 없습니다.");
			}
			
			
		} else if (e.getSource() == btnExpel) { // ------------------------- 제적 수정
			int sno = Integer.parseInt(txtSno.getText().trim());
			int score = Integer.parseInt(txtScore.getText().trim()); 
			String sname = txtSname.getText().trim();
			StudentDto modifySEXPEL = new StudentDto(sname);
			int result = studentDao.modifySEXPEL(modifySEXPEL);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" 학생 수정 성공" : "학생 수정 실패");
			// ORA-01756: quoted string not properly terminated 수정 안됨.
						
			
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} // if 
		
	} // action
	
	
	// 별도의 실행 메인 클래스 대신
	public static void main(String[] args) {
		new StudentMng("학사관리");
		

	}
	

}
