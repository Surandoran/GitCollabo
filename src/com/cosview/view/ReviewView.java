package com.cosview.view;

import com.cosview.controller.FrontController;
import com.cosview.domain.*;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.MemberDTO;
import com.cosview.dto.ReviewDTO;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReviewView extends JFrame implements ActionListener {
    //취소버튼,확인버튼
    //제목 텍스트,내용 텍스트
    //별점 버튼
    boolean r;
    FrontController controller = new FrontController();

    EmployeeView EV; //뒤로가기를 눌렀을때 나오는 뷰
    JTextField name, id, nickname, pname, contents, score, time;    //제목,회원아이디,닉네임,상품이름,리뷰내용,점수
    JTextField search;
    JFrame input;
    JPanel pan;
    JFrame f;
    Font font;
    JLabel L1, L2, L3, L4, L5;
    JComboBox jc;
    public static JTextArea area, area2;
    JScrollPane scroll, scroll2;
    JButton insert, update, select, delete;    //리뷰쓰기버튼
    ReviewDAO rdao = new ReviewDAO();
    ReviewDTO rdto;
    DAO dao;
    MemberDAO mdao = new MemberDAO();
    MemberDTO mdto;


    // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
    LocalDate now1 = LocalDate.now(); //2021-06-17
    //    LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));// 2021-06-16
    //현재시간
    LocalTime now2 = LocalTime.now();// 06:20:57.008731300
    //포맷 정의하기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    //현재시간
    String formatedNow = now2.format(formatter);

    String timenow = formatedNow;


    String[] Function = {"기능을선택하세요", "select", "insert", "update", "delete"};


    public ReviewView() {
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        jc = new JComboBox(Function);

        this.add(jc);
        jc.addActionListener(this);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void Rselect() {
        f = new JFrame("리뷰조회창");
        pan = new JPanel();
        pan.setLayout(null);

        L1 = new JLabel("회원이름");
        L2 = new JLabel("제목");
        L3 = new JLabel("리뷰내용");
        search = new JTextField(); //회원닉네임적는곳
        area = new JTextArea();    //제목받는곳
        area2 = new JTextArea(); //리뷰받는곳
        scroll = new JScrollPane(area);
        scroll2 = new JScrollPane(area2);
        select = new JButton("리뷰검색");

        L1.setBounds(10, 10, 100, 30);
        L2.setBounds(10, 75, 100, 50);
        L3.setBounds(10, 150, 100, 50);
        search.setBounds(70, 10, 300, 30);
        select.setBounds(370, 10, 100, 30);
        scroll.setBounds(70, 50, 400, 100);
        scroll2.setBounds(10, 200, 460, 250);


        pan.add(L1);
        pan.add(L2);
        pan.add(L3);
        pan.add(select);
        pan.add(search);
        pan.add(scroll);
        pan.add(scroll2);
        f.add(pan);

        select.addActionListener(this);

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void Rinsert() {
        f = new JFrame("리뷰쓰기");
        pan = new JPanel();
        pan.setLayout(null);

        L1 = new JLabel("제목");
        L2 = new JLabel("닉네임");
        L3 = new JLabel("상품이름");
        L5 = new JLabel("점수");
        L4 = new JLabel("리뷰내용");
        name = new JTextField(); // 제목
        nickname = new JTextField(); //닉네임
        pname = new JTextField(); // 상품이름
        score = new JTextField(); // 점수
        contents = new JTextField(); // 리뷰내용
        insert = new JButton("입력");

        L1.setBounds(10, 10, 100, 30);
        L2.setBounds(10, 50, 100, 30);
        L3.setBounds(300, 10, 100, 30);
        L4.setBounds(10, 150, 100, 30);
        L5.setBounds(10, 90, 100, 30);
        name.setBounds(70, 10, 100, 30);
        nickname.setBounds(70, 50, 100, 30);
        score.setBounds(70, 90, 100, 30);
        insert.setBounds(370, 50, 100, 30);
        pname.setBounds(370, 10, 100, 30);
        contents.setBounds(10, 200, 460, 250);


        pan.add(L1);
        pan.add(L2);
        pan.add(L3);
        pan.add(L4);
        pan.add(L5);
        pan.add(insert);
        pan.add(score);
        pan.add(name);
        pan.add(pname);
        pan.add(nickname);
        pan.add(contents);
        f.add(pan);

        insert.addActionListener(this);

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void Rupdate() {
        f = new JFrame("리뷰수정창");
        pan = new JPanel();
        pan.setLayout(null);

        L1 = new JLabel("제목");
        L2 = new JLabel("리뷰내용");
        name = new JTextField(); //회원닉네임적는곳
        contents = new JTextField(); //리뷰내용
        update = new JButton("수정");
        time = new JTextField(timenow);

        L1.setBounds(10, 10, 100, 30);
        L2.setBounds(10, 150, 100, 50);
        name.setBounds(70, 10, 300, 30);
        update.setBounds(370, 10, 100, 30);
        contents.setBounds(10, 100, 460, 250);

        pan.add(L1);
        pan.add(L2);
        pan.add(update);
        pan.add(name);
        pan.add(contents);
        f.add(pan);

        update.addActionListener(this);

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void Rdelete() {

    }

    public void Ravg() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jc) {
            switch (jc.getSelectedIndex()) {
                case 1:
                    Rselect();
                    break;
                case 2:
                    Rinsert();
                    break;
                case 3:
                    Rupdate();
                    break;
                case 4:
                    Rdelete();
                case 5:
                    Ravg();
                    break;
                default:
            }//스위치문끝
        }//if문 끝

        if (e.getSource() == select) {
            MemberDTO mdto = new MemberDTO(search.getText());
            area.setText("");
            r = controller.SubControllerEX("MEMBER", 1, mdto);
            if (r) {
                rdao.RSelect(rdto);
            }
//			if(controller.SubControllerEX("MEMBER",1, mdto)){
//				rdao.RSelect(rdto);
//				System.out.println("제발되라");
//			}else{
//				JOptionPane.showMessageDialog(null,"회원닉네임이다릅니다");
//			}
        }
        //DB 외래키 적용후 다시 코드짜야함
        if (e.getSource() == insert) {
            if (rdao.RSelect(rdto)) {
            } else {
                rdto = new ReviewDTO(name.getText(), nickname.getText(), pname.getText(),
                        contents.getText(), score.getText());
            }
            r = controller.SubControllerEX("review", 2, rdto);

            if (r) {
                JOptionPane.showMessageDialog(null, "성공");
            } else {
                JOptionPane.showMessageDialog(null, "실패");
            }
        }
    }

    public static void main(String[] args) {
        ReviewView r = new ReviewView();
    }

}
