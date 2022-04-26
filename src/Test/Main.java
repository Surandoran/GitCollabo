package Test;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Person p1 = new Person("손필욱","중앙대로312 제네스타워 907호","010-2088-3028",1000000);
        String name = null;

        while (true) {
            System.out.println("============뭐든지팝니다=============");
            System.out.println("1. 메뉴등록");
            System.out.println("2. 손님정보");
            System.out.println("3. 잔액알아보기");
            System.out.println("4. 현재장바구니알아보기");
            System.out.println("5. 프로그램종료");
            //메뉴명 메뉴 갯수
//            int num = sc.nextInt();
//            switch (num) {
//                case 1:{
//                    System.out.println("메뉴이름을 입력해주세요");
//                    name = sc.next(p1.setMenu());
//                    System.out.println("개수를 입력해주세요");
//                    int count = sc.nextInt();
//                    int[] cnt = new int[count]; // 개수를 저장
//                    System.out.println("가격을 입력해주세요");
//                    int price = sc.nextInt(p1.setPrice());
//                    if(cnt.length < 0 ){
//                        System.out.println("개수는 0보다 작을 수 없습니다");
//                    }else{
//                        System.out.println("개수는 " + cnt.length);
//                    }
//                }
//                //손님 성함,전화번호,주소,가진돈 personinfo
//                case 2:{
//                    p1.
//                }
//                case 3:{
//                    p1.money();
//                }
//                case 4:{
//                    p1.menuinfo();
//                }
//                case 5:{
//                    break;
//                }
//                default:
            }
        }
    }

