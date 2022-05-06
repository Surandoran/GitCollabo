package com.cosview.main;

import com.cosview.domain.ProductDAO;
import com.cosview.dto.ProductDTO;

public class Main {

	public static void main(String[] args) {
		
		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
		ProductDAO dao = new ProductDAO();
		
		dao.Insert(dto);
		
	}
}
