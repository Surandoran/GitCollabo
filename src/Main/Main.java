package Main;

import controller.FrontController;
import controller.SubController;
import cosmeticdto.DTO;
import domain.ProductDAO;
import cosmeticdto.ProductDTO;
import view.GUIViewer;
import view.Viewer;

import javax.swing.text.View;
import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		//AutoController생성,AuthDAO생성,AuthDTO생성,AuthService생성
		//시간남을시 GUIViewer 생성
//		ProductDTO dto = new ProductDTO("수분크림", "닥터지", 12000, "50ml");
//		ProductDAO dao = new ProductDAO();
//
//		dao.Insert(dto);	//삽입
//		dao.Inqury(dto);	//조회
//		dao.Update(dto);	//수정
//		dao.Delete(dto);	//삭제
		Viewer view = new Viewer();
//		view.product();
//		view.LoginMenu();
		new GUIViewer();
	}
}
