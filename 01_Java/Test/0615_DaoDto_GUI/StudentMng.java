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
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMnameSearch = new JButton("�����˻�");
				
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSno);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSname);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
			
		jpbtn = new JPanel(new FlowLayout());
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
				
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
	} // GUI �۾�
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSNoSearch) { // ------------------------- �й� �˻�
			String nullCheck = txtSno.getText().trim();
			if(nullCheck.equals("")) {
				txtPool.setText("�й��� �Է� �� �˻��ϼ���");
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
				txtPool.setText(sno+" �˻� �Ϸ�");
			} else {
				txtPool.setText(sno+"�� ��ȿ���� �ʴ� �й��Դϴ�.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
			}
									
		} else if (e.getSource() == btnSNameSearch) { // ------------------------- �̸� �˻�
			String sname = txtSname.getText().trim();
			if(sname.equals("")) {
				txtPool.setText("�̸��� �Է� �� �˻��ϼ���");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
				return;	
				}
			student = studentDao.searchSNAME(sname);
			if(student.size() == 0) {
				txtPool.setText("�ش� �̸��� �л��� �����ϴ�.");
				txtSno.setText("");
				txtSname.setText("");
				comMname.setSelectedItem("");	
				txtScore.setText("");
			} else if (student.size() == 1) {
				txtSno.setText(Integer.toString(student.get(0).getSno()));
				comMname.setSelectedItem(student.get(0).getMname());
				txtScore.setText(Integer.toString(student.get(0).getScore()));
			} else if (student.size() > 1) {
				txtPool.setText("�й�\t �̸�\t �а���\t ����\n");
				for (StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMname()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			}	
					
			
		} else if (e.getSource() == btnMnameSearch) {// ------------------------- ���� �˻�
			String mname = (String) comMname.getSelectedItem();
			student = studentDao.searchMNAME(mname);
			if(student.size() != 0) {
				txtPool.setText("���\t �̸�\t �а���\t ����\n");
				for (StudentDto s : student) {
					String temp = s.getRank()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("�ش��а��� �л��� �����ϴ�.");
			}
			// ����� null������ ����.
						
			
		} else if (e.getSource() == btnInput) { // ------------------------- �л� �Է�
			String sname = txtSname.getText().trim();
			String mname = (String) comMname.getSelectedItem();
			int score = Integer.parseInt(txtScore.getText().trim()); 
			StudentDto newStudent = new StudentDto(sname, mname, score);
			int result = studentDao.insertSNAME(newStudent);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" �л� �Է� ����" : "�л� �Է� ����");
						
		} else if (e.getSource() == btnUpdate) { // ------------------------- �л� ����
			int sno = Integer.parseInt(txtSno.getText().trim());
			int score = Integer.parseInt(txtScore.getText().trim()); 
			String sname = txtSname.getText().trim();
			StudentDto modiStudent = new StudentDto(sno, score);
			int result = studentDao.modifySNAME(modiStudent);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" �л� ���� ����" : "�л� ���� ����");
						
		} else if (e.getSource() == btnStudentOut) { // ------------------------- �л� ���
			student = studentDao.studentPrint();
			if(student.size() != 0) {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				txtPool.append("����������������������������������������������������\n");
				for(StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("�л��� �����ϴ�.");
			}
			
		} else if (e.getSource() == btnExpelOut) { // ------------------------- ������ ���
			student = studentDao.sexpelPrint();
			if(student.size() != 0) {
				txtPool.setText("�й�\t�̸�\t�а���\t����\n");
				txtPool.append("����������������������������������������������������\n");
				for(StudentDto s : student) {
					String temp = s.getSno()+"\t "+s.getSname()+"\t "+s.getMnameMno()+"\t "+s.getScore()+"\n";
					txtPool.append(temp);
				}
			} else {
				txtPool.setText("�л��� �����ϴ�.");
			}
			
			
		} else if (e.getSource() == btnExpel) { // ------------------------- ���� ����
			int sno = Integer.parseInt(txtSno.getText().trim());
			int score = Integer.parseInt(txtScore.getText().trim()); 
			String sname = txtSname.getText().trim();
			StudentDto modifySEXPEL = new StudentDto(sname);
			int result = studentDao.modifySEXPEL(modifySEXPEL);
			txtPool.setText(result==StudentDao.SUCCESS? sname+" �л� ���� ����" : "�л� ���� ����");
			// ORA-01756: quoted string not properly terminated ���� �ȵ�.
						
			
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		} // if 
		
	} // action
	
	
	// ������ ���� ���� Ŭ���� ���
	public static void main(String[] args) {
		new StudentMng("�л����");
		

	}
	

}
