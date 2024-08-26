package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice empIdChoice;
    JTable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Emp Id Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        empIdChoice = new Choice();
        empIdChoice.setBounds(180,20,150,20);
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

        table = new JTable();

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0,100,900,600);
        add(jScrollPane);

        try {
            Connect connect = new Connect();
            ResultSet resultSet = connect.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String query = "select * from teacher where impId = '"+empIdChoice.getSelectedItem()+"'";
            try {
                Connect connect = new Connect();
                ResultSet resultSet = connect.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddTeacher();
        } else if (e.getSource() == update) {
            setVisible(false);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
