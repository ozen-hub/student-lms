package com.devstack.lms.controller;

import com.devstack.lms.db.DatabaseAccessCode;
import com.devstack.lms.model.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.util.UUID;

public class StudentFormController {

    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtAge;

    public void saveStudentOnAction(ActionEvent actionEvent) {

        Student student= new Student(
                UUID.randomUUID().toString(),
                txtName.getText().trim(),
                txtAddress.getText().trim(),
                txtEmail.getText().toLowerCase().trim(),
                Integer.parseInt(txtAge.getText())
        );
        DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
        boolean isSaved = databaseAccessCode.saveStudent(student);
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"Student has been saved..", ButtonType.CLOSE).show();
        }
    }
}
