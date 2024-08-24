package com.edusage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,cancel;
    JTextField usernameTf,passwordF;

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(40,20,100,20);
        add(usernameLabel);

        usernameTf = new JTextField();
        usernameTf.setBounds(150,20,150,20);
        add(usernameTf);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40,70,100,20);
        add(passwordLabel);

        passwordF = new JPasswordField();
        passwordF.setBounds(150,70,150,20);
        add(passwordF);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("serif",Font.BOLD,15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = usernameTf.getText();
            String password = passwordF.getText();

            String query = "Select * from login where username='" + username + "' and password='" + password + "'";
            try {
                Connect c = new Connect();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception ex) {
                ex.fillInStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
