package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cosview.dto.ReviewDTO;


public class ReviewDAO extends DAO {
    int result;

    public boolean RInqury(ReviewDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from review_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" + rs.getString("member_nickname ") + "\t" + rs.getString("product_name ") + "\t" 
                + rs.getString("contents" +  "\t" + rs.getInt("score")+ "\t" + rs.getString("insert_time  "))
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

    public boolean RInsert(ReviewDTO dto) {    //삽입
        try {
            pstmt = conn.prepareStatement("insert into review_tbl values(?,?,?,?,?,?)");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getMember_nickname ());
            pstmt.setString(3, dto.getProduct_name ());
            pstmt.setString(4, dto.getContents ());
            pstmt.setInt(5, dto.getScore());
            pstmt.setString(6, dto.getInsert_time());

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
            //SQL전송 객체
            pstmt = conn.prepareStatement("update review_Tbl set name=?,member_nickname =?,product_name =?,contents =?,score  =?,insert_time  =? where name=?");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getMember_nickname ());
            pstmt.setString(3, dto.getProduct_name ());
            pstmt.setString(4, dto.getContents ());
            pstmt.setInt(5, dto.getScore());
            pstmt.setString(6, dto.getInsert_time());

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
            pstmt.setString(1, dto.getName());

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
