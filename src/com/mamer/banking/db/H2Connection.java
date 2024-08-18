package com.mamer.banking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {
    public static void main(String[] args) {}

    public Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:h2:~/test";
            String uname = "sa";
            String pwd = "sa";
            conn = DriverManager.getConnection(url, uname, pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
