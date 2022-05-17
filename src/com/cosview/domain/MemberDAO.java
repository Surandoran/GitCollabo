package com.cosview.domain;

import com.cosview.dto.MemberDTO;

import java.lang.reflect.Member;

public class MemberDAO extends DAO{

    int result;

    public boolean MSelect(MemberDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from member_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("nickname") + "\t" + rs.getString("id") + "\t" + rs.getString("pw")
                                + "\t" + rs.getString("name") + "\t" + rs.getString("email") + "\t" + rs.getString("addr")
                        + "\t" + rs.getString("gender")
                );

            }
            if (result != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean MInsert(MemberDTO dto) {    //삽입
        try {
            pstmt = conn.prepareStatement("insert into member_tbl values(?,?,?,?,?,?,?)");
            pstmt.setString(1, dto.getNickName());
            pstmt.setString(2, dto.getId());
            pstmt.setString(3, dto.getPw());
            pstmt.setString(4, dto.getName());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getAddr());
            pstmt.setString(7, dto.getGender());

            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean MUpdate(MemberDTO dto) {
        try {
            //SQL전송 객체
            pstmt = conn.prepareStatement("update member_Tbl set nickname=?,id=?,pw=?,name=?,email=?,addr=?,gender=? where id=?");
            pstmt.setString(1, dto.getNickName());
            pstmt.setString(2, dto.getId());
            pstmt.setString(3, dto.getPw());
            pstmt.setString(4, dto.getName());
            pstmt.setString(5, dto.getEmail());
            pstmt.setString(6, dto.getAddr());
            pstmt.setString(7, dto.getGender());


            //SQL전송
            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean MDelete(MemberDTO dto) {
        //연결
        try {
            //SQL전송객체 생성
            pstmt = conn.prepareStatement("delete from member_tbl where id=?");
            pstmt.setString(1, dto.getId());

            //SQL 전송
            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstmt.close();} catch (Exception e1) {e1.printStackTrace();}
        }
        return false;

    }

}
