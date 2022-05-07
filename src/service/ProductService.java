package service;

import cosmeticdto.ProductDTO;
import domain.ProductDAO;

public class ProductService {

    //멤버
    ProductDAO dao = new ProductDAO();

    //조회
    public boolean Inqury(ProductDTO dto) {
        return dao.Inqury(dto);
    }

    //추가
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
