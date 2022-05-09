package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
	//연결정보
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/cosmeticdb";
		String id="root";
		String pw="1234";
		

		//연결객체정보
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		//생성자
		public DAO() {
			try {
				Class.forName(driver);
				System.out.println("Driver Loading Success");
				conn = DriverManager.getConnection(url,id,pw);
				System.out.println("DBConnected....");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		
}
