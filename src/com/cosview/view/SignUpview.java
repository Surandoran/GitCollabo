package com.cosview.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cosview.main.Main;

public class SignUpview extends JFrame implements ActionListener{
	JLabel name, nickName, ID, PW, email;
	JPanel p1;
	JTextField nametxt, nicktxt, IDtxt, PWtxt, emailtxt;
	JButton SignUpBtn, back;
	
	public SignUpview() {
		setTitle("cosview");
		this.setBounds(300,300,400,700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		p1 = new JPanel();
		p1.setLayout(null);
		name = new JLabel("이름 : ");
		nickName = new JLabel("닉네임 : ");
		ID = new JLabel("ID : ");
		PW = new JLabel("PW : ");
		email = new JLabel("이메일 : ");
		
		nametxt = new JTextField();
		nicktxt = new JTextField();
		IDtxt = new JTextField();
		PWtxt = new JTextField();
		emailtxt = new JTextField();
		
		SignUpBtn = new JButton("Sing Up");
		back = new JButton("Back");
		
		name.setBounds(30,20,100,30);
		nickName.setBounds(30,60,100,30);
		ID.setBounds(30,100,100,30);
		PW.setBounds(30,140,100,30);
		email.setBounds(30,180,100,30);
		
		nametxt.setBounds(100,20,200,30);
		nicktxt.setBounds(100,60,200,30);
		IDtxt.setBounds(100,100,200,30);
		PWtxt.setBounds(100,140,200,30);
		emailtxt.setBounds(100,180,200,30);
		
		SignUpBtn.setBounds(70, 240, 100, 30);
		back.setBounds(200, 240, 100, 30);
		
		p1.add(SignUpBtn);
		p1.add(back);
		
		p1.add(nametxt);
		p1.add(nicktxt);
		p1.add(IDtxt);
		p1.add(PWtxt);
		p1.add(emailtxt);

		p1.add(name);
		p1.add(nickName);
		p1.add(ID);
		p1.add(PW);
		p1.add(email);
		
		
		SignUpBtn.addActionListener(this);
		
		add(p1);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == SignUpBtn) {
			this.setVisible(false);
			
		}
		
	}
}
