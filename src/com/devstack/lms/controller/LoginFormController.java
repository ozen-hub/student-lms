package com.devstack.lms.controller;


import com.devstack.lms.db.DatabaseAccessCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void openDashboardFormOnAction(ActionEvent actionEvent) throws IOException {
        DatabaseAccessCode databaseAccessCode= new DatabaseAccessCode();
        try {
            boolean isLoggedIn = databaseAccessCode.login(
                    txtUsername.getText(),
                    txtPassword.getText()
            );

            if(isLoggedIn){
                System.out.println("Logged..");
            }else{
                System.out.println("Try Again..");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


      /*  URL resource = getClass().getResource("../view/DashboardForm.fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle("Dashboard");*/
    }

    public void navigateToRegisterFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SignupForm.fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle("Sign Up Form");
    }
}
