package com.mamer.banking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static void main(String[] args) {}

    public Connection connect() {
        Connection conn = null;
        try {
            String jdbcURL = "jdbc:postgresql://localhost:5432/java_banking_apps";
            String password = "jenengmu";
            String username = "postgres";
            conn = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;

    }
}
