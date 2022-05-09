package service;

import cosmeticdto.RiviewDTO;
import domain.RiviewDAO;

public class RiviewService {

    RiviewDAO dao = new RiviewDAO();

    //조회
    public boolean Inqury(RiviewDTO dto) {
        return dao.Inqury(dto);
    }

    //추가
    public boolean Insert(RiviewDTO dto) {
        return dao.Insert(dto);
    }

    //수정
    public boolean Update(RiviewDTO dto) {
        return dao.Update(dto);
    }

    //삭제
    public boolean Delete(RiviewDTO dto) {
        return dao.Delete(dto);
    }
}
