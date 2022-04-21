package Test;

import java.io.*;
import java.util.HashMap;

public class Person extends MENU {
    String name;
    String addr;
    String phone;
    int money;

    public Person(String name,String addr,String phone,int money) {
        super(name);
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.money = money;
    }
    public void money(){
        System.out.printf("현재 잔액은 %d 입니다\n",money);
        if(this.money > 0){
            System.out.println("더 주문하시겠습니까?");
        }
        else {
            System.out.println("금액이 부족합니다.");
        }
    }
    void menu(){
        System.out.println("메뉴명 : " + getMenu());
        System.out.println("메뉴개수 : " + getCnt());
    }
    int price;
    int pay(int money){
        int don = this.money -= price;
        return money;
    }

    public void personinfo() {
        System.out.println("성함 : " + name);
        System.out.println("주소 : " + addr);
        System.out.println("전화번호 : " + phone);
    }
}
