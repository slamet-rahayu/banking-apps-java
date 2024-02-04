package com.mamer.banking.controller;

import com.mamer.banking.services.ProductServices;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;

public class LandingController implements Initializable {

    public GridPane grid;
    public ProductServices productServices = new ProductServices();

    public VBox productBox(String pTitle, String pPrice, String pStock) {
        VBox vbox =  new VBox();

        vbox.setStyle("" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 8px;" +
                "");

        Label title = new Label();
        Label price = new Label();
        Label stock = new Label();
        Button buyButton = new Button();

        title.setText(pTitle);
        price.setText(pPrice);
        stock.setText(pStock);
        buyButton.setText("Buy");

        vbox.getChildren().add(title);
        vbox.getChildren().add(price);
        vbox.getChildren().add(stock);
        vbox.getChildren().add(buyButton);

        return vbox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Map<String, String>> products = productServices.getProducts();
        grid.setHgap(20);
        int hIdx = 0;
        int vIdx = 0;
        for (Map<String, String> prod : products) {
            String title = prod.get("name");
            String price = "Rp."+prod.get("price");
            String stock = "Stock: "+prod.get("stock");
            grid.add(productBox(title, price, stock), hIdx%5, vIdx);
            hIdx++;
            if(hIdx%5 == 0) {
                vIdx += 2;
            }
        }

    }
}
