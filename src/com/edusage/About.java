package com.edusage;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    About() {
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("EduSage");
        heading.setBounds(250, 20, 500, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel projectName = new JLabel("(University Management System)");
        projectName.setBounds(70, 110, 520, 70);
        projectName.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(projectName);

        JLabel name = new JLabel("Developed By: Kumar Aryan");
        name.setBounds(70, 200, 550, 40);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);

        JLabel education = new JLabel("BTech CSE'23");
        education.setBounds(70, 260, 550, 40);
        education.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(education);

        JLabel contact = new JLabel("Contact: sushantkraryan@gmail.com");
        contact.setBounds(70, 320, 550, 40);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);

        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }
}
