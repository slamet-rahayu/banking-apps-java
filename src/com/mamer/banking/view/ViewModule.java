package com.mamer.banking.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.Objects;

public class ViewModule {
    public Parent mainView;
    public Parent landingView;

    public ViewModule() throws Exception {
        mainView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main.fxml")));
        landingView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("landing.fxml")));
    }
}
