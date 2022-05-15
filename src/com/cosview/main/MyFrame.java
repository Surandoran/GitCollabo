package com.cosview.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ForkJoinPool;
import com.cosview.view.EmployeeView;

public class MyFrame extends JFrame implements ActionListener {
    JComboBox comboBox;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"select","insert","update","delete"};

        comboBox = new JComboBox(animals);
        comboBox.addActionListener(this);

//        comboBox.setEditable(true);
//        System.out.println(comboBox.getItemCount());  //길이를 나타냄
//        comboBox.addItem("Test");     //마지막 자리에 Test추가
//        comboBox.insertItemAt("Pig", 0); //0번째 자리에 Pig 추가
//        comboBox.setSelectedIndex(0);       //0번쨰 index를 출력
//        comboBox.removeItem("insert"); //insert를 찾아 없앰
//        comboBox.removeItemAt(0); //0번째 index를 제거
//        comboBox.removeAllItems(); //모든 index제거

        this.add(comboBox);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == comboBox){
            System.out.println(comboBox.getSelectedItem());
            System.out.println(comboBox.getSelectedIndex());
            switch (comboBox.getSelectedIndex()){
                case 1:
                    System.out.println("응가");
            }
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
