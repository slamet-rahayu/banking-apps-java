package com.mamer.banking.services;

import com.mamer.banking.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersServices extends DBConnection {

    private ArrayList<Map> arr;
    public UsersServices() {
        arr = new ArrayList<>();
    }

    public static void main(String[] args) {}

    public ArrayList<Map> getData() {
        final String[] column = {"name"};
        final String query = "select * from users";
        try {
            Statement stmt = connect().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Map<String, String> val = new HashMap<>();
                for (String col : column) {
                    val.put(col, rs.getString(col));
                }
                arr.add(val);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arr;

    }

    public int checkUser(String uname, String pwd) {
        try {
            final String query = "select id from users where username = ? and password = ?";
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setString(1, uname);
            stmt.setString(2, pwd);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
            res.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

}
