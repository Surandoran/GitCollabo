package com.cosview.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.cosview.controller.FrontController;
import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;



public class EmployeeView extends JFrame implements ActionListener{
	FrontController controller = new FrontController();
	ProductDAO dao = new ProductDAO();
	ProductDTO dto;
	ReviewView rv;
	boolean r;

	JButton selectbtn, insertbtn, updatebtn, deletebtn, reviewbtn,enter, Update, Delete;
	JScrollPane scroll;
	JTextField name, brand, price, volume, code;
	JPanel p1, pan;
	JLabel L1,L2,L3,L4,L5;
	JFrame input;
	public void EmployeeView() {
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
	    MemberView.area = new JTextArea();
	    scroll = new JScrollPane(MemberView.area);
	    
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
	    insertbtn.addActionListener(this);
	    updatebtn.addActionListener(this);
	    deletebtn.addActionListener(this);
		reviewbtn.addActionListener(this);
	    
	    add(p1);
	    setVisible(true);

	}
	void Insert() {
        input = new JFrame("상품 삽입!");

        pan = new JPanel();
        pan.setLayout(null);
		L1 = new JLabel("상품명");
		L2 = new JLabel("브랜드명");
		L3 = new JLabel("가격");
		L4 = new JLabel("용량");
		L5 = new JLabel("코드명");


        enter = new JButton("추가!");
        name = new JTextField();
        brand = new JTextField();
        price = new JTextField();
        volume = new JTextField();
        code = new JTextField();

        enter.setBounds(370, 350, 80, 50);
        name.setBounds(80, 70, 250, 50);
		L1.setBounds(20,70,250,50);
        brand.setBounds(80, 140, 250, 50);
		L2.setBounds(20,140,250,50);
        price.setBounds(80, 210, 250, 50);
		L3.setBounds(20,210,250,50);
        volume.setBounds(80, 280, 250, 50);
		L4.setBounds(20,280,250,50);
        code.setBounds(80, 350, 250, 50);
		L5.setBounds(20,350,250,50);

        pan.add(name);
        pan.add(enter);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);
		pan.add(L1);
		pan.add(L2);
		pan.add(L3);
		pan.add(L4);
		pan.add(L5);

        enter.addActionListener(this);
        
        input.add(pan);

        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }
	void Update() {
        input = new JFrame("상품 수정!");

        pan = new JPanel();
        pan.setLayout(null);

		L1 = new JLabel("상품수정");
		L2 = new JLabel("브랜드수정");
		L3 = new JLabel("가격수정");
		L4 = new JLabel("용량수정");
		L5 = new JLabel("해당하는코드");

        Update = new JButton("확인");
        name = new JTextField();
        brand = new JTextField();
        price = new JTextField();
        volume = new JTextField();
        code = new JTextField();

		Update.setBounds(370, 350, 80, 50);
		name.setBounds(80, 70, 250, 50);
		L1.setBounds(0,70,250,50);
		brand.setBounds(80, 140, 250, 50);
		L2.setBounds(0,140,250,50);
		price.setBounds(80, 210, 250, 50);
		L3.setBounds(0,210,250,50);
		volume.setBounds(80, 280, 250, 50);
		L4.setBounds(0,280,250,50);
		code.setBounds(80, 350, 250, 50);
		L5.setBounds(0,350,250,50);

        pan.add(name);
        pan.add(Update);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);
		pan.add(L1);
		pan.add(L2);
		pan.add(L3);
		pan.add(L4);
		pan.add(L5);

        Update.addActionListener(this);

        input.add(pan);

        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }
	void Delete() {
        input = new JFrame("상품 삭제!");

        pan = new JPanel();
        pan.setLayout(null);
		L1 = new JLabel("삭제하려는 code값을 정확히 입력해주세요");

        Delete = new JButton("삭제!");
        code = new JTextField();

        Delete.setBounds(300, 25, 100, 50);
		L1.setBounds(30,20,300,30);
        code.setBounds(30, 50, 50, 30);

        pan.add(Delete);
        pan.add(code);
		pan.add(L1);

        Delete.addActionListener(this);

        input.add(pan);

        input.setBounds(100, 100, 400, 140);
        input.setVisible(true);

    }


	@Override
	public void actionPerformed(ActionEvent e) {
//
		//상품조회
		if (e.getSource() == selectbtn) {
			MemberView.area.setText("");
			dao.Select(dto);
		}
		//상품삽입
		if(e.getSource() == insertbtn) {
			this.Insert();
		}
		if(e.getSource() == enter) {
			dto = new ProductDTO(name.getText(),brand.getText(),price.getText(),volume.getText(),code.getText());

			r = controller.SubControllerEX("COSMETIC", 2, dto);
			if(r){
				input.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "상품삽입실패!");
			}
		}
		// 상품수정
		if (e.getSource() == updatebtn) {
			this.Update();
		}
		if(e.getSource() == Update) {
			dto = new ProductDTO(name.getText(),brand.getText(),price.getText(),volume.getText(),code.getText());

			r = controller.SubControllerEX("COSMETIC", 3, dto);
			if(r){
				input.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "수정실패!");
			}
		}
		// 상품삭제
		if(e.getSource() == deletebtn) {
			this.Delete();
		}
		if(e.getSource()== Delete) {
			dto = new ProductDTO(code.getText());

			r = controller.SubControllerEX("COSMETIC", 4, dto);
			if(r){
				System.out.println("삭제 성공!");
				input.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "삭제실패!");
			}
		}
		if(e.getSource() == reviewbtn){
			new ReviewView();
		}
		
		
	}
}
