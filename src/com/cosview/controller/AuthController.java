package com.cosview.controller;

import com.cosview.domain.AuthDAO;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.DTO;
import com.cosview.service.AuthService;

public class AuthController implements SubController{
	AuthService service = new AuthService();

	@Override
	public boolean execute(int num, DTO dto) {

		AuthDTO adto = (AuthDTO)dto;
		//1: 회원로그인 2: 직원로그인

		if(num==1){
			return service.MemberLogin(adto);
		}else if(num==2) {
			return service.EmployeeLogin(adto);
		}
		
	
		return false;
	}

}
