package com.cosview.main;

import com.cosview.controller.FrontController;
import com.cosview.dto.ProductDTO;
import com.cosview.view.Viewer;


public class Main {

	public static void main(String[] args) {

//		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
//		ProductDAO dao = new ProductDAO();
//		dao.Insert(dto);

//		FrontController controller = new FrontController();
//		ProductDTO dto = new ProductDTO("2020","이것이자바냐?",1000,"10g");
//		controller.SubControllerEX("product", 2, dto); //서비스명,작업번호,전달단위

		Viewer view1 = new Viewer();
		view1.ProductMenu();
	}
}
