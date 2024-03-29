package com.mamer.banking.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.Objects;

public class ViewModule {
    public Parent mainView;
    public Parent landingView;
    public Parent checkoutView;
    public Parent paymentDetailView;

    public ViewModule() throws Exception {
        mainView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        landingView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing.fxml")));
        checkoutView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("checkout.fxml")));
        paymentDetailView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("paymentdetail.fxml")));
    }
}
