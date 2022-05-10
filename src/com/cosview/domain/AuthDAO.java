package com.cosview.domain;

import com.cosview.dto.AuthDTO;
import com.cosview.dto.MemberDTO;

public class AuthDAO extends DAO{
	
//	public AuthDAO() {}
	
	
	public boolean MemberInsert(MemberDTO dto) {
		try {
			pstmt = conn.prepareStatement("insert into member_tbl values(?,?,?,?,?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getNickName());
			pstmt.setString(6, dto.getAddr());

			
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
	
	
	//회원 로그인 1
	public boolean MemberLogin(AuthDTO dto) {
		try {
			pstmt = conn.prepareStatement("select id,pw from member_tbl where id=?");
			pstmt.setString(1,dto.getId());
			rs = pstmt.executeQuery();
			String tid = null;
			String tpw = null;
			while(rs.next()) {
				tid = rs.getString("id");
				tpw = rs.getString("pw");
			}
			
			if(tid!=null && tpw!=null) {
				if(tid.equals(dto.getId()) && tpw.equals(dto.getPw())) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}

	
	//직원 로그인 2
	public boolean EmployeeLogin(AuthDTO dto) {
		try {
			try {
				pstmt = conn.prepareStatement("select * from employee_tbl where id=?");
				pstmt.setString(1,dto.getId());
				rs = pstmt.executeQuery();
				String tid = null;
				String tpw = null;
				while(rs.next()) {
					tid = rs.getString("id");
					tpw = rs.getString("pw");
				}
				
				
				if(tid!=null && tpw!=null) {
					if(tid.equals(dto.getId()) && tpw.equals(dto.getPw())) {
						return true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
					pstmt.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}		
		
		
		return false;
	}
}
