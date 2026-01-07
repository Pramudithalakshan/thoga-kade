package edu.icet.ecom.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtUserName;
    Stage stage = new Stage();
    @FXML
    public void btnLoginOnClick(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml"))));
        stage.show();
    }
}
