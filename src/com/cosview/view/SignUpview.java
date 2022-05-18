package com.cosview.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cosview.controller.FrontController;
import com.cosview.domain.AuthDAO;
import com.cosview.domain.MemberDAO;
import com.cosview.dto.MemberDTO;
import com.cosview.main.Main;
import jdk.nashorn.internal.scripts.JO;

public class SignUpview extends JFrame implements ActionListener {

    FrontController controller = new FrontController();

    boolean r;

    MemberDTO mdto;
    MemberDAO dao;


    JLabel name, nickName, ID, PW, email, addr, menL, womanL, gender;
    JPanel p1;
    JTextField nametxt, nicktxt, idtxt, pwtxt, emailtxt, addrtxt, gendertxt;
    JButton SignUpBtn, back;
    JRadioButton men, woman;

    public SignUpview() {
        setTitle("cosview");
        this.setBounds(300, 300, 400, 500);
        this.setResizable(false);


        p1 = new JPanel();
        p1.setLayout(null);
        name = new JLabel("이름 : ");
        nickName = new JLabel("닉네임 : ");
        ID = new JLabel("ID : ");
        PW = new JLabel("PW : ");
        email = new JLabel("이메일 : ");
        addr = new JLabel("주소 : ");
        gender = new JLabel("성별 : ");
//        menL = new JLabel("남");
//        womanL = new JLabel("여");

//        men = new JRadioButton();
//        woman = new JRadioButton();
        ButtonGroup group = new ButtonGroup();

//        group.add(men);
//        group.add(woman);


        nametxt = new JTextField();
        nicktxt = new JTextField();
        idtxt = new JTextField();
        pwtxt = new JTextField();
        emailtxt = new JTextField();
        addrtxt = new JTextField();
        gendertxt = new JTextField();


        SignUpBtn = new JButton("Sing Up");
        back = new JButton("Back");

        name.setBounds(30, 10, 100, 30);
        nickName.setBounds(30, 50, 100, 30);
        ID.setBounds(30, 90, 100, 30);
        PW.setBounds(30, 130, 100, 30);
        email.setBounds(30, 170, 100, 30);
        addr.setBounds(30, 210, 100, 30);
        gender.setBounds(30, 250, 100, 30);

//        men.setBounds(120, 300, 20, 20);
//        woman.setBounds(240, 300, 20, 20);

//        menL.setBounds(110, 300, 20, 20);
//        womanL.setBounds(230, 300, 20, 20);

//        men.setSelected(true);

        nametxt.setBounds(100, 10, 200, 30);
        nicktxt.setBounds(100, 50, 200, 30);
        idtxt.setBounds(100, 90, 200, 30);
        pwtxt.setBounds(100, 130, 200, 30);
        emailtxt.setBounds(100, 170, 200, 30);
        addrtxt.setBounds(100, 210, 200, 30);
        gendertxt.setBounds(100, 250, 200, 30);

        SignUpBtn.setBounds(70, 350, 100, 30);
        back.setBounds(200, 350, 100, 30);


//        p1.add(menL);
//        p1.add(womanL);
        p1.add(SignUpBtn);
        p1.add(back);
//        p1.add(men);
//        p1.add(woman);
        p1.add(gendertxt);
        p1.add(addrtxt);
        p1.add(nametxt);
        p1.add(nicktxt);
        p1.add(idtxt);
        p1.add(pwtxt);
        p1.add(emailtxt);


        p1.add(addr);
        p1.add(name);
        p1.add(nickName);
        p1.add(ID);
        p1.add(PW);
        p1.add(email);
        p1.add(gender);


        SignUpBtn.addActionListener(this);
        back.addActionListener(this);


        add(p1);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == SignUpBtn){

            mdto = new MemberDTO(nicktxt.getText(),idtxt.getText(),pwtxt.getText(),nametxt.getText(),addrtxt.getText(),emailtxt.getText(),gendertxt.getText());

            r = controller.SubControllerEX("MEMBER", 2, mdto);
            if(r){
                p1.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "빈칸을 입력해주세요");
            }
        }
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        if (e.getSource() == SignUpBtn) {
//            if (nametxt.getText() == "") {
//                JOptionPane.showMessageDialog(null, "빈칸을 입력해주세요.");
////            if (men.isSelected()){
////                s = true;
////            }else if (woman.isSelected()) {
////                s = false;
////            }
//                dto = new MemberDTO(IDtxt.getText(), PWtxt.getText(), nametxt.getText(), emailtxt.getText(),
//                        nicktxt.getText(), addrtxt.getText(), gendertxt.getText());
//                dao.MemberInsert(dto);
//                setVisible(false);
//            }
//        }
//
//		if(e.getSource()==back);
//			setVisible(false);
//    }


}
