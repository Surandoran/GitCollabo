package com.cosview.main;

import com.cosview.domain.DAO;
import com.cosview.view.ReviewView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class test extends JFrame implements ActionListener {
    JButton btn, btn2;
    JTextArea area;
    JScrollPane scroll;
    JPanel pan = new JPanel();
    test() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        scroll = new JScrollPane(area);
        btn = new JButton("테스트");
        btn.setBounds(10, 10, 50, 50);
        scroll.setBounds(30, 100, 300, 300);

        pan.add(btn);
        pan.add(scroll);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {

        }
    }

    public static void main(String[] args) {
        new test();

    }


}
