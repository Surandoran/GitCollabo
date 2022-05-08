package view;

import com.sun.org.apache.bcel.internal.classfile.Code;
import controller.FrontController;
import cosmeticdto.AuthDTO;
import cosmeticdto.DTO;
import cosmeticdto.ProductDTO;
import domain.ProductDAO;

import java.awt.print.Book;
import java.util.Scanner;

public class Viewer {
    int num; //메뉴번호
    Scanner sc = new Scanner(System.in);
    String name;    //상품이름
    String brand;   //상품브랜드
    String price;      //상품가격
    String volume;  //상품용량
    String code;       //상품코드

    //controller 객체추가
    FrontController controller = new FrontController();
    ProductDAO dao = new ProductDAO();
    AuthDTO adto;
    ProductDTO pdto;
    boolean r;


    //메인메뉴
    public void LoginMenu() {
        while (true) {
            System.out.println("----------Login-----------");
            System.out.println("1. 회원 로그인");
            System.out.println("2. 회원 등록");
            System.out.println("3. 회원 조회");
            System.out.println("4. 회원 수정");
            System.out.println("5. 직원 로그인");
            System.out.println("6. 직원 등록");
            System.out.println("7. 직원 조회");
            System.out.println("8. 직원 수정");
            System.out.println("9. 삭제");
            System.out.println("10. 종료");
            System.out.println("----------Login-----------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num) {
                case 1: //회원로그인
                    System.out.print("회원 ID 입력 : ");
                    String tmpid = sc.next();
                    System.out.print("회원 PW 입력 : ");
                    String tmppw = sc.next();
                    adto = new AuthDTO(tmpid, tmppw);
                    r = controller.SubControllerEX("AUTH", 1, adto);
                    if (r) {
                        //인증성공 -> 회원메뉴출력
                        System.out.println("로그인 성공!!!");
                    } else {
                        System.out.println("로그인 실패...");
                    }
                    break;
                case 2: //회원 등록

                    break;
                case 3: //회원 조회
                    break;
                case 4: //직원 수정
                    break;
                case 5: //직원 로그인
                    System.out.print("직원 ID 입력 : ");
                    String tmpid2 = sc.next();
                    System.out.print("직원 PW 입력 : ");
                    String tmppw2 = sc.next();
                    adto = new AuthDTO(tmpid2, tmppw2);
                    r = controller.SubControllerEX("AUTH", 2, adto);
                    if (r) {
                        //인증성공 -> 직원메뉴출력
                        System.out.println("로그인 성공!!!");
                        product();
                    } else {
                        System.out.println("로그인 실패...");
                    }
                    break;
                case 6: //직원 등록
                    break;
                case 7: //직원 조회
                    break;
                case 8: //직원 수정
                    break;
                case 9: //삭제
                    break;
                case 10: //종료
                    System.out.println("프로그램을 종?료합니다");
                    System.exit(-1);
                default:
                    System.out.println("잘못입력하셨습니다.");
            }//switch 끝
        }//while 끝
    }

    public void product() { //직원메뉴
        while (true) {
            System.out.println("-------------PRODUCT------------");
            System.out.println("1 Inqury(조회)");
            System.out.println("2 Insert(삽입)");
            System.out.println("3 Update(수정)");
            System.out.println("4 Delete(삭제)");
            System.out.println("5 Prev(이전)");
            System.out.println("-------------PRODUCT------------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num) {
                case 1: //상품조회
                    System.out.println("상품조회요청!");
                    dao.Inqury(pdto);
                    break;
                case 2: //상품추가
                    System.out.print("상품명 : ");
                    name = sc.next();
                    System.out.print("브랜드명 : ");
                    brand = sc.next();
                    System.out.print("가격 : ");
                    price = sc.next();
                    System.out.print("용량 : ");
                    volume = sc.next();
                    System.out.print("코드 : ");
                    code = sc.next();

                    pdto = new ProductDTO(name, brand, price, volume, code);

                    r = controller.SubControllerEX("COSMETIC", 2, pdto);
                    //cosmetic선택 2번메뉴 삽입 , 저장된 상품정보
                    if (r) //만약 result 가 성공했다면
                        System.out.println("INSERT성공");
                    else
                        System.out.println("INSERT실패");
                    break;
                case 3: //상품수정
                    System.out.println("상품수정요청!");
                    System.out.print("새로운 상품명 : ");
                    name = sc.next();
                    System.out.print("새로운 브랜드명 : ");
                    brand = sc.next();
                    System.out.print("새로운 가격 : ");
                    price = sc.next();
                    System.out.print("새로운 용량 : ");
                    volume = sc.next();
                    System.out.print("수정 코드 : ");
                    code = sc.next();
                    pdto = new ProductDTO(name, brand, price, volume, code);

                    r = controller.SubControllerEX("COSMETIC", 3, pdto);

                    if (r) {//만약 result2가 성공했다면
                        System.out.println("Update 성공!");
                        dao.Inqury(pdto);
                    } else {
                        System.out.println("Update 실패!");
                    }
                    break;
                case 4: //상품삭제
                    System.out.println("상품삭제요청!");
                    System.out.print("제거상품코드 : ");
                    code = sc.next();

                    pdto = new ProductDTO(code);

                    r = controller.SubControllerEX("COSMETIC", 4, pdto);

                    if (r) { //만약 삭제성공했다면
                        System.out.println("DELETE 성공!");
                    } else {
                        System.out.println("DELTET 실패!");
                    }
                    break;
                case 5: //Mainmenu로 return
                    System.out.println("로그인 메뉴로 전환합니다!");
                    LoginMenu();
                default:
                    System.out.println("번호를 다시 입력하세요");
            }
        }
    }
}
