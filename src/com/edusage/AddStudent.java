package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener {
    JTextField nameTf, FNameTf, addressTf, phoneTf, emailTf, xTf, xiiTf, aadhaarTf;
    JLabel rollNoLbl;
    JDateChooser dateChooserDOB;
    JComboBox comboBoxCourse, comboBoxBranch;
    JButton submit, cancel;

    Random random = new Random();
    long first4 = Math.abs((random.nextLong() % 9000L)) + 1000L;

    AddStudent() {
        setSize(900,700);
        setLocation(350,70);

        setLayout(null);

        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(100,150,100,30);
        nameLbl.setFont(new Font("serif",Font.BOLD,20));
        add(nameLbl);

        nameTf = new JTextField();
        nameTf.setBounds(250,150,150,30);
        add(nameTf);

        JLabel FNameLbl = new JLabel("Father's Name");
        FNameLbl.setBounds(450,150,200,30);
        FNameLbl.setFont(new Font("serif",Font.BOLD,20));
        add(FNameLbl);

        FNameTf = new JTextField();
        FNameTf.setBounds(650,150,150,30);
        add(FNameTf);

        JLabel RollNoLbl = new JLabel("Roll Number");
        RollNoLbl.setBounds(100,200,200,30);
        RollNoLbl.setFont(new Font("serif",Font.BOLD,20));
        add(RollNoLbl);

        rollNoLbl = new JLabel("2024" + first4);
        rollNoLbl.setBounds(250,200,200,30);
        rollNoLbl.setFont(new Font("serif",Font.BOLD,20));
        add(rollNoLbl);

        JLabel DobLbl = new JLabel("Date of Birth");
        DobLbl.setBounds(450,200,200,30);
        DobLbl.setFont(new Font("serif",Font.BOLD,20));
        add(DobLbl);

        dateChooserDOB = new JDateChooser();
        dateChooserDOB.setBounds(650,200,150,30);
        add(dateChooserDOB);

        JLabel addressLbl = new JLabel("Address");
        addressLbl.setBounds(100,250,200,30);
        addressLbl.setFont(new Font("serif",Font.BOLD,20));
        add(addressLbl);

        addressTf = new JTextField();
        addressTf.setBounds(250,250,150,30);
        add(addressTf);

        JLabel phoneLbl = new JLabel("Phone Number");
        phoneLbl.setBounds(450,250,200,30);
        phoneLbl.setFont(new Font("serif",Font.BOLD,20));
        add(phoneLbl);

        phoneTf = new JTextField();
        phoneTf.setBounds(650,250,150,30);
        add(phoneTf);

        JLabel emailLbl = new JLabel("Email Id");
        emailLbl.setBounds(100,300,200,30);
        emailLbl.setFont(new Font("serif",Font.BOLD,20));
        add(emailLbl);

        emailTf = new JTextField();
        emailTf.setBounds(250,300,150,30);
        add(emailTf);

        JLabel xLbl = new JLabel("Class X(%)");
        xLbl.setBounds(450,300,200,30);
        xLbl.setFont(new Font("serif",Font.BOLD,20));
        add(xLbl);

        xTf = new JTextField();
        xTf.setBounds(650,300,150,30);
        add(xTf);

        JLabel xiiLbl = new JLabel("Class XII(%)");
        xiiLbl.setBounds(100,350,200,30);
        xiiLbl.setFont(new Font("serif",Font.BOLD,20));
        add(xiiLbl);

        xiiTf = new JTextField();
        xiiTf.setBounds(250,350,150,30);
        add(xiiTf);

        JLabel aadhaarLbl = new JLabel("Aadhaar Number");
        aadhaarLbl.setBounds(450,350,200,30);
        aadhaarLbl.setFont(new Font("serif",Font.BOLD,20));
        add(aadhaarLbl);

        aadhaarTf = new JTextField();
        aadhaarTf.setBounds(650,350,150,30);
        add(aadhaarTf);

        JLabel courseLbl = new JLabel("Course");
        courseLbl.setBounds(100,400,200,30);
        courseLbl.setFont(new Font("serif",Font.BOLD,20));
        add(courseLbl);

        String[] course = {"Select","B.Tech","BBA","BCA","Bsc","BA","Msc","MBA","MCA","MA"};

        comboBoxCourse = new JComboBox(course);
        comboBoxCourse.setBounds(250,400,150,30);
        comboBoxCourse.setBackground(Color.WHITE);
        add(comboBoxCourse);

        JLabel branchLbl = new JLabel("Branch");
        branchLbl.setBounds(450,400,200,30);
        branchLbl.setFont(new Font("serif",Font.BOLD,20));
        add(branchLbl);

        String[] branch = {"Select","Computer Science","ECE","Mechanical","Civil","IT","Msc"};

        comboBoxBranch = new JComboBox(branch);
        comboBoxBranch.setBounds(650,400,150,30);
        comboBoxBranch.setBackground(Color.WHITE);
        add(comboBoxBranch);

        submit = new JButton("Submit");
        submit.setBounds(300,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,15));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(500,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = nameTf.getText();
            String fName = FNameTf.getText();
            String rollNo = rollNoLbl.getText();
            String dob = ((JTextField) dateChooserDOB.getDateEditor().getUiComponent()).getText();
            //System.out.println(dob);
            String address = addressTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();
            String x = xTf.getText();
            String xii = xiiTf.getText();
            String aadhaar = aadhaarTf.getText();
            String course = (String) comboBoxCourse.getSelectedItem();
            String branch = (String) comboBoxBranch.getSelectedItem();

            try {
                String query = "insert into student values('"+name+"', '"+fName+"', '"+rollNo+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhaar+"', '"+course+"', '"+branch+"')";
                Connect connect = new Connect();
                connect.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
