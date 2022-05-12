package com.cosview.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
        // 현재 날짜 구하기 (시스템 시계, 시스템 타임존)
        LocalDate now1 = LocalDate.now();
// 현재 날짜 구하기(Paris)
        LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));
// 결과 출력
        System.out.println(now1); // 2021-06-17
        System.out.println(parisNow); // 2021-06-16
        // 현재 시간
        LocalTime now2 = LocalTime.now();
// 현재시간 출력
        System.out.println(now2); // 06:20:57.008731300
// 포맷 정의하기
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
// 포맷 적용하기
        String formatedNow = now2.format(formatter);
// 포맷 적용된 현재 시간 출력
        System.out.println(formatedNow); // 06시 20분 57초


    }

}
