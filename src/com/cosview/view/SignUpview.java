package com.cosview.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.cosview.controller.FrontController;
import com.cosview.domain.MemberDAO;
import com.cosview.dto.DTO;
import com.cosview.dto.MemberDTO;
import com.cosview.main.Main;

// https://d-life93.tistory.com/206 
// 회원가입 스윙할려고하는데 인식이안되..위치를 모르겠어...
public class SignUpview extends JFrame implements ActionListener {
//		MemberDAO dao;
//		MemberDTO mdto;
//	   Font fnt = new Font("굴림체",Font.BOLD,14);
//	   Font titleFnt = new Font("굴림체",Font.BOLD,32);
//	   
//	   JLabel titleLbl = new JLabel("회 원 가 입");
//	   JLabel idLbl = new JLabel("아이디");
//	   JTextField idField = new JTextField(30);
//	   
//	   JButton duplicateBtn = new JButton("중복 확인");
//	   JLabel pwdLbl = new JLabel("비밀번호");
//
//	   JPasswordField pwdField = new JPasswordField(30);
//	   JLabel pwdcheckLbl = new JLabel("비밀번호 확인");
//
//	   JPasswordField pwdcheckField = new JPasswordField(30);
//
//	   JLabel nameLbl = new JLabel("이름");
//	   JTextField nameField = new JTextField(30);
//
//	   JLabel NickNameLbl = new JLabel("이름(한글)");
//	   JTextField NickNameField = new JTextField(30);
//
//	   JLabel telLbl = new JLabel("연락처");
//	   JTextField telField = new JTextField(30);
//
//	   JLabel emailLbl = new JLabel("이메일");
//	   JTextField emailField = new JTextField(30);
//
//	   JLabel genderLbl = new JLabel("성별");
//	   String gender[] = {"F","M"};
//	   DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(gender);
//	   JComboBox<String> genderCombo = new JComboBox<String>(model);
//	   JButton signUpBtn = new JButton("회원가입");
//	   JButton cancelBtn = new JButton("취소");
//
//	   public SignUpview() {
//		      
//		      setLayout(null);
//		      int x=300;
//		      int x1=410;
//		      
//		      add(titleLbl).setBounds(450,100,200,30);
//		      titleLbl.setFont(titleFnt);
//		      
//		      add(idLbl).setBounds(x,200,100,30);
//		      add(idField).setBounds(x1,200,250,30);
//		      add(duplicateBtn).setBounds(670,200,110,30);
//		      idLbl.setFont(fnt);
//		      idField.setFont(fnt);
//		      duplicateBtn.setFont(fnt);
//		      duplicateBtn.setBackground(new Color(0,130,255));
//		      duplicateBtn.setForeground(Color.white);
//		      
//		      add(pwdLbl).setBounds(x,250,100,30); add(pwdField).setBounds(x1,250,250,30); 
//		      pwdLbl.setFont(fnt);
//		      pwdField.setFont(fnt);
//		      
//		      add(pwdcheckLbl).setBounds(x,300,100,30); 
//		      add(pwdcheckField).setBounds(x1, 300, 250, 30); 
//		      pwdcheckLbl.setFont(fnt);
//		      pwdcheckField.setFont(fnt);
//		      
//		      add(nameLbl).setBounds(x,350,100,30); 
//		      add(nameField).setBounds(x1,350,250,30);
//		      nameLbl.setFont(fnt);
//		      nameField.setFont(fnt);
//		      
//		      add(NickNameLbl).setBounds(x,400,100,30); 
//		      add(NickNameField).setBounds(x1,400,250,30);
//		      NickNameLbl.setFont(fnt);
//		      NickNameField.setFont(fnt);
//		      
//		      add(telLbl).setBounds(x,450,100,30); 
//		      add(telField).setBounds(x1,450,250,30);
//		      telLbl.setFont(fnt);
//		      telField.setFont(fnt);
//		      
//		      add(emailLbl).setBounds(x,500,100,30);       //이메일
//		      add(emailField).setBounds(x1,500,250,30);    
//		      emailLbl.setFont(fnt);
//		      emailField.setFont(fnt);
//		      
//		      add(genderLbl).setBounds(x,550,100,30);     // 성별버튼크기
//		      add(genderCombo).setBounds(x1,550,250,30);    // 성별 
//		      genderLbl.setFont(fnt);
//		      genderCombo.setFont(fnt);
//		      genderCombo.setBackground(Color.white);
//		      
//		      add(signUpBtn).setBounds(400,630,100,30); // 승인버튼
//		      add(cancelBtn).setBounds(530,630,100,30); // 취소버튼
//		      signUpBtn.setFont(fnt);
//		      signUpBtn.setBackground(new Color(0,130,255));
//		      signUpBtn.setForeground(Color.white);
//		      signUpBtn.setEnabled(false);
//		      cancelBtn.setFont(fnt);
//		      cancelBtn.setBackground(new Color(0,130,255));
//		      cancelBtn.setForeground(Color.white);
//		      
//		   }
//		   public void actionPerformed(ActionEvent ae) {
//		      Object obj = ae.getSource();
//		      if(obj instanceof JButton) {
//		         String btn = ae.getActionCommand();
//		         if(btn.equals("회원가입")) {
//		            String id = idField.getText();
//		            String password = pwdField.getText();
//		            String pwdCheck = pwdcheckField.getText();
//		            if(id.equals("")) {
//		               JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다");
//		            } else if(password.equals("")) {
//		               JOptionPane.showMessageDialog(this, "비밀번호를 입력하셔야 합니다");
//		            } else if(password.length()<6 || password.length()>20) {    
//		               JOptionPane.showMessageDialog(this, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
//		            } else if(pwdCheck.equals("")) {
//		               JOptionPane.showMessageDialog(this, "비교할 비밀번호를 입력해 주시기 바랍니다");
//		            } else if(!password.equals(pwdCheck)) {
//		               JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다");
//		            } else if(checkPWDMethod(password)==1) {
//		               JOptionPane.showMessageDialog(this, "비밀번호 특수문자는 !@#만 포함 가능 합니다");
//		            } else if(nameField.getText().equals("")) {
//		               JOptionPane.showMessageDialog(this, "이름(한글)을 입력하셔야 합니다");
//		            } else if(NickNameField.getText().equals("")) {
//		               JOptionPane.showMessageDialog(this, "이름(영문)을 입력하셔야 합니다");
//		            } else if(telField.getText().equals("")) {
//		               JOptionPane.showMessageDialog(this, "연락처를 입력하셔야 합니다");
//		            } else if(emailField.getText().equals("")){
//		               JOptionPane.showMessageDialog(this, "이메일을 입력하셔야 합니다");
//		                           
//		            } else {
//		               MemberDTO dto = new MemberDTO(idField.getText(),pwdField.getText(),
//		                     nameField.getText(),NickNameField.getText().toUpperCase(),
//		                     telField.getText(),emailField.getText(), (String)genderCombo.getSelectedItem());
//		                           
//		               boolean result = dao.MInsert(dto);
//		               if(result) { // 회원등록 성공함
//		                  JOptionPane.showMessageDialog(this, "회원가입에 성공하였습니다\n원활한 이용을 위하여\n로그인 해주시기 바랍니다");
//		               } else { //회원등록 실패함
//		                  JOptionPane.showMessageDialog(this, "회원가입에 실패하였습니다\n 관리자에게 문의해 주시기 바랍니다");
//		               }
//		               dispose();
//		               new Main();
//		            }
//		         } else if(btn.equals("취소")) {
//		            dispose();
//		            new Main();
//		         } else if(btn.equals("중복 확인")) {
//		            String idSearch = idField.getText();
//		            System.out.println(idSearch.length());
//		            if(idSearch.equals("")) {
//		               JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다");
//		               //id 특수문자 포함 확인
//		            } else if(idSearch.length() < 6 || idSearch.length() > 15) {
//		               JOptionPane.showMessageDialog(this, "아이디는 6자리 이상, 15자리 이하만 가능 합니다.");
//		            } else if(checkIDMethod(idSearch)==1){
//		               JOptionPane.showMessageDialog(this, "아이디는 특수문자 포함이 불가능합니다");
//		            } else {
//		               List<MemberDTO> result = DTO.MemberInsert(idSearch);
//		               if(result.size()==0) {
//		                  JOptionPane.showMessageDialog(this, "사용 가능한 아이디 입니다");
//		                  signUpBtn.setEnabled(true);
//		                  idField.setEnabled(false);
//		               } else {
//		                  JOptionPane.showMessageDialog(this, "등록되어 있는 아이디 입니다");
//		               }
//		                  
//		            } 
//		         }
//		      }
//		   }
//		   
//		   public int checkIDMethod(String id) {
//		      int check= 0;
//		      char alpha;
//		      int code;
//		      for(int i=0; i<id.length(); i++) {
//		         alpha = id.charAt(i);
//		         code = (int)alpha;
//		         if(code>=0 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 127) {
//		            check = 1;
//		         }
//		      }
//		      return check;
//		   }
//		   
//		   public int checkPWDMethod(String pwd) {
//		      int check= 0;
//		      char alpha;
//		      int code;
//		      for(int i=0; i<pwd.length(); i++) {
//		         alpha = pwd.charAt(i);
//		         code = (int)alpha;
//		         if(code>=0 && code<=32 || code>=36 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 127) {
//		            check = 1;
//		            
//		         }
//		      }
//		      return check;
//		   }
//
//		}
//


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
