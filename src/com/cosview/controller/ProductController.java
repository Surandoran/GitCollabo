package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.ProductDTO;
import com.cosview.service.cosService;

public class ProductController implements SubController{

	cosService service = new cosService();
	@Override
	public boolean execute(int num, DTO dto) {
		
		ProductDTO bdto = (ProductDTO)dto;
		
		//조회 1,삽입 2,수정 3,삭제 4
		if(num==1){
			return service.Select(bdto);
		}else if(num==2) {
			return service.Insert(bdto);
		}else if(num==3) {
			
		}else if(num==4) {
			
		}
		
		return false;
	}

}
