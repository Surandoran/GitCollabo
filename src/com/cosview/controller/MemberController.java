package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.MemberDTO;
import com.cosview.service.MemberService;

public class MemberController implements SubController{

    MemberService service = new MemberService();

    @Override
    public boolean execute(int num, DTO dto) {

        MemberDTO mdto = (MemberDTO)dto;

        //조회 1,삽입 2,수정 3,삭제 4
        if(num==1){
            return service.MSelect(mdto);
        }else if(num==2) {
            return service.MInsert(mdto);
        }else if(num==3) {
            return service.MUpdate(mdto);
        }else if(num==4) {
            return service.MDelete(mdto);
        }
        return false;
    }
}
