package com.cosview.service;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class cosService {

	ProductDAO dao = new ProductDAO();
	
	public boolean Insert(ProductDTO dto) {
		return dao.Insert(dto);				
	}

	public boolean Select(ProductDTO dto) {
		return dao.Select(dto);
	}
}
