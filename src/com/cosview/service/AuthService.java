package com.cosview.service;

import com.cosview.domain.AuthDAO;
import com.cosview.dto.AuthDTO;
import com.cosview.dto.MemberDTO;

import java.util.HashMap;
import java.util.Map;

public class AuthService {
	AuthDAO dao = new  AuthDAO();

	Map<String, MemberDTO> map = new HashMap();
	//접속중인 계정에 대한 리스트
	//멤버 로그인 했을때 dao가 접속중인 계정에 대한 dto리턴
	//그 map에 다가 저장
	
	//회원 로그인
	public boolean MemberLogin(AuthDTO dto) {
		MemberDTO dto =  dao.MemberLogin(dto);
		if(dto==null)
			return false;
		else
		{

		}

	}
	
	//직원 로그인
	public boolean EmployeeLogin(AuthDTO dto) {
		return dao.EmployeeLogin(dto);
	}
}
