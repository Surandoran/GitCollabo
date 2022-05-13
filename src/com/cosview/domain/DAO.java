package com.cosview.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DAO {

    //연결정보
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String id = "COSMETIC_EX";
    String pw = "1234";


    //연결객체정보
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection conn = null;

    // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
    LocalDate now1 = LocalDate.now(); //2021-06-17
//    LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));// 2021-06-16
    //현재시간
    LocalTime now2 = LocalTime.now();// 06:20:57.008731300
    //포맷 정의하기
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    //현재시간
    String formatedNow = now2.format(formatter);

    //평균내기
    //뷰에서 점수를 주며 댓글을 달면 그게 카운트로 들어가고 그 이후 계속 버튼이벤트로 반복




    //현재 시간과 날짜
    public String time() {
        // 포맷 적용된 현재 시간 출력
        System.out.println(now1);
        System.out.println(formatedNow); // 06시 20분 57초

        return null;
    }

    //생성자
    public DAO() {
        try {
            Class.forName(driver);
            System.out.println("Driver Loading Success");
            conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DBConnected....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
