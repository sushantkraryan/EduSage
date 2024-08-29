package com.edusage;

import javax.swing.*;
import java.awt.*;

import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {

    Choice rollNoChoice;
    JComboBox courseComboBox, branchComboBox, semesterComboBox;
    JLabel totalInputLbl;
    JButton update, pay, back;

    StudentFeeForm() {
        setSize(900, 500);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 300);
        add(image);

        JLabel rollNoLbl = new JLabel("Select Roll No");
        rollNoLbl.setBounds(40, 60, 150, 20);
        rollNoLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(rollNoLbl);

        rollNoChoice = new Choice();
        rollNoChoice.setBounds(200, 60, 150, 20);
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

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(40, 100, 150, 20);
        nameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(nameLbl);

        JLabel nameInputLbl = new JLabel();
        nameInputLbl.setBounds(200, 100, 150, 20);
        nameInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameInputLbl);

        JLabel fNameLbl = new JLabel("Father's Name");
        fNameLbl.setBounds(40, 140, 150, 20);
        fNameLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(fNameLbl);

        JLabel fNameInputLbl = new JLabel();
        fNameInputLbl.setBounds(200, 140, 150, 20);
        fNameInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(fNameInputLbl);

        try {
            Connect connect = new Connect();
            String query = "select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'";
            ResultSet resultSet = connect.s.executeQuery(query);
            while(resultSet.next()) {
                nameInputLbl.setText(resultSet.getString("name"));
                fNameInputLbl.setText(resultSet.getString("fName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rollNoChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect connect = new Connect();
                    String query = "select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'";
                    ResultSet resultSet = connect.s.executeQuery(query);
                    while(resultSet.next()) {
                        nameInputLbl.setText(resultSet.getString("name"));
                        fNameInputLbl.setText(resultSet.getString("fName"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel courseLbl = new JLabel("Course");
        courseLbl.setBounds(40, 180, 150, 20);
        courseLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(courseLbl);

        String[] course = {"BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        courseComboBox = new JComboBox(course);
        courseComboBox.setBounds(200, 180, 150, 20);
        courseComboBox.setBackground(Color.WHITE);
        add(courseComboBox);

        JLabel branchLbl = new JLabel("Branch");
        branchLbl.setBounds(40, 220, 150, 20);
        branchLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(branchLbl);

        String[] branch = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        branchComboBox = new JComboBox(branch);
        branchComboBox.setBounds(200, 220, 150, 20);
        branchComboBox.setBackground(Color.WHITE);
        add(branchComboBox);

        JLabel semesterLbl = new JLabel("Semester");
        semesterLbl.setBounds(40, 260, 150, 20);
        semesterLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(semesterLbl);

        String[] semester = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8" };
        semesterComboBox = new JComboBox(semester);
        semesterComboBox.setBounds(200, 260, 150, 20);
        semesterComboBox.setBackground(Color.WHITE);
        add(semesterComboBox);

        JLabel totalLbl = new JLabel("Total Payable");
        totalLbl.setBounds(40, 300, 150, 20);
        totalLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(totalLbl);

        totalInputLbl = new JLabel();
        totalInputLbl.setBounds(200, 300, 150, 20);
        totalInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(totalInputLbl);

        update = new JButton("Update");
        update.setBounds(30, 380, 100, 25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150, 380, 100, 25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(pay);

        back = new JButton("Back");
        back.setBounds(270, 380, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String course = (String) courseComboBox.getSelectedItem();
            String semester = (String) semesterComboBox.getSelectedItem();
            try {
                Connect connect = new Connect();
                ResultSet resultSet = connect.s.executeQuery("select * from fee where course = '"+course+"'");
                while(resultSet.next()) {
                    totalInputLbl.setText(resultSet.getString(semester));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == pay) {
            String rollNo = rollNoChoice.getSelectedItem();
            String course = (String) courseComboBox.getSelectedItem();
            String semester = (String) semesterComboBox.getSelectedItem();
            String branch = (String) branchComboBox.getSelectedItem();
            String total = totalInputLbl.getText();

            try {
                Connect connect = new Connect();

                String query = "insert into fee values('"+rollNo+"', '"+course+"', '"+branch+"', '"+semester+"', '"+total+"')";
                connect.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}
