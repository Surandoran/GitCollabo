package com.cosview.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cosview.controller.FrontController;
import com.cosview.domain.ProductDAO;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.ProductDTO;
import com.cosview.view.EmployeeView;
import com.cosview.view.MemberView;
import com.cosview.view.SignUpview;
import com.cosview.view.view;

public class Main extends JFrame implements ActionListener, KeyListener,MouseListener{
   JPanel p1;
   JButton btn1, btn2;
   JTextField txt1, txt2;
   JLabel L1, L2, L3;
   JRadioButton employee;
   JRadioButton member;
   JLabel emp;
   JLabel mem;
   ButtonGroup radiogroup;
   FrontController controller = new FrontController();
   ImageIcon icon;
   public Main() {
      setTitle("cosview");
      this.setBounds(100,100,600,400);
      this.setResizable(false);
      Font font = new Font("Serif", Font.BOLD, 20);
      Font font1 = new Font("Serif", Font.ITALIC, 17);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      icon = new ImageIcon("../image/cos.png");
      
      p1 = new JPanel();
      p1.setBackground(Color.black);
      p1.setLayout(null);
      txt1 = new JTextField("아이디를 입력하세요");
      txt2 = new JTextField();
      btn1 = new JButton("Login");
      btn1.setFont(font);
      btn1.setBackground(Color.gray);
      btn2 = new JButton("SignUp");
      btn2.setFont(font);
      btn2.setBackground(Color.gray);
      L1 = new JLabel("ID");
      L1.setFont(font);
      L2 = new JLabel("PW");
      L2.setFont(font);
      L3 = new JLabel("사진");
      emp = new JLabel("Manager");
      emp.setFont(font1);
      mem = new JLabel("Member");
      mem.setFont(font1);
      L1.setForeground(Color.white);
      L2.setForeground(Color.white);
      L3.setForeground(Color.white);
      emp.setForeground(Color.white);
      mem.setForeground(Color.white);
      employee = new JRadioButton("Manager");
      member = new JRadioButton("Member");
      member.setContentAreaFilled(false);
      employee.setContentAreaFilled(false);
      
      //직원 또는 회원 둘중 하나를 누를수있도록 그룹화
      radiogroup= new ButtonGroup();
      radiogroup.add(employee);
      radiogroup.add(member);
      L3.setIcon(icon);
      
      //위치크기 설정
      L1.setBounds(110,35,90,30);
      L2.setBounds(110,105,90,30);
      L3.setBounds(90, 220, 400, 70);
      txt1.setBounds(110, 60, 220,40);
      txt2.setBounds(110, 130, 220,40);
      btn1.setBounds(350, 60, 120,40);
      btn2.setBounds(350, 130, 120,40);
      employee.setBounds(190,15,20,20);
      emp.setBounds(210,15,80,20);
      member.setBounds(300,15,20,20);
      mem.setBounds(320,15,80,20);     
      
      //추가
      p1.add(L3);
      p1.add(txt1);
      p1.add(txt2);
      p1.add(btn1);
      p1.add(btn2);
      p1.add(L1);
      p1.add(L2);
      p1.add(emp);
      p1.add(mem);
      p1.add(employee);
      p1.add(member);
      
      
      this.add(p1);
      
      employee.setSelected(true);
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      txt1.addMouseListener(this);
      
      setVisible(true);
   }
   

   public static void main(String[] args) {      
//      ProductDTO dto = new ProductDTO("크리밍", "닥터지", 12000, "50ml");
//      ProductDAO dao = new ProductDAO();
//      dao.Insert(dto);
//      view v = new view();
//      v.product();
//      v.LoginMenu();

      new Main();  
     
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      if(member.isSelected()&&e.getSource()==btn1){
         AuthDTO dto = new  AuthDTO(txt1.getText(), txt2.getText());
           boolean r1 = controller.SubControllerEX("AUTH", 1, dto);
           if(r1) {
              System.out.println("로그인 성공");
              new MemberView();
              JOptionPane.showMessageDialog(null, "환영합니다.");
           }else {
              System.out.println("로그인 실패");
              JOptionPane.showMessageDialog(null, "ID PW 다릅니다.");
           }
      }else if(employee.isSelected()&&e.getSource()==btn1) {
         AuthDTO dto = new  AuthDTO(txt1.getText(), txt2.getText());
           boolean r1 = controller.SubControllerEX("AUTH", 2, dto);
           if(r1) {
        	  EmployeeView s = new EmployeeView();
        	  
              System.out.println("로그인 성공");
              JOptionPane.showMessageDialog(null, "접속완료.");
           }else {
              System.out.println("로그인 실패");
              JOptionPane.showMessageDialog(null, "ID PW 다릅니다.");
           }
      }
      if(e.getSource() == btn2) {
         new SignUpview();
      }
      
   }


private void Employee() {
	// TODO Auto-generated method stub
	
}


@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyPressed(KeyEvent e) {
	
	
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseClicked(MouseEvent e) {
	if(e.getSource() == txt1) {
	  	  System.out.println("aa");
	  	  txt1.setText("");
	    }
	
}


@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}