package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {

    Choice rollNoChoice;
    JComboBox semesterComboBox;
    JTextField sub1Tf, sub2Tf,sub3Tf,sub4Tf,sub5Tf,marks1Tf,marks2Tf,marks3Tf,marks4Tf,marks5Tf;
    JButton cancel, submit;

    EnterMarks() {

        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel rollNoLbl = new JLabel("Select Roll Number");
        rollNoLbl.setBounds(50, 70, 150, 20);
        add(rollNoLbl);

        rollNoChoice = new Choice();
        rollNoChoice.setBounds(200, 70, 150, 20);
        add(rollNoChoice);

        try {
            Connect connect = new Connect();
            ResultSet resultSet = connect.s.executeQuery("select * from student");
            while(resultSet.next()) {
                rollNoChoice.add(resultSet.getString("rollNo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel semesterLbl = new JLabel("Select Semester");
        semesterLbl.setBounds(50, 110, 150, 20);
        add(semesterLbl);

        String[] semester = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        semesterComboBox = new JComboBox(semester);
        semesterComboBox.setBounds(200, 110, 150, 20);
        semesterComboBox.setBackground(Color.WHITE);
        add(semesterComboBox);

        JLabel enterSubjectLbl = new JLabel("Enter Subject");
        enterSubjectLbl.setBounds(100, 150, 200, 40);
        add(enterSubjectLbl);

        JLabel enterMarksLbl = new JLabel("Enter Marks");
        enterMarksLbl.setBounds(320, 150, 200, 40);
        add(enterMarksLbl);

        sub1Tf = new JTextField();
        sub1Tf.setBounds(50, 200, 200, 20);
        add(sub1Tf);

        sub2Tf = new JTextField();
        sub2Tf.setBounds(50, 230, 200, 20);
        add(sub2Tf);

        sub3Tf = new JTextField();
        sub3Tf.setBounds(50, 260, 200, 20);
        add(sub3Tf);

        sub4Tf = new JTextField();
        sub4Tf.setBounds(50, 290, 200, 20);
        add(sub4Tf);

        sub5Tf = new JTextField();
        sub5Tf.setBounds(50, 320, 200, 20);
        add(sub5Tf);

        marks1Tf = new JTextField();
        marks1Tf.setBounds(250, 200, 200, 20);
        add(marks1Tf);

        marks2Tf = new JTextField();
        marks2Tf.setBounds(250, 230, 200, 20);
        add(marks2Tf);

        marks3Tf = new JTextField();
        marks3Tf.setBounds(250, 260, 200, 20);
        add(marks3Tf);

        marks4Tf = new JTextField();
        marks4Tf.setBounds(250, 290, 200, 20);
        add(marks4Tf);

        marks5Tf = new JTextField();
        marks5Tf.setBounds(250, 320, 200, 20);
        add(marks5Tf);

        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Connect connect = new Connect();

                String query1 = "insert into subject values('"+rollNoChoice.getSelectedItem()+"', '"+semesterComboBox.getSelectedItem()+"', '"+sub1Tf.getText()+"', '"+sub2Tf.getText()+"', '"+sub3Tf.getText()+"', '"+sub4Tf.getText()+"', '"+sub5Tf.getText()+"')";
                String query2 = "insert into marks values('"+rollNoChoice.getSelectedItem()+"', '"+semesterComboBox.getSelectedItem()+"', '"+marks1Tf.getText()+"', '"+marks2Tf.getText()+"', '"+marks3Tf.getText()+"', '"+marks4Tf.getText()+"', '"+marks5Tf.getText()+"')";

                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
