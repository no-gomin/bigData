package com.lect.ext2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	
	Writer writer = null;
	private Container contenPane;
	private JPanel jpNorth; 
	private JPanel jpSouth;
	private JTextField jtxtName;
	private JTextField jtxtTel;
	private JTextField JtxtAge;
	private JButton jbtnIn;
	private ImageIcon iconIn;
	private JButton jbtnOut;
	private ImageIcon iconOut;
	private ArrayList<Person> people;
	
	public MyFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contenPane = getContentPane();
		jpNorth = new JPanel(new GridLayout(3,2));
		jpSouth = new JPanel(new FlowLayout());
		jtxtName = new JTextField();
		jtxtTel = new JTextField();
		JtxtAge = new JTextField();
		iconIn = new ImageIcon("icon/join.png");
		jbtnIn = new JButton("�Է�", iconIn);
		iconOut = new ImageIcon("icon/output.png");
		jbtnOut = new JButton("���", iconOut);
		people = new ArrayList<Person>();
		
		jpNorth.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpNorth.add(jtxtName);
		jpNorth.add(new JLabel("��ȭ", (int) CENTER_ALIGNMENT));
		jpNorth.add(jtxtTel);
		jpNorth.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpNorth.add(JtxtAge);
		
		jpSouth.add(jbtnIn);
		jpSouth.add(jbtnOut);
		
		
		contenPane.add(jpNorth, BorderLayout.NORTH);
		contenPane.add(jpSouth, BorderLayout.SOUTH);
		
		setVisible(true);
		setBounds(150, 100, 300, 200);		
		
		jbtnIn.addActionListener(this);
		jbtnOut.addActionListener(this);
			
	}	
	public MyFrame(String title) {
		this();
		setTitle(title);		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnIn) {
			String name = jtxtName.getText().trim().toUpperCase();
			String tel = jtxtTel.getText().trim();
			int age = 0;
						
			if(name.isEmpty() || tel.isEmpty()) {
				System.out.println("�̸��� ��ȭ�� �ʼ��Է� �����Դϴ�.");
				return;
			}
			try {
				age = Integer.parseInt(JtxtAge.getText());
				if(age<0 || age>150) {
					System.out.println("�Էµ� ���̰� �߸� �Ǿ����ϴ�. 0��� �ʱ�ȭ�˴ϴ�.");
					age =0;
				}
			} catch (NumberFormatException e2) {
				System.out.println("�Էµ� ���̰� �߸� �Ǿ����ϴ�. 0��� �ʱ�ȭ�˴ϴ�.");
				age =0;				
			}
			
			people.add(new Person(name, tel, age));
			jtxtName.setText("");
			jtxtTel.setText("");
			JtxtAge.setText("");
						
			
		} else if(e.getSource() == jbtnOut) {
			try {
				writer = new FileWriter("txtFile/person.txt");
				for (Person p : people) {
					String tempStr = p.toString();
					System.out.print(tempStr);
					writer.write(tempStr);					
				}
				System.out.println("���� ����");
			} catch (IOException e1) {
				System.out.println("���� ��½� ������ �߻��Ͽ����ϴ�."); 
			} finally {
				try {
					if(writer != null) {
						writer.close();
					}
				} catch (Exception e2) {
				}
			}
		} //if-else if
	} //actionPerformed
} //class
