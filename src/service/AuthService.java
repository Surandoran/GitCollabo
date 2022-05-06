package service;

import cosmeticdto.AuthDTO;
import domain.AuthDAO;

public class AuthService {

    AuthDAO dao = new AuthDAO();

    //회원 로그인
    public boolean MemberLogin(AuthDTO dto){
        return dao.MemberLogin(dto);
    }

    //직원 로그인
    public boolean EmployeeLogin(AuthDTO dto){
        return dao.EmployeeLogin(dto);
    }
}
