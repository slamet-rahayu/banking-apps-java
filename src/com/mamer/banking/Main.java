package com.mamer.banking;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mamer.banking.view.ViewModule;

public class Main extends Application {

    private static Stage stage;

    public Main() {}

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        final ViewModule viewModule = new ViewModule();
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(viewModule.mainView, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }

    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
