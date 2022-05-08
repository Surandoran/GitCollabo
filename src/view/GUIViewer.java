package view;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import controller.FrontController;
import cosmeticdto.AuthDTO;
import cosmeticdto.DTO;
import cosmeticdto.ProductDTO;
import domain.ProductDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIViewer implements ActionListener {
    //컨트롤러 추가
    FrontController controller =new FrontController();
    AuthDTO dto;
    boolean r;

    ProductDAO dao = new ProductDAO();
    ProductDTO pdto;

    //입력창
    JFrame input;
    JButton enter;
    JTextField name;
    JTextField brand;
    JTextField price;
    JTextField volume;
    JTextField code;


    //로그인 창 관련
    JFrame loginmenu;
    JTextField id;
    JTextField pw;
    JButton login;
    JButton exit;
    JRadioButton employee;
    JRadioButton member;
    JLabel emp;
    JLabel mem;
    ButtonGroup rediogroup;

    //직원 메뉴 관련
    JFrame employeemenu;
    JButton inqury; //조회
    JButton insert; //삽입
    JButton update; //수정
    JButton delete; //삭제
    JTextArea area;
    JScrollPane scroll;

    //회원 메뉴 관련
    JFrame membermenu;
    JPanel pan = new JPanel();

    //생성자
    public GUIViewer(){
        Login();
        System.out.println("로그인 창 생성!");
    }

    //로그인 메뉴
    void Login(){
        loginmenu = new JFrame("로그인창");
        pan.setLayout(null);

        id = new JTextField("son");
        pw = new JTextField("1234");

        login = new JButton("로그인");
        exit = new JButton("종료");

        emp = new JLabel("직원");
        mem = new JLabel("회원");

        employee = new JRadioButton("직원");
        member = new JRadioButton("회원");

        rediogroup = new ButtonGroup();
        rediogroup.add(employee);
        rediogroup.add(member);

        id.setBounds(20,10,200,30);
        pw.setBounds(20,50,200,30);
        login.setBounds(230,10,80,70);
        exit.setBounds(320,10,80,70);

        employee.setBounds(20,90,20,20);
        emp.setBounds(50,90,40,20);
        member.setBounds(100,90,20,20);
        mem.setBounds(130,90,40,20);

        employee.setSelected(true);

        //리스너
        login.addActionListener(this);
        exit.addActionListener(this);

        pan.add(id);
        pan.add(pw);
        pan.add(login);
        pan.add(exit);
        pan.add(emp);
        pan.add(mem);
        pan.add(employee);
        pan.add(member);

        loginmenu.add(pan);

        loginmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginmenu.setBounds(100,100,430,170);
        loginmenu.setVisible(true);
    }

    //직원 메뉴
    void Employee(){
        employeemenu = new JFrame("직원메뉴");
        pan = new JPanel();
        pan.setLayout(null);


        inqury = new JButton("조회");
        insert = new JButton("삽입");
        update = new JButton("수정");
        delete = new JButton("삭제");

        inqury.setBounds(0,0,500,100);
        insert.setBounds(0,100,500,100);
        update.setBounds(0,200,500,100);
        delete.setBounds(0,300,500,100);

        inqury.addActionListener(this);
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);

        pan.add(inqury);
        pan.add(insert);
        pan.add(update);
        pan.add(delete);

        employeemenu.add(pan);

        employeemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        employeemenu.setBounds(100,100,500,440);
        employeemenu.setVisible(true);
    }

    //회원 메뉴
    void Member() {
        membermenu = new JFrame("회원메뉴");

        membermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        membermenu.setBounds(100,100,500,500);
        membermenu.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            System.out.println("로그인 버튼 누름!");

            //로그인 처리 하기(컨트롤러)

            //로그인 성공시
            //login창 숨김
            //employee창 띄움
            //로그인 실패시 다이얼로그 띄움
            if(member.isSelected()){
                dto = new AuthDTO(id.getText(), pw.getText());

                r = controller.SubControllerEX("AUTH", 1, dto);
                if(r){
                    loginmenu.setVisible(false);
                    Member();
                }else {
                    JOptionPane.showMessageDialog(null, "로그인실패");
                }
            } else if (employee.isSelected()) {
                dto = new AuthDTO(id.getText(), pw.getText());

                r = controller.SubControllerEX("AUTH", 2, dto);
                if(r){
                    loginmenu.setVisible(false);
                    Employee();
                }else{
                    JOptionPane.showMessageDialog(null, "로그인실패");
                }
            }
        }
        if(e.getSource() == inqury){
            System.out.println("조회 요청!");
            dao.Inqury(pdto);
        }
        if(e.getSource() == insert){
            System.out.println("삽입 요청!");

            input = new JFrame("상품 삽입!");

            pan = new JPanel();
            pan.setLayout(null);

            enter = new JButton("추가!");
            name = new JTextField("상품명");
            brand = new JTextField("브랜드명");
            price = new JTextField("가격");
            volume = new JTextField("용량");
            code = new JTextField("코드");

            enter.setBounds(300,70,150,350);
            name.setBounds(30,70,250,50);
            brand.setBounds(30,140,250,50);
            price.setBounds(30,210,250,50);
            volume.setBounds(30,280,250,50);
            code.setBounds(30,350,250,50);

            pan.add(name);
            pan.add(enter);
            pan.add(brand);
            pan.add(price);
            pan.add(volume);
            pan.add(code);

            input.add(pan);

            input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            input.setBounds(100,100,500,440);
            input.setVisible(true);

            boolean result = controller.SubControllerEX("COSMETIC", 2, pdto);
            //cosmetic선택 2번메뉴 삽입 , 저장된 상품정보
            if (result) //만약 result 가 성공했다면
                System.out.println("INSERT성공");
            else
                System.out.println("INSERT실패");
        }
        if(e.getSource() == update){
//            System.out.println("상품수정요청!");
//            System.out.print("새로운 상품명 : ");
//            name = sc.next();
//            System.out.print("새로운 브랜드명 : ");
//            brand = sc.next();
//            System.out.print("새로운 가격 : ");
//            price = sc.nextInt();
//            System.out.print("새로운 용량 : ");
//            volume = sc.next();
//            System.out.print("수정 코드 : ");
//            code = sc.nextInt();
//            ProductDTO dto2 = new ProductDTO(name, brand, price, volume, code);
//
//            boolean result2 = controller.SubControllerEX("COSMETIC", 3, dto2);
//
//            if (result2) {//만약 result2가 성공했다면
//                System.out.println("Update 성공!");
//                dao.Inqury(dto);
//            } else {
//                System.out.println("Update 실패!");
//            }
        }
        if(e.getSource() == delete){

//            boolean result3 = controller.SubControllerEX("COSMETIC", 4, deletedto);
//            if (result3) { //만약 삭제성공했다면
//                System.out.println("DELETE 성공!");
//            } else {
//                System.out.println("DELTET 실패!");
//            }
        }
        if(e.getSource() == exit){
            System.out.println("종료 버튼 누름!");
            System.exit(-1);
        }
    }
}
