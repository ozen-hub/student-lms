package com.devstack.lms.controller;

import com.devstack.lms.db.DatabaseAccessCode;
import com.devstack.lms.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.UUID;

public class SignupFormController {
    public AnchorPane context;
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void createNewAccountOnAction(ActionEvent actionEvent) {
        User user = new User(
                UUID.randomUUID().toString(),
                txtUsername.getText(),
                txtPassword.getText()
        );
        DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
        try {
            boolean isSaved = databaseAccessCode.signup(user);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Sign up process completed").show();
                URL resource = getClass().getResource("../view/LoginForm.fxml");
                Stage stage = (Stage) context.getScene().getWindow();
                stage.centerOnScreen();
                stage.setScene(new Scene(FXMLLoader.load(resource)));
                stage.setTitle("Login Form");
            } else {
                new Alert(Alert.AlertType.WARNING, "something went wrong, pleas try again a bit later..").show();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void navigateToLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle("Login Form");
    }
}
