package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import cosmeticdto.ProductDTO;

public class ProductDAO extends DAO {



    public boolean Inqury(ProductDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from product_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" + rs.getString("brand") + "\t" + rs.getInt("price")
                                + "\t" + rs.getString("volume")
                );

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
            pstmt = conn.prepareStatement("insert into product_tbl values(?,?,?,?)");
            pstmt.setString(1, dto.getname());
            pstmt.setString(2, dto.getbrand());
            pstmt.setInt(3, dto.getprice());
            pstmt.setString(4, dto.getvolume());

            int result = pstmt.executeUpdate();

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
            pstmt = conn.prepareStatement("update product_Tbl set name=?,brand=?,price=?,volume=? where name=?");
            pstmt.setString(1, dto.getname());
            pstmt.setString(2, dto.getbrand());
            pstmt.setInt(3, dto.getprice());
            pstmt.setString(4, dto.getvolume());
            pstmt.setString(5, dto.getname());

            //SQL전송
            int result = pstmt.executeUpdate();

            if (result != 0) {
                System.out.println("Update 성공");
            } else {
                System.out.println("Update 실패");
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
            pstmt = conn.prepareStatement("delete from product_tbl where name=?");
            pstmt.setString(1, "달팽이크림");

            //SQL 전송
            int result = pstmt.executeUpdate();

            if (result != 0) {
                System.out.println("Delete 완료");
            } else {
                System.out.println("Delete 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
        return false;

    }

}
