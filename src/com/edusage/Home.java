package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    Home() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setSize(width,height);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/campus.jpg"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar menuBar = new JMenuBar() {
            @Override
            public Dimension getPreferredSize() {
                Dimension originalSize = super.getPreferredSize();
                return new Dimension(originalSize.width, 30); // Set the height to 40 pixels
            }
        };

        //new information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        menuBar.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLUE);
        menuBar.add(details);

        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);

        JMenuItem studentDetails = new JMenuItem("View Student Details");
        studentDetails.setBackground(Color.WHITE);
        studentDetails.addActionListener(this);
        details.add(studentDetails);

        //leave
        JMenu leave = new JMenu("Leave");
        leave.setForeground(Color.BLUE);
        menuBar.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave = new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        menuBar.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //exam
        JMenu exam = new JMenu("Examinations");
        exam.setForeground(Color.BLUE);
        menuBar.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.WHITE);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);

        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLUE);
        menuBar.add(updateInfo);

        JMenuItem UpdateFacultyInfo = new JMenuItem("Update Faculty Details");
        UpdateFacultyInfo.setBackground(Color.WHITE);
        UpdateFacultyInfo.addActionListener(this);
        updateInfo.add(UpdateFacultyInfo);

        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.WHITE);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);

        // fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        menuBar.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        // Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        menuBar.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        // about
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        menuBar.add(about);

        JMenuItem abt = new JMenuItem("About");
        abt.setBackground(Color.WHITE);
        abt.addActionListener(this);
        about.add(abt);

        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        menuBar.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if (str.equals("Exit")) {
            setVisible(false);
        } else if (str.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (str.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (str.equals("New Faculty Information")) {
            new AddTeacher();
        } else if (str.equals("New Student Information")) {
            new AddStudent();
        } else if (str.equals("View Faculty Details")) {
            new TeacherDetails();
        } else if (str.equals("View Student Details")) {
            new StudentDetails();
        } else if (str.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (str.equals("Student Leave")) {
            new StudentLeave();
        } else if (str.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (str.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (str.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (str.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (str.equals("Enter Marks")) {
            new EnterMarks();
        } else if (str.equals("Examination Results")) {
            new ExamDetails();
        } else if (str.equals("About")) {
            new About();
        } else if (str.equals("Student Fee Form")) {
            new StudentFeeForm();
        } else if (str.equals("Fee Structure")) {
            new FeeStructure();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
