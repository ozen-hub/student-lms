package com.devstack.lms.controller;

import com.devstack.lms.db.DatabaseAccessCode;
import com.devstack.lms.model.Student;
import com.devstack.lms.view.tm.StudentTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class StudentFormController {

    public TextField txtName;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtAge;

    public TableView<StudentTM> tblStudents;
    public TableColumn<StudentTM,String> colName;
    public TableColumn<StudentTM,String>  colAddress;
    public TableColumn<StudentTM,Integer>  colAge;
    public TableColumn<StudentTM,String>  colEmail;
    public TableColumn<StudentTM,ButtonBar>  colOption;

    private String searchText="";

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("bar"));

        loadAllStudents();
    }

    private void loadAllStudents() {

        ObservableList<StudentTM> tmObservableList= FXCollections.observableArrayList();

        try {
            DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();

            List<Student> allStudents =
                    databaseAccessCode.findAllStudents(searchText);

            for(Student s:allStudents){

                ButtonBar bar = new ButtonBar();
                Button deleteButton = new Button("Delete");
                Button updateButton = new Button("Update");
                bar.getButtons().addAll(deleteButton,updateButton);

                StudentTM tm = new StudentTM(
                        s.getStudentId(),
                        s.getStudentName(),
                        s.getAddress(),
                        s.getEmail(),
                        s.getAge(),
                        bar
                );
                tmObservableList.add(tm);
            }

            tblStudents.setItems(tmObservableList);

        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    public void saveStudentOnAction(ActionEvent actionEvent) {

        try {
            Student student = new Student(
                    UUID.randomUUID().toString(),
                    txtName.getText().trim(),
                    txtAddress.getText().trim(),
                    txtEmail.getText().toLowerCase().trim(),
                    Integer.parseInt(txtAge.getText())
            );
            DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
            boolean isSaved = databaseAccessCode.saveStudent(student);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Student has been saved..", ButtonType.CLOSE).show();
                clearFields();
                loadAllStudents();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).show();
        }
    }

    private void clearFields(){
        txtName.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtAge.clear();
    }

}
