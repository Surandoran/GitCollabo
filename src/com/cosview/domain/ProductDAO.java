package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cosview.dto.ProductDTO;
import com.cosview.view.MemberView;

public class ProductDAO extends DAO{
	
		
	
	
	//연결정보
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/cosmeticdb";
	private String id="root";
	private String pw="1234";
	
	//연결객체정보
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	
	//생성자
	public ProductDAO() {
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DBConnected....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
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

	
	
	
	
}
