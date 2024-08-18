package com.mamer.banking.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mamer.banking.db.H2Connection;
import com.mamer.banking.model.AuthModels;

public class AuthServices extends H2Connection {
    AuthModels authModels = new AuthModels();
    String model;
    String[] columns;

    public AuthServices() {
        model = authModels.table;
        columns = authModels.columns;
    }

    public static void main(String[] args) {

    }

    public int setLogin(String uname, int isLoggedIn) {
        try {
            final String query = "update "+model+" set "+columns[0]+" = ? where username = ?";
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setInt(1, isLoggedIn);
            stmt.setString(2, uname);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;

    }

    public boolean isLoggedIn() {
        try {
            final String query = "select isloggedin from auth";
            Statement stmt = connect().createStatement();
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return res.getBoolean(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
