package com.cosview.view;

import com.cosview.domain.DAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReviewView extends JFrame implements ActionListener {
	//취소버튼,확인버튼
	//제목 텍스트,내용 텍스트
	//별점 버튼

	JButton writebtn, viewbtn; //확인,뒤로가기 버튼
	EmployeeView EV; //뒤로가기를 눌렀을때 나오는 뷰
	JTextField write,title; // title 제목 write 리뷰내용
	JFrame f;
	JPanel p;
	JLabel inL,upL,seL,deL;
	Choice c;
	JButton insert;	//리뷰쓰기버튼
	JButton update; //리뷰수정버튼
	JButton select; //리뷰조회버튼
	JButton delete; //리뷰삭제버튼
	DAO dao = new DAO();


	public void ReviewView() {
		f = new JFrame("리뷰메뉴선택");
		p = new JPanel();
		p.setLayout(null);
		c = new Choice();

		c.add("메뉴를선택하세요");
		c.add("리뷰조회");
		c.add("리뷰쓰기");
		c.add("리뷰수정");
		c.add("리뷰삭제");
		c.select(0);

		c.setSize(100, 50);
		c.setLocation(100,70);

		f.add(c);

		f.setBounds(100,100,300,200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Rselect(){
		EV.Update();
	}
	public void Rinsert(){

	}
	public void Rupdate(){

	}
	public void Rdelete(){

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == EV.reviewbtn){
			new ReviewView();
		}
	}
}
