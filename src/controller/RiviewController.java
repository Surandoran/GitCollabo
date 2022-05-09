package controller;

import cosmeticdto.DTO;
import cosmeticdto.RiviewDTO;
import service.RiviewService;

public class RiviewController implements SubController {

    RiviewService service = new RiviewService();

    @Override
    public boolean execute(int num, DTO dto) {

        //downcasting
        RiviewDTO rdto = (RiviewDTO) dto;

        //1: 조회,2: 삽입,3: 수정,4: 삭제
        if (num == 1) {
            return service.RInqury(rdto);
        } else if (num == 2) {
            return service.RInsert(rdto);
        } else if (num == 3) {
            return service.RUpdate(rdto);
        } else if (num == 4) {
            return service.RDelete(rdto);
        }
        return false;
    }
}
