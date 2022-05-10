package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.ProductDTO;
import com.cosview.service.ProductService;

public class ProductController implements SubController{

	ProductService service = new ProductService();
	@Override
	public boolean execute(int num, DTO dto) {
		
		ProductDTO bdto = (ProductDTO)dto;
		
		//조회 1,삽입 2,수정 3,삭제 4
		if(num==1){
			return service.Select(bdto);
		}else if(num==2) {
			return service.Insert(bdto);
		}else if(num==3) {
			return service.Update(bdto);
		}else if(num==4) {
			return service.Delete(bdto);
		}
		
		return false;
	}

}
