package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.ProductDTO;
import com.cosview.service.ProductService;

public class ProductController implements SubController{

	ProductService service = new ProductService();

	@Override
	public boolean execute(String menu, int num, DTO dto) {
		//다운캐스팅
		ProductDTO pdto = (ProductDTO)dto;
		
		if(num==1) {
			
		}else if(num==2){
			return service.Insert(pdto);
			
		}else if(num==3) {
			
		}else if(num==4) {
			
		}
		return false;
	}
	
	
}
