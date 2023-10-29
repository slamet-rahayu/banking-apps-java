package com.mamer.banking.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mamer.banking.db.H2Connection;

public class AuthServices extends H2Connection {

    public int setLogin(String uname, int isLoggedIn) {
        try {
            final String query = "update auth set isloggedin = ? where username = ?";
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setInt(1, isLoggedIn);
            stmt.setString(2, uname);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;

    }

    public boolean isLoggedIn(String uname) {
        try {
            final String query = "select isloggedin from auth where username = ?";
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setString(1, uname);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                return res.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
