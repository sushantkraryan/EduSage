package com.edusage;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {

    Thread t;

    Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();

        setLocation(250, 50);
        setVisible(true);

        int startWidth = 100;
        int startHeight = 70;

        int endWidth = 1000;
        int endHeight = 700;

        setSize(startWidth, startHeight);

        for (int i = 0; i <= 100; i++) {
            int width = startWidth + (endWidth - startWidth) * i / 100;
            int height = startHeight + (endHeight - startHeight) * i / 100;
            setSize(width, height);

            try {
                Thread.sleep(10); // Delay in milliseconds between each step
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setSize(endWidth, endHeight);
    }

    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);

            new Login();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
