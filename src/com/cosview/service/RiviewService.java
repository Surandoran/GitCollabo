package com.cosview.service;

import com.cosview.domain.RiviewDAO;
import com.cosview.dto.RiviewDTO;

public class RiviewService {

    RiviewDAO dao = new RiviewDAO();

    //조회
    public boolean RInqury(RiviewDTO dto) {
        return dao.RInqury(dto);
    }

    //추가
    public boolean RInsert(RiviewDTO dto) {
        return dao.RInsert(dto);
    }

    //수정
    public boolean RUpdate(RiviewDTO dto) {
        return dao.RUpdate(dto);
    }

    //삭제
    public boolean RDelete(RiviewDTO dto) {
        return dao.RDelete(dto);
    }
}
