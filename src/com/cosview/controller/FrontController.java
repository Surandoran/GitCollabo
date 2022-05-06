package com.cosview.controller;

import java.util.HashMap;
import java.util.Map;

import com.cosview.dto.DTO;

public class FrontController {

	//서브컨트롤러 저장용
	private Map<String, SubController> map = new HashMap();
	
	public FrontController() {
		Init();
	}
	
	//등록할 서비스 지정
	private void Init() {
		map.put("Product", new ProductController());
	}
	//MAP에 있는 서브컨트롤러를 꺼내어 해당 컨트롤러를 실행하는 함수
	public boolean SubControllerEX(String menu, int num, DTO dto) {
		SubController tmp;
		if(menu.equals("Product")) {
			tmp = map.get("Product");
			return tmp.execute(menu,num, dto);
		}
		return false;
	}

	
	
}
