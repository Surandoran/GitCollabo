package com.cosview.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;



public class EmployeeView extends JFrame implements ActionListener{
	JButton selectbtn, insertbtn, updatebtn, deletebtn, reviewbtn;
	public static JTextArea area;
	JScrollPane scroll;
	JPanel p1;
	JLabel L1;
	ProductDTO dto;
	public EmployeeView() {
		setTitle("관리시스템");
		this.setBounds(100,100,600,500);
		Font font = new Font("Serif", Font.BOLD, 18);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    
	    selectbtn = new JButton("상품 조회");
	    selectbtn.setFont(font);
	    insertbtn = new JButton("상품 추가");
	    insertbtn.setFont(font);
	    updatebtn = new JButton("상품 수정");
	    updatebtn.setFont(font);
	    deletebtn = new JButton("상품 삭제");
	    deletebtn.setFont(font);
	    reviewbtn = new JButton("리뷰 관리 GOGO");
	    reviewbtn.setFont(font);
	    area = new JTextArea();
	    scroll = new JScrollPane(area);
	    
	    p1 = new JPanel();
	    p1.setLayout(null);
	    L1 = new JLabel("관리자 목록");
	    L1.setFont(font);
	    
	    
	    
	    
	    L1.setBounds(240, 20, 120,30);
	    scroll.setBounds(170, 80, 400, 300);
	    selectbtn.setBounds(30, 80, 120, 40);
	    insertbtn.setBounds(30, 150, 120, 40);
	    updatebtn.setBounds(30, 220, 120, 40);
	    deletebtn.setBounds(30, 290, 120, 40);
	    reviewbtn.setBounds(190, 400, 180, 40);

	    
	    p1.add(scroll);
	    p1.add(selectbtn);
	    p1.add(insertbtn);
	    p1.add(updatebtn);
	    p1.add(deletebtn);
	    p1.add(reviewbtn);
	    p1.add(L1);
	    
	    selectbtn.addActionListener(this);
	    
	    add(p1);
	    setVisible(true);
	}
	public static void main(String[] args) {
		new EmployeeView();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectbtn) {
			ProductDAO dao = new ProductDAO();
			dao.Select(dto);
		}
		
	}
}
