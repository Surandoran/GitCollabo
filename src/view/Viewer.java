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
    int price;      //상품가격
    String volume;  //상품용량
    int code;       //상품코드

    //controller 객체추가
    FrontController controller = new FrontController();
    ProductDAO dao = new ProductDAO();
    ProductDTO dto;


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
                    AuthDTO dto = new AuthDTO(tmpid, tmppw);
                    boolean r1 = controller.SubControllerEX("AUTH", 1, dto);
                    if (r1) {
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
                    AuthDTO dto2 = new AuthDTO(tmpid2, tmppw2);
                    boolean r2 = controller.SubControllerEX("AUTH", 2, dto2);
                    if (r2) {
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
                    dao.Inqury(dto);
                    break;
                case 2: //상품추가
                    System.out.print("상품명 : ");
                    name = sc.next();
                    System.out.print("브랜드명 : ");
                    brand = sc.next();
                    System.out.print("가격 : ");
                    price = sc.nextInt();
                    System.out.print("용량 : ");
                    volume = sc.next();
                    System.out.print("코드 : ");
                    code = sc.nextInt();

                    ProductDTO dto1 = new ProductDTO(name, brand, price, volume, code);

                    boolean result = controller.SubControllerEX("COSMETIC", 2, dto1);
                    //cosmetic선택 2번메뉴 삽입 , 저장된 상품정보
                    if (result) //만약 result 가 성공했다면
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
                    price = sc.nextInt();
                    System.out.print("새로운 용량 : ");
                    volume = sc.next();
                    System.out.print("수정 코드 : ");
                    code = sc.nextInt();
                    ProductDTO dto2 = new ProductDTO(name, brand, price, volume, code);

                    boolean result2 = controller.SubControllerEX("COSMETIC", 3, dto2);

                    if (result2) {//만약 result2가 성공했다면
                        System.out.println("Update 성공!");
                        dao.Inqury(dto);
                    } else {
                        System.out.println("Update 실패!");
                    }
                    break;
                case 4: //상품삭제
                    System.out.println("상품삭제요청!");
                    System.out.print("제거상품코드 : ");
                    code = sc.nextInt();

                    ProductDTO dto3 = new ProductDTO(code);

                    boolean result3 = controller.SubControllerEX("COSMETIC", 4, dto3);

                    if (result3) { //만약 삭제성공했다면
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
