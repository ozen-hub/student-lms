package com.devstack.lms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashboardFormController {
    public AnchorPane context;

    public void btnOpenStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentForm.fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle("Student Form");
    }
}
