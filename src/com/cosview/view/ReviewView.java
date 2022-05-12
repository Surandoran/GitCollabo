package com.cosview.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReviewView extends JFrame implements ActionListener {
	JButton writebtn, viewbtn;
	JTextArea reviewArea;
	JScrollPane scroll;
	JPanel p1;
	LocalDate todey;
	LocalTime now;
	EmployeeView EV;
	JButton insert;
	JButton update;
	JButton select;
	JButton delete;

	void todeydate(){
		todey = LocalDate.now();
		now = LocalTime.now();
	}

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

	void Rselect(){

	}
	void Rinsert(){

	}
	void Rupdate(){

	}
	void Rdelete(){

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == EV.reviewbtn){
			new ReviewView();
			//개인리뷰조회or모든리뷰조회
			if(e.getSource() == select){

			}
			//리뷰작성
			if(e.getSource() == insert){
				todeydate();
			}
			//리뷰수정
			if(e.getSource() == update){
				todeydate();
			}
			//리뷰삭제
			if(e.getSource() == viewbtn){
				todeydate();
			}
		}
	}
}
