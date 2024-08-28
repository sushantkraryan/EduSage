package com.edusage;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherLeave extends JFrame implements ActionListener {

    Choice empIdChoice, timeChoice;
    JDateChooser dateChooserDate;
    JButton submit, cancel;

    TeacherLeave() {

        setSize(500,550);
        setLocation(500,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel empIdLbl = new JLabel("Search by Employee Id");
        empIdLbl.setBounds(60,100,200,20);
        empIdLbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(empIdLbl);

        empIdChoice = new Choice();
        empIdChoice.setBounds(60,130,200,20);
        add(empIdChoice);

        try {
            Connect connect = new Connect();
            ResultSet resultSet = connect.s.executeQuery("select * from teacher");
            while(resultSet.next()) {
                empIdChoice.add(resultSet.getString("impId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel dateLbl = new JLabel("Date");
        dateLbl.setBounds(60,180,200,20);
        dateLbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dateLbl);

        dateChooserDate = new JDateChooser();
        dateChooserDate.setBounds(60,210,200,30);
        add(dateChooserDate);

        JLabel timeLbl = new JLabel("Time Duration");
        timeLbl.setBounds(60,260,200,20);
        timeLbl.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(timeLbl);

        timeChoice = new Choice();
        timeChoice.setBounds(60,290,200,20);
        timeChoice.add("Full Day");
        timeChoice.add("Half Day");
        add(timeChoice);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String empId = empIdChoice.getSelectedItem();
            String date = ((JTextField) dateChooserDate.getDateEditor().getUiComponent()).getText();
            String duration = timeChoice.getSelectedItem();

            String query = "insert into teacherleave values('"+empId+"', '"+date+"', '"+duration+"')";

            try {
                Connect connect = new Connect();
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Submitted");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
