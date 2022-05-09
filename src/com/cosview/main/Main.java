package com.cosview.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cosview.controller.FrontController;
import com.cosview.domain.ProductDAO;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.ProductDTO;
import com.cosview.view.MemberView;
import com.cosview.view.SignUpview;
import com.cosview.view.view;

public class Main extends JFrame implements ActionListener{
	JPanel p1;
	JButton btn1, btn2;
	JTextField txt1, txt2;
	JLabel L1, L2;
	FrontController controller = new FrontController();
	public Main() {
		setTitle("cosview");
		this.setBounds(100,100,400,200);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		p1 = new JPanel();
		p1.setLayout(null);
		txt1 = new JTextField();
		txt2 = new JTextField();
		btn1 = new JButton("로그인");
		btn2 = new JButton("회원가입");
		L1 = new JLabel("ID");
		L2 = new JLabel("PW");
		
		//위치크기 설정
		L1.setBounds(40,10,90, 30);
		L2.setBounds(40,65,90, 30);
		txt1.setBounds(40, 35, 200,30);
		txt2.setBounds(40, 90, 200,30);
		btn1.setBounds(250, 35, 90,30);
		btn2.setBounds(250, 90, 90,30);
		
		
		//추가
		p1.add(txt1);
		p1.add(txt2);
		p1.add(btn1);
		p1.add(btn2);
		p1.add(L1);
		p1.add(L2);
		
		
		
		
		this.add(p1);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		setVisible(true);
	}

	public static void main(String[] args) {		
//		ProductDTO dto = new ProductDTO("크리밍", "닥터지", 12000, "50ml");
//		ProductDAO dao = new ProductDAO();
//		dao.Insert(dto);
//		view v = new view();
//		v.product();
//		v.LoginMenu();

		new Main();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1){
			AuthDTO dto = new  AuthDTO(txt1.getText(), txt2.getText());
        	boolean r1 = controller.SubControllerEX("AUTH", 1, dto);
        	if(r1) {
        		System.out.println("로그인 성공");
        		new MemberView();
        		JOptionPane.showMessageDialog(null, "환영합니다.");
        	}else {
        		System.out.println("인증 실패");
        		JOptionPane.showMessageDialog(null, "ID PW 다릅니다.");
        	}
		}
		if(e.getSource() == btn2) {
			new SignUpview();
		}
	}
}
