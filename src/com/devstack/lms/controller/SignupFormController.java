package com.devstack.lms.controller;

import com.devstack.lms.business.BoFactory;
import com.devstack.lms.business.custom.UserBo;
import com.devstack.lms.dto.UserDto;
import com.devstack.lms.entity.User;
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

    private final UserBo userBo= BoFactory.getBo(BoFactory.BoType.USER);

    public void createNewAccountOnAction(ActionEvent actionEvent) {
        UserDto user = new UserDto(
                UUID.randomUUID().toString(),
                txtUsername.getText(),
                txtPassword.getText()
        );
        try {
            boolean isSaved = userBo.create(user);
            if (isSaved) {
                setUi("LoginForm");
            } else {
                new Alert(Alert.AlertType.WARNING, "something went wrong, pleas try again a bit later..").show();
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    public void navigateToLoginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("../view/" + location + ".fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle(location);
    }
}
