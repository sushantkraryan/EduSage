package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{

    JTextField courseTf, addressTf, phoneTf, emailTf, branchTf;
    JLabel rollNoInputLbl;
    JButton submit, cancel;
    Choice rollNoChoice;

    UpdateStudent() {

        setSize(900, 650);
        setLocation(350, 50);

        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        add(heading);

        JLabel rollNoChoiceLbl = new JLabel("Select Roll Number");
        rollNoChoiceLbl.setBounds(50, 100, 200, 20);
        rollNoChoiceLbl.setFont(new Font("serif", Font.PLAIN, 20));
        add(rollNoChoiceLbl);

        rollNoChoice = new Choice();
        rollNoChoice.setBounds(250, 100, 200, 20);
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
        nameLbl.setBounds(50, 150, 100, 30);
        nameLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(nameLbl);

        JLabel nameInputLbl = new JLabel();
        nameInputLbl.setBounds(200, 150, 150, 30);
        nameInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(nameInputLbl);

        JLabel fNameLbl = new JLabel("Father's Name");
        fNameLbl.setBounds(400, 150, 200, 30);
        fNameLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(fNameLbl);

        JLabel fNameInputLbl = new JLabel();
        fNameInputLbl.setBounds(600, 150, 150, 30);
        fNameInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(fNameInputLbl);

        JLabel rollNoLbl = new JLabel("Roll Number");
        rollNoLbl.setBounds(50, 200, 200, 30);
        rollNoLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(rollNoLbl);

        rollNoInputLbl = new JLabel();
        rollNoInputLbl.setBounds(200, 200, 200, 30);
        rollNoInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(rollNoInputLbl);

        JLabel dobLbl = new JLabel("Date of Birth");
        dobLbl.setBounds(400, 200, 200, 30);
        dobLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(dobLbl);

        JLabel dobInputLbl = new JLabel();
        dobInputLbl.setBounds(600, 200, 150, 30);
        dobInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(dobInputLbl);

        JLabel addressLbl = new JLabel("Address");
        addressLbl.setBounds(50, 250, 200, 30);
        addressLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(addressLbl);

        addressTf = new JTextField();
        addressTf.setBounds(200, 250, 150, 30);
        add(addressTf);

        JLabel phoneLbl = new JLabel("Phone");
        phoneLbl.setBounds(400, 250, 200, 30);
        phoneLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(phoneLbl);

        phoneTf = new JTextField();
        phoneTf.setBounds(600, 250, 150, 30);
        add(phoneTf);

        JLabel emailLbl = new JLabel("Email Id");
        emailLbl.setBounds(50, 300, 200, 30);
        emailLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(emailLbl);

        emailTf = new JTextField();
        emailTf.setBounds(200, 300, 150, 30);
        add(emailTf);

        JLabel xLbl = new JLabel("Class X (%)");
        xLbl.setBounds(400, 300, 200, 30);
        xLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(xLbl);

        JLabel xInputLbl = new JLabel();
        xInputLbl.setBounds(600, 300, 150, 30);
        xInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(xInputLbl);

        JLabel xiiLbl = new JLabel("Class XII (%)");
        xiiLbl.setBounds(50, 350, 200, 30);
        xiiLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(xiiLbl);

        JLabel xiiInputLbl = new JLabel();
        xiiInputLbl.setBounds(200, 350, 150, 30);
        xiiInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(xiiInputLbl);

        JLabel aadhaarLbl = new JLabel("Aadhaar Number");
        aadhaarLbl.setBounds(400, 350, 200, 30);
        aadhaarLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(aadhaarLbl);

        JLabel aadhaarInputLbl = new JLabel();
        aadhaarInputLbl.setBounds(600, 350, 150, 30);
        aadhaarInputLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(aadhaarInputLbl);

        JLabel courseLbl = new JLabel("Course");
        courseLbl.setBounds(50, 400, 200, 30);
        courseLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(courseLbl);

        courseTf = new JTextField();
        courseTf.setBounds(200, 400, 150, 30);
        add(courseTf);

        JLabel branchLbl = new JLabel("Branch");
        branchLbl.setBounds(400, 400, 200, 30);
        branchLbl.setFont(new Font("serif", Font.BOLD, 20));
        add(branchLbl);

        branchTf = new JTextField();
        branchTf.setBounds(600, 400, 150, 30);
        add(branchTf);

        try {
            Connect connect = new Connect();
            String query = "select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'";
            ResultSet resultSet = connect.s.executeQuery(query);
            while(resultSet.next()) {
                nameInputLbl.setText(resultSet.getString("name"));
                fNameInputLbl.setText(resultSet.getString("fname"));
                dobInputLbl.setText(resultSet.getString("dob"));
                addressTf.setText(resultSet.getString("address"));
                phoneTf.setText(resultSet.getString("phone"));
                emailTf.setText(resultSet.getString("email"));
                xInputLbl.setText(resultSet.getString("x"));
                xiiInputLbl.setText(resultSet.getString("xii"));
                aadhaarInputLbl.setText(resultSet.getString("aadhaar"));
                rollNoInputLbl.setText(resultSet.getString("rollNo"));
                courseTf.setText(resultSet.getString("course"));
                branchTf.setText(resultSet.getString("branch"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        rollNoChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connect connect = new Connect();
                    String query = "select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'";
                    ResultSet rs = connect.s.executeQuery(query);
                    while(rs.next()) {
                        nameInputLbl.setText(rs.getString("name"));
                        fNameInputLbl.setText(rs.getString("fname"));
                        dobInputLbl.setText(rs.getString("dob"));
                        addressTf.setText(rs.getString("address"));
                        phoneTf.setText(rs.getString("phone"));
                        emailTf.setText(rs.getString("email"));
                        xInputLbl.setText(rs.getString("x"));
                        xiiInputLbl.setText(rs.getString("xii"));
                        aadhaarInputLbl.setText(rs.getString("aadhaar"));
                        rollNoInputLbl.setText(rs.getString("rollNo"));
                        courseTf.setText(rs.getString("course"));
                        branchTf.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
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
            String rollNo = rollNoInputLbl.getText();
            String address = addressTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();
            String course = courseTf.getText();
            String branch = branchTf.getText();

            try {
                String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', branch='"+branch+"' where rollNo='"+rollNo+"'";
                Connect connect = new Connect();
                connect.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
