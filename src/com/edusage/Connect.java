package com.edusage;

import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;

public class Connect {
    private String jdbcUrl;
    private String username;
    private String password;
    Connection c;
    Statement s;
    Connect() {
        try {
            Properties env = new Properties();
            env.load(new FileInputStream(".env"));

            jdbcUrl = env.getProperty("DB_URL");
            username = env.getProperty("DB_USER");
            password = env.getProperty("DB_PASSWORD");

            Class.forName("com.mysql.cj.jdbc.Driver");

            c = DriverManager.getConnection(jdbcUrl,username,password);
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
