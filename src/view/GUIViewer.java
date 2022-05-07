package view;

import controller.FrontController;
import cosmeticdto.AuthDTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIViewer implements ActionListener {
    //컨트롤러 추가
    FrontController controller =new FrontController();

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
    ButtonGroup radiogroup;


    //직원 메뉴 관련
    JFrame employeemenu;
    JButton insert;
    JButton update;
    JButton delete;
    JButton select;
    JTextArea area;
    JScrollPane scroll;


    //회원 메뉴 관련
    JFrame membermenu;


    //생성자
    public GUIViewer()
    {
        Login();
        System.out.println("로그인 창 생성!");
    }


    //로그인 메뉴
    void Login() {
        loginmenu = new JFrame("로그인창");

        JPanel pan = new JPanel();
        pan.setLayout(null);

        id = new JTextField("ID");
        pw = new JTextField("PW");

        login = new JButton("로그인");
        exit = new JButton("종료");

        emp = new JLabel("직원");
        mem = new JLabel("멤버");

        employee = new JRadioButton("직원");
        member = new JRadioButton("회원");


        radiogroup= new ButtonGroup();
        radiogroup.add(employee);
        radiogroup.add(member);


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
    void Employee() {
        employeemenu = new JFrame("직원메뉴");


        employeemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        employeemenu.setBounds(100,100,500,500);
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
        if(e.getSource() == login ) {
            System.out.println("로그인 버튼 누름!");

            //로그인 처리 하기(컨트롤러)
            //로그인 성공시
            //-Login창 숨김
            //-Employee창 띄움
            //로그인 실패시 다이얼로그 띄움
            if(employee.isSelected())
            {
                AuthDTO dto = new AuthDTO(id.getText(),pw.getText());
                boolean r = controller.SubControllerEX("AUTH", 2, dto);
                if(r)
                {
                    loginmenu.setVisible(false);
                    Employee();
                }else
                {
                    JOptionPane.showMessageDialog(null, "로그인 실패");
                }

            }else if(member.isSelected())
            {
                AuthDTO dto = new AuthDTO(id.getText(),pw.getText());
                boolean r = controller.SubControllerEX("AUTH", 1, dto);
                if(r)
                {
                    loginmenu.setVisible(false);
                    Member();
                }else
                {
                    JOptionPane.showMessageDialog(null, "로그인 실패");
                }


            }



        }
        if(e.getSource() == exit) {
            System.out.println("종료 버튼 누름!");
            System.exit(-1);
        }

    }
}
