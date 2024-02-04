package com.mamer.banking.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Checkout implements Initializable {

    public VBox vbox;
    public ChoiceBox deliveryChoice;

    private final ArrayList<String> deliveryList = new ArrayList<>();

    public Checkout() {
        deliveryList.add("JNE Regular: Rp12000");
        deliveryList.add("JNE Next Day: Rp18000");
        deliveryList.add("Gosend Instant: Rp22000");
        deliveryList.add("Gosend Sameday: Rp42000");
    }

    public VBox product() {
        VBox productBox = new VBox();

        HBox btnBox = new HBox();

        productBox.setStyle("" +
                "-fx-border-color: black;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 8px;" +
                "");

        Label title = new Label();
        Label price = new Label();
        Label qty = new Label();
        Button btnInc = new Button();
        Button btnDec = new Button();

        title.setText("GuavaBerry");
        price.setText("Rp10.000");
        qty.setText("10");

        btnInc.setText("+");
        btnDec.setText("-");

        productBox.getChildren().add(title);
        productBox.getChildren().add(price);

        btnBox.getChildren().add(btnDec);
        btnBox.getChildren().add(qty);
        btnBox.getChildren().add(btnInc);

        productBox.getChildren().add(btnBox);

        return productBox;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vbox.setSpacing(10);
        for (int i = 0; i < 3; i++) {
            vbox.getChildren().add(product());
        }

        for (String delivery: deliveryList) {
            deliveryChoice.getItems().add(delivery);
        }
    }
}
