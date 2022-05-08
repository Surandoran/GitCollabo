package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import cosmeticdto.ProductDTO;

public class ProductDAO extends DAO {
    int result;

    public boolean Inqury(ProductDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from product_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" + rs.getString("brand") + "\t" + rs.getString("price")
                                + "\t" + rs.getString("volume") + "\t" + rs.getString("code")
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

    public boolean Insert(ProductDTO dto) {    //삽입
        try {
            pstmt = conn.prepareStatement("insert into product_tbl values(?,?,?,?,?)");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBrand());
            pstmt.setString(3, dto.getPrice());
            pstmt.setString(4, dto.getVolume());
            pstmt.setString(5, dto.getCode());

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

    public boolean Update(ProductDTO dto) {
        try {
            //SQL전송 객체
            pstmt = conn.prepareStatement("update product_Tbl set name=?,brand=?,price=?,volume=? where code=?");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getBrand());
            pstmt.setString(3, dto.getPrice());
            pstmt.setString(4, dto.getVolume());
            pstmt.setString(5, dto.getCode());

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


    public boolean Delete(ProductDTO dto) {
        //연결
        try {
            //SQL전송객체 생성
            pstmt = conn.prepareStatement("delete from product_tbl where code=?");
            pstmt.setString(1, dto.getCode());

            //SQL 전송
            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstmt.close();} catch (Exception e1) {e1.printStackTrace();}
            try {conn.close();} catch (Exception e1) {e1.printStackTrace();}
        }
        return false;

    }



}
