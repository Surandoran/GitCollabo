package com.cosview.service;

import com.cosview.domain.MemberDAO;
import com.cosview.dto.MemberDTO;

public class MemberService {
    //회원가입 서비스

    MemberDAO dao = new MemberDAO();

    //조회
    public boolean MSelect(MemberDTO dto) {
        return dao.MSelect(dto);
    }

    //삽입
    public boolean MInsert(MemberDTO dto) {
        return dao.MInsert(dto);
    }

    //수정
    public boolean MUpdate(MemberDTO dto) {
        return dao.MUpdate(dto);
    }

    //삭제
    public boolean MDelete(MemberDTO dto) {
        return dao.MDelete(dto);
    }


}
