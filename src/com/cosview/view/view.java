package com.cosview.view;

import com.cosview.controller.*;
import com.cosview.domain.ProductDAO;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.DTO;
import com.cosview.dto.ProductDTO;

import java.awt.print.Book;
import java.util.Scanner;

public class view {
    int num; //메뉴번호
    Scanner sc = new Scanner(System.in);

    //controller 객체추가
    FrontController controller = new FrontController();
    ProductDAO a;
    ProductDTO dto;
    //메인메뉴
    public void LoginMenu(){
        while (true){
            System.out.println("----------Login-----------");
            System.out.println("1. 회원로그인");
            System.out.println("2. 직원로그인");
            System.out.println("3. 종료");
            System.out.println("----------Login-----------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num){
                case 1:
                	System.out.print("ID/PW입력");
                	String tmpid = sc.next();
                	String tmppw = sc.next();
                	AuthDTO dto = new  AuthDTO(tmpid, tmppw);
                	boolean r1 = controller.SubControllerEX("AUTH", 1, dto);
                	if(r1) {
                		System.out.println("로그인 성공");
                		product();
                	}else {
                		System.out.println("인증 실패");
                	}
                	break;
                case 2:
                	System.out.print("ID/PW입력");
                	String tmpid2 = sc.next();
                	String tmppw2 = sc.next();
                	AuthDTO dto2 = new  AuthDTO(tmpid2, tmppw2);
                	boolean r2 = controller.SubControllerEX("AUTH", 1, dto2);
                	if(r2) {
                		System.out.println("로그인 성공");
                	}else {
                		System.out.println("인증 실패");
                	}
                	break;
                case 3:
                	System.out.println("프로그램 종료");
                	System.exit(-1);
                	break;
            
            }//switch 끝
        }//while 끝
    }
    public void product(){
        while (true){
            System.out.println("-------------PRODUCT------------");
            System.out.println("1 조회");
            System.out.println("2 삽입");
            System.out.println("3 수정");
            System.out.println("4 삭제");
            System.out.println("5 Prev");
            System.out.println("-------------PRODUCT------------");
            System.out.print("번호 : " );
            num=sc.nextInt();
            switch (num){
                case 1: //상품조회
                    System.out.println("상품조회요첨!");
                    a.Select(dto);
                    break;
                case 2: //상품추가
                    System.out.println("상품명|브랜드명|가격|용량");
                    System.out.print("상품명 입력 >>>>");
                    String name = sc.next();
                    System.out.print("브랜드 입력 >>>>");
                    String brand = sc.next();
                    System.out.print("가격 입력 >>>>");
                    int price = sc.nextInt();
                    System.out.print("용량 입력 >>>>");
                    String volume = sc.next();
//                    ProductDTO dto = new ProductDTO(name, brand, price, volume);
                    boolean result = controller.SubControllerEX("COSMETIC", 2, dto);
                    if(result) { 
                    	System.out.println("성공");
                    }else {
                    	System.out.println("실패");
                    }
                    break;
                case 3: //상품수정
                    System.out.println("상품수정요청!");
                case 4: //
            }
        }
    }
}

