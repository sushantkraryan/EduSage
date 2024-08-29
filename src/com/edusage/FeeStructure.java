package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    FeeStructure() {
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();

        try {
            Connect connect = new Connect();
            ResultSet resultSet = connect.s.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 60, 1000, 700);
        add(jScrollPane);

        setVisible(true);

    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
