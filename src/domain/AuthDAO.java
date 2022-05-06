package domain;

import cosmeticdto.AuthDTO;

public class AuthDAO extends DAO{
    public boolean MemberLogin(AuthDTO dto) {
        try{
            pstmt = conn.prepareStatement("select id,pw from member_tbl where id = ?");
            pstmt.setString(1, dto.getId());
            rs = pstmt.executeQuery();

            String tid = null;
            String tpw = null;

            while (rs.next()){
                tid = rs.getString("id");
                tpw = rs.getString("pw");
            }

            // ID/PW 검증
            if(tid != null && tpw != null){
                if(tid.equals(dto.getId()) && tpw.equals(dto.getPw())){
                    return true;
                }
            }
        }catch (Exception e){

        }finally {
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }try{
                pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return false;
    }
    //직원로그인(num==2)
    public boolean EmployeeLogin(AuthDTO dto){
        try{
            pstmt = conn.prepareStatement("select id,pw from employee_tbl where id = ?");
            pstmt.setString(1, dto.getId());
            rs = pstmt.executeQuery();

            String tid = null;
            String tpw = null;

            while (rs.next()){
                tid = rs.getString("id");
                tpw = rs.getString("pw");
            }

            // ID/PW 검증
            if(tid != null && tpw != null){
                if(tid.equals(dto.getId()) && tpw.equals(dto.getPw())){
                    return true;
                }
            }
        }catch (Exception e){

        }finally {
            try{
                rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }try{
                pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return false;
    }
}
