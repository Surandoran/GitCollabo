package test123;
//판매자
class C01Seller{
    //속성 돈, 사과개수, 사과가격
    private int MyMoney;
    private int AppleCnt;
    int price;
    //생성자
    C01Seller(int money,int cnt,int price){
        MyMoney = money;        //판매자의 돈
        AppleCnt = cnt;         //판매자의 사과개수
        this.price = price;     //판매자의 사과가격
    }
    //기능
    int Receive(int money){
        MyMoney += money;       //판매자의돈 + 구매자의돈
        int cnt = money/price;  //사과가격 / 사과가격은 1
        AppleCnt -= cnt;        //1만큼 내 사과개수를 차감
        if(AppleCnt < 0){
            System.out.println("사과 개수가 부족합니다");
        }
        return +cnt;             //1만큼 리턴
    }
    void ShowInfo(){
        System.out.println("보유금액 : " + MyMoney);
        System.out.println("사과개수 : " + AppleCnt);
        System.out.println("개당가격 : " + price);
    }
}
//구매자
class C01Buyer{
    //속성 돈, 사과개수
    private int MyMoney;
    private int AppleCnt;
    //생성자
    C01Buyer(int money,int cnt){
        MyMoney = money;    //구매자의 돈
        AppleCnt = cnt;     //구매자의 사과개수
    }
    //기능
    void Payment(C01Seller seller01,int money){
        MyMoney -= money;                   //구매자의 돈을 저장함
        int cnt = seller01.Receive(money);  //그돈을 판매자에게
        AppleCnt += cnt;                    //내 사과 갯수를 1만큼 증가시킴
    }


    void ShowInfo(){
        System.out.println("보유 금액 : " + MyMoney);
        System.out.println("사과 개수 : " + AppleCnt);
    }
}


public class test {

    public static void main(String[] args) {
        C01Seller seller = new C01Seller(100000, 100, 1000);
        C01Buyer buyer01 = new C01Buyer(10000, 0);
        C01Buyer buyer02 = new C01Buyer(20000, 0);
        C01Buyer buyer03 = new C01Buyer(30000, 0);
        buyer01.Payment(seller, 2000);
        buyer02.Payment(seller, 5000);
        buyer03.Payment(seller, 3000);
        System.out.println("---판매자정보---");
        seller.ShowInfo();
        System.out.println("---구매자정보---");
        System.out.println("-buyer01-");
        buyer01.ShowInfo();
        System.out.println("-buyer02-");
        buyer02.ShowInfo();
        System.out.println("-buyer03");
        buyer03.ShowInfo();
    }

}

