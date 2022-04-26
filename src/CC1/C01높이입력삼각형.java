package CC1;

import java.util.Scanner;

public class C01높이입력삼각형 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("높이 입력 : ");
        int h = sc.nextInt();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}