package domain;

import cosmeticdto.ProductDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    //연결관련 정보 저장용 변수
    String driver = "com.mysql.cj.jdbc.Driver";
    String id = "root";
    String pw = "1234";
    String url = "jdbc:mysql://localhost:3310/productdb";
    //DB연결관련 객체를 참조 변수
    Connection conn = null;             // DB 연결객체
    PreparedStatement pstmt = null;     // SQL 쿼리 전송 객체
    ResultSet rs = null;                // 쿼리결과(Select) 수신용 객체

    public DAO() {
        try {
            //DB Driver 로드
            Class.forName(driver);
            System.out.println("Driver Loading Success!");
            //DB연결객체 생성
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB Connected..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//생성자 끝

}
