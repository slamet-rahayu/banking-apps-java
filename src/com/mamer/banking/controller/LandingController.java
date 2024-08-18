package com.mamer.banking.controller;

import com.mamer.banking.services.ProductServices;
import com.mamer.banking.services.StateService;
import com.mamer.banking.view.ViewModule;


import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import com.mamer.banking.Main;

public class LandingController implements Initializable {

    public GridPane grid;
    public ProductServices productServices = new ProductServices();
    public StateService stateService = new StateService();

    public LandingController() throws Exception {

    }

    private final Main main = new Main();

    public VBox productBox(String id, String pTitle, String pPrice, String pStock) {
        VBox vbox =  new VBox();

        vbox.setStyle("-fx-border-color: black;" +
                "-fx-border-radius: 10px;" +
                "-fx-padding: 8px;");

        Label title = new Label();
        Label price = new Label();
        Label stock = new Label();
        Button buyButton = new Button();

        title.setText(pTitle);
        price.setText(pPrice);
        stock.setText(pStock);
        buyButton.setText("Buy");
        buyButton.setOnAction(actionEvent -> {
            try {
                buyProduct(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        vbox.getChildren().add(title);
        vbox.getChildren().add(price);
        vbox.getChildren().add(stock);
        vbox.getChildren().add(buyButton);

        return vbox;
    }

    void buyProduct(String id) throws Exception {
        final ViewModule viewModule = new ViewModule();
        Stage stage = new Stage();
        stage.setScene(new Scene(viewModule.checkoutView));
        stage.show();
        main.getStage().close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Map<String, String>> products = productServices.getProducts();
        grid.setHgap(20);
        int hIdx = 0;
        int vIdx = 0;
        for (Map<String, String> prod : products) {
            String id = prod.get("id");
            String title = prod.get("name");
            String price = "Rp."+prod.get("price");
            String stock = "Stock: "+prod.get("stock");
            grid.add(productBox(id, title, price, stock), hIdx%5, vIdx);
            hIdx++;
            if(hIdx%5 == 0) {
                vIdx += 2;
            }
        }

    }
}
