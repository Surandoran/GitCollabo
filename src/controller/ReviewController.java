package controller;

import cosmeticdto.DTO;
import cosmeticdto.ProductDTO;
import service.ReviewService;

public class ReviewController implements SubController{
    ReviewService service = new ReviewService();
    public boolean execute(String menu, int num, DTO dto) {
        //downcasting
        ProductDTO bdto = (ProductDTO)dto;

        //1: 조회,2: 삽입,3: 수정,4: 삭제
        if (num == 1) {
            return service.Inqury(bdto);
        } else if (num == 2) {
            return service.Insert(bdto);
        } else if (num == 3) {
            return service.Update(bdto);
        } else if (num == 4) {
            return service.Delete(bdto);
        }
        return false;
    }

}
