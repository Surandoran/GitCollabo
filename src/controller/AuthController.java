package controller;

import cosmeticdto.AuthDTO;
import cosmeticdto.DTO;
import service.AuthService;

public class AuthController implements SubController {

    AuthService service = new AuthService();

    @Override
    public boolean execute(int num, DTO dto) {

        AuthDTO adto = (AuthDTO) dto;

        if (num == 1) {
            //회원로그인
            return service.MemberLogin(adto);
        } else if (num == 2) {
            //직원로그인
            return service.EmployeeLogin(adto);
        }
        return false;
    }
}
