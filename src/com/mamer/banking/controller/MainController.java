package com.mamer.banking.controller;

import com.mamer.banking.view.ViewModule;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.mamer.banking.services.UsersServices;
import com.mamer.banking.services.AuthServices;
import com.mamer.banking.Main;
import javafx.stage.Stage;

public class MainController {
    public Label errMsg;
    public TextField Username;
    public PasswordField Password;
    private final UsersServices usersServices = new UsersServices();
    private final AuthServices authServices = new AuthServices();
    private final Main main = new Main();

    public MainController() throws Exception {
    }

    private String validate(String uname, String pwd) {
        if (uname.equals("") && pwd.equals("")) {
            return "Username or password cannot be empty!";
        }
        return "OK";
    }

    @FXML
    public void onLogin() throws Exception {
        final ViewModule viewModule = new ViewModule();
        String uname = Username.getText();
        String pwd = Password.getText();
        String valid = validate(uname, pwd);
        Stage stage = new Stage();
        errMsg.setText("");
        errMsg.setVisible(false);
        if (valid.equals("OK")) {
            int useExist = usersServices.checkUser(uname, pwd);
            if (useExist == 1) {
                int loginSuccess = authServices.setLogin(uname, 1);
                if (loginSuccess == 1) {
                    stage.setScene(new Scene(viewModule.landingView));
                    stage.show();
                    main.getStage().close();
                }
            } else {
                String ERR_UNAME = "Invalid username or password!";
                errMsg.setText(ERR_UNAME);
                errMsg.setVisible(true);
            }
        } else {
            errMsg.setText(valid);
            errMsg.setVisible(true);
        }
    }

}
