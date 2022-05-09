package com.cosview.service;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class ProductService {
	
	ProductDAO dao = new ProductDAO();
	
	//삽입
	public boolean Insert(ProductDTO dto) {
		return dao.Insert(dto);
	}
}
