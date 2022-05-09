package com.cosview.controller;

import java.util.HashMap;
import java.util.Map;

import com.cosview.dto.DTO;
import com.cosview.dto.ProductDTO;





public class FrontController {
	
	private Map<String,SubController> map = new HashMap();
	
	public FrontController(){
		Init(); //map 에 Init에 지정된 대로 서브컨트롤러가 추가됨
	}
	//등록할 서비스 지정
	private void Init() {
		map.put("COSMETIC",new ProductController());
		map.put("AUTH", new AuthController());
		map.put("RIVIEW", new RiviewController());
	}
	//MAP에 있는 서브컨트롤러를 꺼내어 해당 컨트롤러를 실행하는 함수
	public boolean SubControllerEX(String menu, int num, DTO dto) {
		SubController tmp;
		if(menu.equals("COSMETIC")) {
			tmp = map.get("COSMETIC"); //BookController를 꺼내어 tmp에 연결
			return tmp.execute(num, dto);	//서브컨트롤러 execute실후 결과(true/false)를 view로전달
		}else if (menu.equals("AUTH")) {
			tmp = map.get("AUTH");
			return tmp.execute(num, dto);
		}else if (menu.equals("RIVIEW")) {
            tmp = map.get("RIVIEW");
            return tmp.execute(num, dto);
        }
		
		return false;
	}


	
	
	
	
}
