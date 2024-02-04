package com.mamer.banking.services;
import com.mamer.banking.db.DBConnection;
import com.mamer.banking.model.ProductModels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductServices {
    private final DBConnection dbConnection;
    private final ProductModels productModels;

    public ProductServices() {
        dbConnection = new DBConnection();
        productModels = new ProductModels();
    }

    public ArrayList<Map<String, String>> getProducts() {
        String[] columns = productModels.columns;
        String table = productModels.table;
        final String query = "select * from " + table;
        final ArrayList<Map<String, String>> products = new ArrayList<>();
        try {
            Statement stmt = dbConnection.connect().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Map<String, String> val = new HashMap<>();
                for (String col : columns) {
                    val.put(col, rs.getString(col));
                }
                products.add(val);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static void main(String[] args) {
        ProductServices productServices = new ProductServices();
        System.out.println(productServices.getProducts());
    }
}
