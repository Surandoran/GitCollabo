package com.cosview.controller;

import com.cosview.dto.DTO;
import com.cosview.service.AuthService;
import com.cosview.service.CosumerService;

public class CosumerController implements SubController{

    CosumerService service = new CosumerService();

    //1 : 내리뷰조회 2: 내정보수정 3: 내리뷰수정 4:내계정삭제

    @Override
    public boolean execute(int num, DTO dto) {



        return false;
    }
}
