package com.edusage;

import java.awt.*;
import javax.swing.*;
import java.net.ConnectException;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollNo;
    JButton cancel;

    Marks(String rollNo) {
        this.rollNo = rollNo;

        setSize(500, 600);
        setLocation(500, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Aryan Technical University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 20XX");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel rollNoLbl = new JLabel("Roll Number " + rollNo);
        rollNoLbl.setBounds(130, 100, 500, 20);
        rollNoLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(rollNoLbl);

        JLabel semesterLbl = new JLabel();
        semesterLbl.setBounds(130, 130, 500, 20);
        semesterLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(semesterLbl);

        JLabel sub1 = new JLabel();
        sub1.setBounds(150, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(150, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(150, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(150, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(150, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);

        try {
            Connect connect = new Connect();

            ResultSet rs1 = connect.s.executeQuery("select * from subject where rollNo = '"+rollNo+"'");
            while(rs1.next()) {
                sub1.setText(rs1.getString("sub1"));
                sub2.setText(rs1.getString("sub2"));
                sub3.setText(rs1.getString("sub3"));
                sub4.setText(rs1.getString("sub4"));
                sub5.setText(rs1.getString("sub5"));
            }

            ResultSet rs2 = connect.s.executeQuery("select * from marks where rollNo = '"+rollNo+"'");
            while(rs2.next()) {
                sub1.setText(sub1.getText() + "------------>" + rs2.getString("marks1"));
                sub2.setText(sub2.getText() + "------------>" + rs2.getString("marks2"));
                sub3.setText(sub3.getText() + "------------>" + rs2.getString("marks3"));
                sub4.setText(sub4.getText() + "------------>" + rs2.getString("marks4"));
                sub5.setText(sub5.getText() + "------------>" + rs2.getString("marks5"));
                semesterLbl.setText("Semester: " + rs2.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Marks("");
    }
}
