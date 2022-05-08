package Main;

<<<<<<< HEAD
import controller.FrontController;
import controller.SubController;
import cosmeticdto.DTO;
import domain.ProductDAO;
import cosmeticdto.ProductDTO;
import view.Viewer;

import javax.swing.text.View;
import java.sql.Connection;
=======
import Product.domain.ProductDAO;
import Product.dto.ProductDTO;
>>>>>>> 7eaa4fb (2022-05-06 (ProductDAO-ProductDTO 테스트))

public class Main {

	public static void main(String[] args) {
<<<<<<< HEAD
		//AutoController생성,AuthDAO생성,AuthDTO생성,AuthService생성
		//시간남을시 GUIViewer 생성
//		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
//		ProductDAO dao = new ProductDAO();
//
////		dao.Insert(dto);	//삽입
////		dao.Inqury(dto);	//조회
////		dao.Update(dto);	//수정
//		dao.Delete(dto);	//삭제
//		view.product();

		view.LoginMenu();
=======
		
		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
		ProductDAO dao = new ProductDAO();
		
		dao.Insert(dto);
		
>>>>>>> 7eaa4fb (2022-05-06 (ProductDAO-ProductDTO 테스트))
	}
}
