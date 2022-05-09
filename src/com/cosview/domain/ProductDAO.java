package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cosview.dto.ProductDTO;
import com.cosview.view.MemberView;

public class ProductDAO extends DAO{

	private int result;
	
	//생성자
//	public ProductDAO() {}
	
	public boolean Select(ProductDTO dto) {
		try {
			
			pstmt =conn.prepareStatement("select * from product_tbl");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberView.area.append(rs.getString("name") + " " + rs.getString("brand") + " "
						+ rs.getString("price") + " " + rs.getString("volume")+ rs.getString("Code")+ "\n");
				System.out.println(rs.getString("name") + " " + rs.getString("brand") + " "
						+ rs.getInt("price") + " " + rs.getString("volume"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	public boolean Insert(ProductDTO dto) {
		try {
			pstmt = conn.prepareStatement("insert into product_tbl values(?,?,?,?)");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBrand());
			pstmt.setString(3, dto.getPrice());
			pstmt.setString(4, dto.getVolume());
			pstmt.setString(5, dto.getCode());
			
			int result = pstmt.executeUpdate();
			
			if(result!=0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
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
        }
        return false;

    }

	
	
	
	
}
