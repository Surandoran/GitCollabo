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
	JButton selectbtn, insertbtn, updatebtn, deletebtn, reviewbtn,enter, Update, Delete;
	JScrollPane scroll;
	JTextField name, brand, price, volume, code;
	JPanel p1, pan;
	JLabel L1;
	JFrame input;
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
	    
	    add(p1);
	    setVisible(true);

	}
	void Insert() {
        input = new JFrame("상품 삽입!");

        JPanel pan = new JPanel();
        pan.setLayout(null);

        enter = new JButton("추가!");
        name = new JTextField("상품명");
        brand = new JTextField("브랜드명");
        price = new JTextField("가격");
        volume = new JTextField("용량");
        code = new JTextField("코드");

        enter.setBounds(300, 70, 150, 350);
        name.setBounds(30, 70, 250, 50);
        brand.setBounds(30, 140, 250, 50);
        price.setBounds(30, 210, 250, 50);
        volume.setBounds(30, 280, 250, 50);
        code.setBounds(30, 350, 250, 50);

        pan.add(name);
        pan.add(enter);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);

        enter.addActionListener(this);
        
        input.add(pan);

        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }
	void Update() {
        input = new JFrame("상품 수정!");

        pan = new JPanel();
        pan.setLayout(null);

        Update = new JButton("수정!");
        name = new JTextField("상품수정명");
        brand = new JTextField("브랜드수정명");
        price = new JTextField("가격수정");
        volume = new JTextField("용량수정");
        code = new JTextField("변경하려는 코드명을 정확히입력해주세요");

        Update.setBounds(300, 70, 150, 350);
        name.setBounds(30, 70, 250, 50);
        brand.setBounds(30, 140, 250, 50);
        price.setBounds(30, 210, 250, 50);
        volume.setBounds(30, 280, 250, 50);
        code.setBounds(30, 350, 250, 50);

        pan.add(name);
        pan.add(Update);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);

        Update.addActionListener(this);

        input.add(pan);

        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }
	void Delete() {
        input = new JFrame("상품 삭제!");

        pan = new JPanel();
        pan.setLayout(null);

        Delete = new JButton("삭제!");
        code = new JTextField("삭제하려는 code명을 정확히입력해주세요");

        Delete.setBounds(300, 70, 150, 350);
        code.setBounds(30, 350, 250, 50);

        pan.add(Delete);
        pan.add(code);

        Delete.addActionListener(this);

        input.add(pan);

        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectbtn) {
			MemberView.area.setText("");
			ProductDAO dao = new ProductDAO();
			dao.Select(dto);
		}
		if(e.getSource() == insertbtn) {
			this.Insert();
		}
		if(e.getSource() == enter) {
			dto = new ProductDTO(name.getText(), brand.getText(), price.getText(), volume.getText(), code.getText());
			ProductDAO dao = new ProductDAO();
			dao.Insert(dto);
			input.setVisible(false);
		}
		if (e.getSource() == updatebtn) {
			this.Update();
		}
		if(e.getSource() == Update) {
			dto = new ProductDTO(name.getText(), brand.getText(), price.getText(), volume.getText(), code.getText());
			ProductDAO dao = new ProductDAO();
			dao.Update(dto);
			input.setVisible(false);
		}
		if(e.getSource() == deletebtn) {
			this.Delete();
		}
		if(e.getSource()== Delete) {
			dto = new ProductDTO(code.getText());
			ProductDAO dao = new ProductDAO();
			dao.Delete(dto);
			input.setVisible(false);
		}
		
		
	}
}
