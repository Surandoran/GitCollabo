package com.cosview.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cosview.domain.AuthDAO;
import com.cosview.dto.MemberDTO;
import com.cosview.main.Main;

public class SignUpview extends JFrame implements ActionListener{
	JLabel name, nickName, ID, PW, email,addr, menL, womanL;
	JPanel p1;
	JTextField nametxt, nicktxt, IDtxt, PWtxt, emailtxt, addrtxt;
	JButton SignUpBtn, back;
	JRadioButton men, woman;
	
	
	public SignUpview() {
		setTitle("cosview");
		this.setBounds(300,300,400,500);
		this.setResizable(false);
		
		
		
		p1 = new JPanel();
		p1.setLayout(null);
		name = new JLabel("이름 : ");
		nickName = new JLabel("닉네임 : ");
		ID = new JLabel("ID : ");
		PW = new JLabel("PW : ");
		email = new JLabel("이메일 : ");
		addr = new JLabel("주소 : ");
		menL = new JLabel("남");
		womanL = new JLabel("여");
		
		men = new JRadioButton();
		woman = new JRadioButton();
		ButtonGroup group = new ButtonGroup();
		
		group.add(men);
		group.add(woman);
		
		
		nametxt = new JTextField();
		nicktxt = new JTextField();
		IDtxt = new JTextField();
		PWtxt = new JTextField();
		emailtxt = new JTextField();
		addrtxt = new JTextField();
		
		
		SignUpBtn = new JButton("Sing Up");
		back = new JButton("Back");
		
		name.setBounds(30,20,100,30);
		nickName.setBounds(30,60,100,30);
		ID.setBounds(30,100,100,30);
		PW.setBounds(30,140,100,30);
		email.setBounds(30,180,100,30);
		addr.setBounds(30,220,100,30);
		
		men.setBounds(120, 300, 20,20);
		woman.setBounds(240,300,20,20);
		
		menL.setBounds(110, 300, 20, 20);
		womanL.setBounds(230, 300, 20, 20);
		
		men.setSelected(true);
		
		nametxt.setBounds(100,20,200,30);
		nicktxt.setBounds(100,60,200,30);
		IDtxt.setBounds(100,100,200,30);
		PWtxt.setBounds(100,140,200,30);
		emailtxt.setBounds(100,180,200,30);
		addrtxt.setBounds(100,220,200,30);
		
		SignUpBtn.setBounds(70, 350, 100, 30);
		back.setBounds(200, 350, 100, 30);
		
		
		p1.add(menL);
		p1.add(womanL);
		p1.add(SignUpBtn);
		p1.add(back);
		p1.add(men);
		p1.add(woman);
		p1.add(addrtxt);
		p1.add(nametxt);
		p1.add(nicktxt);
		p1.add(IDtxt);
		p1.add(PWtxt);
		p1.add(emailtxt);
		
		
		p1.add(addr);
		p1.add(name);
		p1.add(nickName);
		p1.add(ID);
		p1.add(PW);
		p1.add(email);
		
		
		SignUpBtn.addActionListener(this);
		back.addActionListener(this);
		
		
		add(p1);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == SignUpBtn) {
			MemberDTO dto = new MemberDTO(IDtxt.getText(), PWtxt.getText(), nametxt.getText(), emailtxt.getText(), nicktxt.getText(), addrtxt.getText());
			AuthDAO dao = new AuthDAO();
			dao.MemberInsert(dto);
			setVisible(false);
		}
		if(e.getSource() == back) {
			setVisible(false);
		}
		
	}
}
