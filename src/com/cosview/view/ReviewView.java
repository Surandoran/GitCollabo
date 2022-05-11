package com.cosview.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReviewView extends JFrame{
	JButton writebtn, viewbtn;
	JTextArea reviewArea;
	JScrollPane scroll;
	JPanel p1;
	public ReviewView() {
		setTitle("리뷰");
		this.setBounds(600,300,700,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		reviewArea = new JTextArea();
		scroll = new JScrollPane(reviewArea);
		writebtn = new JButton("리뷰 쓰기");
		viewbtn = new JButton("리뷰 보기");
		
		
		
		
		
		
		
		
		
		setVisible(true);
	}
}
