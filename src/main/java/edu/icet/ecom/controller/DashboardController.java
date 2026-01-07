package edu.icet.ecom.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {
    Stage stage = new Stage();
    public void btnCusPanelOnAction(ActionEvent actionEvent) throws IOException {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/customerPanel.fxml"))));
        stage.show();
    }
}
