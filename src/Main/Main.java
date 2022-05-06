package Main;

import Product.domain.ProductDAO;
import Product.dto.ProductDTO;

public class Main {

	public static void main(String[] args) {
		
		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
		ProductDAO dao = new ProductDAO();
		
		dao.Insert(dto);
		
	}
}
