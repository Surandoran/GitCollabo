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
                        rs.getString("name") + "\t" + rs.getString("price") + "\t" + rs.getString("volume") + "\t" + rs.getString("review"
                        )
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
            pstmt = conn.prepareStatement("insert into review_tbl values(?,?,?,?)");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPrice());
            pstmt.setString(3, dto.getVolume());
            pstmt.setString(4, dto.getReview());

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
            pstmt = conn.prepareStatement("update review_Tbl set name=?,price=?,volume=?,review=? where name=?");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPrice());
            pstmt.setString(3, dto.getVolume());
            pstmt.setString(4, dto.getReview());

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
