package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.dto.MemberDTO;
import com.cosview.service.MemberService;

public class MemberController implements SubController{

    MemberService service = new MemberService();

    @Override
    public boolean execute(int num, DTO dto) {

        MemberDTO mdto = (MemberDTO)dto;

        // 1: 멤버조회 2: 회원가입 3: 회원수정 4:회원삭제
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
