package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cosview.dto.MemberDTO;
import com.cosview.dto.ReviewDTO;


public class ReviewDAO extends DAO {
    int result;
    double D;
    DAO dao = new DAO();

    public boolean RInqury(ReviewDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from review_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" + rs.getString("id") + "\t" + rs.getString("nickname")
                                + "\t" + rs.getString("pname") + "\t" + rs.getString("contents") + "\t" + rs.getInt("score")

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

    public boolean RInsert(ReviewDTO dto) {    //삽입 //제목,닉네임,상품이름,리뷰내용,점수,시간
        try {
            pstmt = conn.prepareStatement("insert into review_tbl values(?,?,?,?,?)");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getNickname());
            pstmt.setString(3, dto.getPname());
            pstmt.setString(4, dto.getContents());
            pstmt.setString(6, dto.getTime());

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

    public boolean RUpdate(ReviewDTO dto) {
        try {
            //SQL전송 객체 //리뷰 제목을 받아 리뷰 내용을 수정그리고 시간을 받음
            pstmt = conn.prepareStatement("update review_Tbl set name=?,contents=?,time=? where name=?");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getContents());
            pstmt.setString(3, dto.getTime());
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


    public boolean RDelete(ReviewDTO dto) {
        //연결
        try {
            //SQL전송객체 생성
            pstmt = conn.prepareStatement("delete from review_tbl where name=?");
            pstmt.setString(1, dto.getName()); //제목을 받아 삭제

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
