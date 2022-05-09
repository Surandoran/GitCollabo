package view;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import controller.FrontController;
import cosmeticdto.AuthDTO;
import cosmeticdto.DTO;
import cosmeticdto.ProductDTO;
import cosmeticdto.RiviewDTO;
import domain.ProductDAO;
import domain.RiviewDAO;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class
GUIViewer implements ActionListener {

    //컨트롤러 추가
    FrontController controller = new FrontController();
    AuthDTO adto;
    boolean r;

    ProductDAO dao = new ProductDAO();
    ProductDTO pdto;
    RiviewDAO rdao = new RiviewDAO();
    RiviewDTO rdto;

    //입력창
    JFrame input;//삽입
    JButton enter; //삽입
    JButton Update; //수정
    JButton Delete; //삭제

    //상품정보
    JTextField name;
    JTextField brand;
    JTextField price;
    JTextField volume;
    JTextField code;

    //리뷰관련
    JButton riviewS; //조회버튼
    JButton riviewI; //쓰기버튼
    JButton riviewU; //수정버튼
    JButton riviewD; //삭제버튼
    JButton riviewS1; //조회버튼
    JButton riviewI1; //쓰기버튼
    JButton riviewU1; //수정버튼
    JButton riviewD1; //삭제버튼
    JButton riviewS2; //조회버튼
    JButton riviewI2; //쓰기버튼
    JButton riviewU2; //수정버튼
    JButton riviewD2; //삭제버튼
    JTextField riview; //쓰는공간

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
    public GUIViewer() {
        Login();
        System.out.println("로그인 창 생성!");
    }

    //로그인 메뉴
    void Login() {
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

        id.setBounds(20, 10, 200, 30);
        pw.setBounds(20, 50, 200, 30);
        login.setBounds(230, 10, 80, 70);
        exit.setBounds(320, 10, 80, 70);

        employee.setBounds(20, 90, 20, 20);
        emp.setBounds(50, 90, 40, 20);
        member.setBounds(100, 90, 20, 20);
        mem.setBounds(130, 90, 40, 20);

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
        loginmenu.setBounds(100, 100, 430, 170);
        loginmenu.setVisible(true);
    }

    //직원 메뉴
    void Employee() {
        employeemenu = new JFrame("직원메뉴");
        pan = new JPanel();
        pan.setLayout(null);


        inqury = new JButton("조회");
        insert = new JButton("삽입");
        update = new JButton("수정");
        delete = new JButton("삭제");

        inqury.setBounds(0, 0, 500, 100);
        insert.setBounds(0, 100, 500, 100);
        update.setBounds(0, 200, 500, 100);
        delete.setBounds(0, 300, 500, 100);

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
        employeemenu.setBounds(100, 100, 500, 440);
        employeemenu.setVisible(true);
    }

    //회원 메뉴
    void Member() {
        membermenu = new JFrame("회원메뉴");
        pan = new JPanel();
        pan.setLayout(null);


        riviewS = new JButton("리뷰조회");
        riviewI = new JButton("리뷰쓰기");
        riviewU = new JButton("리뷰수정");
        riviewD = new JButton("리뷰삭제");

        riviewS.setBounds(0, 0, 500, 100);
        riviewI.setBounds(0, 100, 500, 100);
        riviewU.setBounds(0, 200, 500, 100);
        riviewD.setBounds(0, 300, 500, 100);

        riviewS.addActionListener(this);
        riviewI.addActionListener(this);
        riviewU.addActionListener(this);
        riviewD.addActionListener(this);

        pan.add(riviewS);
        pan.add(riviewI);
        pan.add(riviewU);
        pan.add(riviewD);

        membermenu.add(pan);

        membermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        membermenu.setBounds(100, 100, 500, 440);
        membermenu.setVisible(true);
    }

    void riviewInsert() {
        input = new JFrame("리뷰");

        pan = new JPanel();
        pan.setLayout(null);

        riviewI1 = new JButton("등록");
        name = new JTextField("상품명");
        price = new JTextField("가격");
        volume = new JTextField("용량");
        riview = new JTextField("리뷰");

        riviewI1.setBounds(410,30,60,30);
        name.setBounds(30,30,120,30);
        price.setBounds(160,30,120,30);
        volume.setBounds(290,30,120,30);
        riview.setBounds(30,70,400,400);

        pan.add(name);
        pan.add(riviewI1);
        pan.add(price);
        pan.add(volume);
        pan.add(riview);

        riviewI1.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);
    }

    void riviewDelete() {
        input = new JFrame("리뷰 삭제!");

        pan = new JPanel();
        pan.setLayout(null);

        riviewD1 = new JButton("리뷰삭제!");
        name = new JTextField("삭제하려는 상품명을 정확히입력해주세요");

        riviewD1.setBounds(300, 70, 150, 350);
        name.setBounds(30, 350, 250, 50);

        pan.add(riviewD1);
        pan.add(name);

        riviewD1.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }

    void riviewUpdate(){
        input = new JFrame("리뷰 수정!");

        pan = new JPanel();
        pan.setLayout(null);

        riviewU1 = new JButton("수정!");
        name = new JTextField("상품명");
        price = new JTextField("가격");
        volume = new JTextField("용량");
        riview = new JTextField("리뷰");

        riviewU1.setBounds(400,40,90,50);
        name.setBounds(30,30,50,30);
        price.setBounds(80,30,50,30);
        volume.setBounds(130,30,50,30);
        riview.setBounds(30,70,400,400);

        pan.add(name);
        pan.add(riviewU1);
        pan.add(price);
        pan.add(volume);
        pan.add(riview);

        riviewU1.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);
    }

    //삽입 메뉴
    void Insert() {
        input = new JFrame("상품 삽입!");

        pan = new JPanel();
        pan.setLayout(null);

        enter = new JButton("추가!");
        name = new JTextField("상품명");
        brand = new JTextField("브랜드명");
        price = new JTextField("가격");
        volume = new JTextField("용량");
        code = new JTextField("코드");

        enter.setBounds(300, 70, 150, 350);
        name.setBounds(30, 70, 250, 50);
        brand.setBounds(30, 140, 250, 50);
        price.setBounds(30, 210, 250, 50);
        volume.setBounds(30, 280, 250, 50);
        code.setBounds(30, 350, 250, 50);

        pan.add(name);
        pan.add(enter);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);

        enter.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }

    //수정 메뉴
    void Update() {
        input = new JFrame("상품 수정!");

        pan = new JPanel();
        pan.setLayout(null);

        Update = new JButton("수정!");
        name = new JTextField("상품수정명");
        brand = new JTextField("브랜드수정명");
        price = new JTextField("가격수정");
        volume = new JTextField("용량수정");
        code = new JTextField("변경하려는 코드명을 정확히입력해주세요");

        Update.setBounds(300, 70, 150, 350);
        name.setBounds(30, 70, 250, 50);
        brand.setBounds(30, 140, 250, 50);
        price.setBounds(30, 210, 250, 50);
        volume.setBounds(30, 280, 250, 50);
        code.setBounds(30, 350, 250, 50);

        pan.add(name);
        pan.add(Update);
        pan.add(brand);
        pan.add(price);
        pan.add(volume);
        pan.add(code);

        Update.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }

    //삭제 메뉴
    void Delete() {
        input = new JFrame("상품 삭제!");

        pan = new JPanel();
        pan.setLayout(null);

        Delete = new JButton("삭제!");
        code = new JTextField("삭제하려는 code명을 정확히입력해주세요");

        Delete.setBounds(300, 70, 150, 350);
        code.setBounds(30, 350, 250, 50);

        pan.add(Delete);
        pan.add(code);

        Delete.addActionListener(this);

        input.add(pan);

        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setBounds(100, 100, 500, 440);
        input.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            System.out.println("로그인 버튼 누름!");

            //로그인 처리 하기(컨트롤러)

            //로그인 성공시
            //login창 숨김
            //employee창 띄움
            //로그인 실패시 다이얼로그 띄움
            if (member.isSelected()) {
                adto = new AuthDTO(id.getText(), pw.getText());

                r = controller.SubControllerEX("AUTH", 1, adto);
                if (r) {
                    loginmenu.setVisible(false);
                    Member();
                } else {
                    JOptionPane.showMessageDialog(null, "로그인실패");
                }
            } else if (employee.isSelected()) {
                adto = new AuthDTO(id.getText(), pw.getText());

                r = controller.SubControllerEX("AUTH", 2, adto);
                if (r) {
                    loginmenu.setVisible(false);
                    Employee();
                } else {
                    JOptionPane.showMessageDialog(null, "로그인실패");
                }
            }
        }
        if (e.getSource() == inqury) {
            System.out.println("조회 요청!");
            dao.Inqury(pdto);
        }
        if (e.getSource() == insert) {
            System.out.println("삽입 요청!");
            Insert();
        }
        if (e.getSource() == enter) {
            System.out.println("삽입버튼누름!!!");
            pdto = new ProductDTO(name.getText(), brand.getText(), price.getText(), volume.getText(), code.getText());

            r = controller.SubControllerEX("COSMETIC", 2, pdto);
            if (r) {
                input.setVisible(false);
                employeemenu.setVisible(true);
                Employee();
                dao.Inqury(pdto);
            } else {
                JOptionPane.showMessageDialog(null, "상품삽입실패!");
            }
        }
        if (e.getSource() == update) {
            System.out.println("수정 요청!");
            Update();
        }
        if (e.getSource() == Update) {
            System.out.println("수정버튼누름!!!!");
            pdto = new ProductDTO(name.getText(), brand.getText(), price.getText(), volume.getText(), code.getText());

            r = controller.SubControllerEX("COSMETIC", 3, pdto);
            if (r) {
                input.setVisible(false);
                employeemenu.setVisible(true);
                Employee();
                dao.Inqury(pdto);
            } else {
                JOptionPane.showMessageDialog(null, "수정실패!");
            }
        }
        if (e.getSource() == delete) {
            System.out.println("삭제 요청!");
            dao.Inqury(pdto);
            Delete();
        }
        if (e.getSource() == Delete) {
            System.out.println("삭제버튼누름!!");

            pdto = new ProductDTO(code.getText());

            r = controller.SubControllerEX("COSMETIC", 4, pdto);
            if (r) {
                System.out.println("삭제 성공!");
                input.setVisible(false);
                employeemenu.setVisible(true);
                Employee();
                dao.Inqury(pdto);
            } else {
                JOptionPane.showMessageDialog(null, "삭제실패!");
            }
        }
        if (e.getSource() == exit) {
            System.out.println("종료 버튼 누름!");
            System.exit(-1);
        }
        if (e.getSource() == riviewS) {
            System.out.println("조회 요청!");
            rdao.RInqury(rdto);
        }
        if (e.getSource() == riviewI) {
            riviewInsert();
        }
        if (e.getSource() == riviewI1) {

            rdto = new RiviewDTO(name.getText(), price.getText(), volume.getText(), riview.getText());

            r = controller.SubControllerEX("RIVIEW", 2, rdto);
            if (r) {
                    input.setVisible(false);
                    membermenu.setVisible(true);
                    Member();
            } else {
                JOptionPane.showMessageDialog(null, "리뷰쓰기실패");
            }
        }

        if (e.getSource() == riviewU) {
            System.out.println("수정 요청!");
            riviewUpdate();
        }
        if (e.getSource() == riviewU1) {
            System.out.println("상품명을 정확히 입력해주세요!");
            rdto = new RiviewDTO(name.getText(), price.getText(), volume.getText(), riview.getText());

            r = controller.SubControllerEX("RIVIEW", 3, rdto);
            if (r) {
                input.setVisible(false);
                membermenu.setVisible(true);
                Member();
            } else {
                JOptionPane.showMessageDialog(null, "수정실패!");
            }
        }
        if (e.getSource() == riviewD) {
            System.out.println("삭제 요청!");
            riviewDelete();
        }
        if (e.getSource() == riviewD1) {

            rdto = new RiviewDTO(name.getText());

            r = controller.SubControllerEX("RIVIEW", 4, rdto);
            if (r) {
                System.out.println("삭제 성공!");
                input.setVisible(false);
                membermenu.setVisible(true);
                Member();
            } else {
                JOptionPane.showMessageDialog(null, "삭제실패!");
            }
        }
        if (e.getSource() == exit) {
            System.out.println("종료 버튼 누름!");
            System.exit(-1);
        }
    }
}

