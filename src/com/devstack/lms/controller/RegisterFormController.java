package com.devstack.lms.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegisterFormController {
    public AnchorPane context;
    public Button btnSave;
    public TextField txtName;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public ComboBox cmbCourse;
    public ComboBox cmbStudent;
    public TextField txtEmail;

    public void registerOnAction(ActionEvent actionEvent) {
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }
}
