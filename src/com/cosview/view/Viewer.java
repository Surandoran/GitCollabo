package com.cosview.view;

import java.util.Scanner;

import com.cosview.controller.FrontController;
import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class Viewer {
	
	int num; 
	Scanner sc = new Scanner(System.in);
	
	FrontController controller = new FrontController();
	ProductDAO dao = new ProductDAO();
	ProductDTO dto;
	
	public void LoginMenu() {
		while(true)
		{
			System.out.println("------------LOGIN------------");
			System.out.println("1.관리자로그인");
			System.out.println("2.회원로그인");
			System.out.println("3.종료");
			System.out.println("------------LOGIN------------");
			System.out.println("번호 : ");
			num=sc.nextInt();
			switch(num)
			{
				case 1: //관리자로그인
					ProductMenu();
					break;
				case 2: //회원로그인
					break;
				case 3: //종료
					System.out.println("프로그램을 종료합니다");
					System.exit(-1);
					break;
				default:
					System.out.println("잘못입력하셨습니다..");
			}//switch 끝
		}//while끝
	}
	
	//상품메뉴
	public void ProductMenu() {
		while(true)
		{
			//1조회 2삽입 3수정 4삭제
			System.out.println("------------PRODUCT------------");
			System.out.println("1 Select");
			System.out.println("2 Insert");
			System.out.println("3 Update");
			System.out.println("4 Delete");
			System.out.println("5 Prev");
			System.out.println("------------PRODUCT------------");
			System.out.println("번호 : ");
			num=sc.nextInt();
			switch(num)
			{
			case 1: //조회
				System.out.println("상품조회");
				dao.Select(dto);
				break;
			case 2: //삽입
				System.out.println("상품명 :");
				String name = sc.next();
				System.out.println("브랜드명 :");
				String brand = sc.next();
				System.out.println("가격 :");
				String price = sc.next();
				System.out.println("용량 :");
				String volume = sc.next();
				ProductDTO dto = new ProductDTO(name, brand, price, volume);
				boolean result = controller.SubControllerEX("Product", 2, dto);
				
				if(result)
					System.out.println("INSERT성공");
				else
					System.out.println("INSERT실패");
				break;
			case 3: //수정
				System.out.println("상품수정");
				break;
			case 4: //삭제
				System.out.println("상품삭제");
			case 5: //이전으로
				return; //MainMenu로 리턴
			default:
				System.out.println("번호 다시입력하세요~");
			}
		}
	}
	
	
}
