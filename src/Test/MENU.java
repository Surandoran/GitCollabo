package Test;

public class MENU {
    private String menu;
    private int cnt;
    private int price;

    public MENU(String menu, int cnt,int price) {
        this.menu = menu;
        this.cnt = cnt;
        this.price = price;
    }

    public MENU(String name) {
    }

    public String getMenu() {
        return menu;
    }

    public String setMenu() {
        this.menu = menu;
        return null;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPrice() {
        return price;
    }

    public int setPrice() {
        this.price = price;
        return 0;
    }

    public void menuinfo(){
        System.out.println(menu + "는 " + cnt + "개 입니다.");
        System.out.println("가격은 " + price + "원 입니다.");
    }

}
