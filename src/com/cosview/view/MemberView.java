package com.cosview.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class MemberView extends JFrame implements ActionListener{
	JButton serchBtn, reviewBtn, allBtn;
	JPanel p1;
	public static JTextArea area;
	JTextField serchTxt;
	JScrollPane scroll;
	
	ProductDTO dto;
	
	public MemberView() {
		setTitle("MemverView");
		this.setBounds(600,300,700,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1 = new JPanel();
		p1.setLayout(null);
		serchBtn = new JButton("상품검색");
		allBtn = new JButton("상품 전체 보기"); 
		reviewBtn = new JButton("리뷰보기");
		serchTxt = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area); 
		
		
		scroll.setBounds(20, 80, 500, 500);
		serchTxt.setBounds(20,40,170,30);
		serchBtn.setBounds(200,40,100,30);
		allBtn.setBounds(330, 40, 120, 30);
		reviewBtn.setBounds(550,40,100,30);

		
		p1.add(scroll);
		p1.add(serchTxt);
		p1.add(serchBtn);
		p1.add(reviewBtn);
		p1.add(allBtn);
		

		allBtn.addActionListener(this);
		
		this.add(p1);
		setVisible(true);
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == allBtn) {
			ProductDAO dao = new ProductDAO();
			dao.Select(dto);
		}
		
	}

}
