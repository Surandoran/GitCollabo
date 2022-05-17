package com.cosview.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tdma {
    public static void main(String[] args) {

        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now1 = LocalDate.now(); //2021-06-17
        //    LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));// 2021-06-16
        //현재시간
        LocalTime now2 = LocalTime.now();// 06:20:57.008731300
        //포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        //현재시간
        String formatedNow = now2.format(formatter);

        String timenow = formatedNow + formatter;

    }
}
