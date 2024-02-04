package com.mamer.banking.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Paymentdetail implements Initializable {
    public TextArea alamatPengiriman;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        alamatPengiriman.disabledProperty();
        alamatPengiriman.setText("jl. in aja dulu");
    }
}
