package com.cosview.main;


import com.cosview.view.AuthView;
import com.cosview.view.EmployeeView;
//        re.ReviewView();

//        double total = 0.0;
//        Scanner sc = new Scanner(System.in);
//
//        int stNum = sc.nextInt(); //사람수
//
//        int[] arrSt = new int[stNum];
//
//        for(int i = 0; i < stNum; i++) {
//            System.out.print("사람" + (i + 1) + "의 점수 : ");
//            arrSt[i] = sc.nextInt();
//            if(arrSt[i] > 10 || arrSt[i] < 0) { // 점수가 0미만이거나 10초과인 경우
//                System.out.println("잘못된 점수 입니다. 다시 입력해 주세요.");
//                i--;
//                continue;
//            }
//        }
//
//        for(int i = 0; i < stNum; i++) {
//            total += arrSt[i];
//        }
//        System.out.println("학생 " + stNum + "명의 총합은 " + total +  "점 입니다.");
//        System.out.println("학생 " + stNum + "명의 평군은 " +Math.round(total / stNum * 100) / 100f +  "점 입니다.");

public class Main{

    public static void main(String[] args) {
        new AuthView();

//        EmployeeView ev = new EmployeeView();
//        ev.EmployeeView();
    }

}


