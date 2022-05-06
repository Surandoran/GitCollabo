package view;

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

    //controller 객체추가
    FrontController controller = new FrontController();
    ProductDAO dao = new ProductDAO();
    ProductDTO dto;
    String name;
    String brand;
    int price;
    String volume;

    //메인메뉴
    public void LoginMenu(){
        while (true){
            System.out.println("----------Login-----------");
            System.out.println("1. 직원로그인");
            System.out.println("2. 회원로그인");
            System.out.println("3. 종료");
            System.out.println("----------Login-----------");
            System.out.print("번호 : ");
            num = sc.nextInt();
            switch (num){
                case 1: //회원로그인
                    System.out.print("회원 ID|PW > ");
                    String tmpid = sc.next();
                    String tmppw = sc.next();
                    AuthDTO dto = new AuthDTO(tmpid,tmppw);
                    boolean r1 = controller.SubControllerEX("AUTH",1,dto);
                    if(r1){
                        //인증성공 -> 회원메뉴출력
                    }else {
                        System.out.println("로그인 실패...");
                    }
                break;
                case 2: //직원메뉴
                    System.out.print("직원 ID|PW > ");
                    String tmpid2 = sc.next();
                    String tmppw2 = sc.next();
                    AuthDTO dto2 = new AuthDTO(tmpid2,tmppw2);
                    boolean r2 = controller.SubControllerEX("AUTH",1,dto2);
                    if(r2){
                        //인증성공 -> 직원메뉴출력
                        System.out.println("로그인 성공!!!");
                        product();
                    }else{
                        System.out.println("로그인 실패...");
                    }
                    break;
                case 3: //회원메뉴
                    break;
                case 4: //종료
                    System.out.println("프로그램을 종료합니다");
                    System.exit(-1);
                    break;
                default:
            }//switch 끝
        }//while 끝
    }
    public void product(){
        while (true){
            System.out.println("-------------PRODUCT------------");
            System.out.println("1 Select");
            System.out.println("2 Insert");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 Prev");
            System.out.println("-------------PRODUCT------------");
            System.out.print("번호 : " );
            num=sc.nextInt();
            switch (num){
                case 1: //상품조회
                    System.out.println("상품조회요청!");
                    dao.Inqury(dto);
                    break;
                case 2: //상품추가
                    System.out.print("상품명|브랜드명|가격|용량");
                    name = sc.next();
                    brand = sc.next();
                    price = sc.nextInt();
                    volume = sc.next();
                    ProductDTO DTO = new ProductDTO(name,brand,price,volume);

                    boolean result = controller.SubControllerEX("COSMETIC", 2, DTO);
                                                                //cosmetic선택 2번메뉴 삽입 , 저장된 상품정보
                    if(result) //만약 result 가 성공했다면
                        System.out.println("INSERT성공");
                    else
                        System.out.println("INSERT실패");
                    break;
                case 3: //상품수정
                    System.out.println("상품수정요청!");
                    System.out.print("상품명|브랜드명|가격|용량");
                    dao.Update(dto);
                    System.out.print("수정명 : ");
                    name = sc.next();
                    System.out.print("브랜드명 : ");
                    brand = sc.next();
                    System.out.print("가격 : ");
                    price = sc.nextInt();
                    System.out.print("용량 : ");
                    volume = sc.next();

                    System.out.print("수정하려는 상품명 : ");
                    name = sc.next();
                    if(dao.Update(dto))
                        System.out.println("Update성공!");
                    else
                        System.out.println("Update실패!");

                    break;
                case 4: //상품삭제
                    break;
                default:
                    System.out.println("번호를 다시 입력하세요");
            }
        }
    }
}
