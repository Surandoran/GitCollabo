package com.cosview.view;

import com.cosview.controller.FrontController;
import com.cosview.domain.DAO;
import com.cosview.domain.ProductDAO;
import com.cosview.domain.ReviewDAO;
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

public class ReviewView extends JFrame implements ActionListener {
	//취소버튼,확인버튼
	//제목 텍스트,내용 텍스트
	//별점 버튼
	boolean r;

	FrontController controller = new FrontController();

	JButton writebtn, viewbtn; //확인,뒤로가기 버튼
	EmployeeView EV; //뒤로가기를 눌렀을때 나오는 뷰
	JTextField name,id,nickname,pname,contents,score,time;	//제목,회원아이디,닉네임,상품이름,리뷰내용,점수
	JFrame input;
	JPanel pan;
	Font font;
	JComboBox jc;
	JTextArea area;
	ReviewDAO dao;
	JButton insert;	//리뷰쓰기버튼
	JButton update; //리뷰수정버튼
	JButton select; //리뷰조회버튼
	JButton delete; //리뷰삭제버튼
	ReviewDAO rdao = new ReviewDAO();
	ReviewDTO rdto;


	String[] Function = {"기능을선택하세요","select","insert","update","delete"};


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

	public void Rselect(){
	}
	public void Rinsert(){
	}
	public void Rupdate(){

	}
	public void Rdelete(){

	}

	public void Ravg(){

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jc){
			switch (jc.getSelectedIndex()){
				case 1:
					Rselect();
					if(e.getSource() == select){
						area.setText("");
						dao = new ReviewDAO();
						dao.RSelect(rdto);
					}
					break;
				case 2:
					Rinsert();
					rdto = new ReviewDTO(name.getText(),nickname.getText(),pname.getText(),contents.getText(),dao.time());

					r = controller.SubControllerEX("REVIEW", 2, rdto);
					if(r){

					}else {
						JOptionPane.showMessageDialog(null, "모찌");
					}
					break;
				case 3:
					Rupdate();
					rdto = new ReviewDTO(name.getText(),contents.getText(),time.getText());

					r = controller.SubControllerEX("REVIEW", 3, rdto);
					if(r){

					}else {
						JOptionPane.showMessageDialog(null, "딸기모찌");
					}
					break;
				case 4:
					Rdelete();
					rdto = new ReviewDTO(name.getText());

					r = controller.SubControllerEX("REVIEW", 4, rdto);
					if(r){

					}else {
						JOptionPane.showMessageDialog(null, "모찌모찌");
					}
				case 5:
					Ravg();
					rdto = new ReviewDTO(score.toString());

					r = controller.SubControllerEX("REVIEW", 5, rdto);
					if(r){

					}else {
						JOptionPane.showMessageDialog(null, "크림모찌");
					}
					break;
				default:
			}
		}
	}

	public static void main(String[] args) {
		new ReviewView();
	}

}
