package com.cosview.service;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class ProductService {

	ProductDAO dao = new ProductDAO();
	
	//조회
	public boolean Select(ProductDTO dto) {
		return dao.Select(dto);
	}
	
	//삽입
	public boolean Insert(ProductDTO dto) {
		return dao.Insert(dto);				
	}
	
	//수정
	public boolean Update(ProductDTO dto) {
        return dao.Update(dto);
    }
	
	//삭제
	public boolean Delete(ProductDTO dto) {
        return dao.Delete(dto);
    }
	
}
