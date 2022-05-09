package controller;

import cosmeticdto.DTO;

import java.util.HashMap;
import java.util.Map;

public class FrontController {
    //subcontroller seve
    //서비스 요청이 들어오면 해당되는 서비스컨트롤러를 호출함.
    private Map<String, SubController> map = new HashMap<>();

    public FrontController() {
        Init(); //map 에 Init에 지정된 대로 Subcontroller에 저장
    }

    //등록할 서비스 지점
    private void Init() {
        map.put("COSMETIC", new ProduntController());
        map.put("AUTH", new AuthController());
        map.put("RIVIEW", new RiviewController());
    }

    //MAP에 있는 서브컨트롤러를 꺼내어 실행하는 함수
    public boolean SubControllerEX(String menu, int num, DTO dto) {
        SubController tmp;
        if (menu.equals("COSMETIC")) {
            tmp = map.get("COSMETIC"); //BookController를 꺼내어 tmp에 연결
            return tmp.execute(num, dto); // Subcontroller execute실행후 결과(true/false)를 view로 전달
                                          // num : 1(조회) 2(삽입) 3(수정) 4(삭제)
        } else if (menu.equals("AUTH")) {
            tmp = map.get("AUTH"); //AuthController를 꺼내어 tmp에 연결
            return tmp.execute(num, dto); //SubController execute실행 결과(true/false)를 view로 전달
                                          //num == 1 회원로그인 / num == 2 직원로그인
        } else if (menu.equals("RIVIEW")) {
            tmp = map.get("RIVIEW");
            return tmp.execute(num, dto);
        }
        return false;
    }
}
