package com.devstack.lms.controller;

import com.devstack.lms.entity.Course;
import com.devstack.lms.entity.Registration;
import com.devstack.lms.entity.Student;
import com.devstack.lms.util.PaymentType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

public class RegisterFormController {
    public AnchorPane context;
    public Button btnSave;
    public TextField txtName;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public ComboBox<String> cmbCourse;
    public ComboBox<String> cmbStudent;
    public TextField txtEmail;
    public RadioButton rBtnCash;

    private Student selectedStudent;
    private Course selectedCourse;

    public void initialize(){
        loadAllCourses();
        loadAllStudents();

        /*============*/
        cmbCourse.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue!=null){
                        setCourseDetails(newValue);
                    }
        });

        cmbStudent.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null){
                        setStudentDetails(newValue);
                    }
                });
        /*============*/

    }

    private void setStudentDetails(String newValue) {
        String[] splitData = newValue.split("\\|");
        String studentId=splitData[0].trim();

        try {
            DatabaseAccessCode databaseAccessCode
                    = new DatabaseAccessCode();
            selectedStudent = databaseAccessCode.findStudent(studentId);
            if (selectedStudent==null){
                new Alert(Alert.AlertType.WARNING,"Student not found...");
                return;
            }

            txtName.setText(selectedStudent.getStudentName());
            txtEmail.setText(selectedStudent.getEmail());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    ObservableList<String> studentObList = null;
    private void loadAllStudents() {
        try{
            DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
            studentObList = FXCollections.observableArrayList(databaseAccessCode.findAllStudents("")
                    .stream().map(e->e.getStudentId()+" | "+e.getStudentName()).collect(Collectors.toList()));
            cmbStudent.setItems(studentObList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setCourseDetails(String newValue) {
        String[] splitData = newValue.split("\\|");
        String courseId=splitData[0].trim();

        try {
            DatabaseAccessCode databaseAccessCode
                    = new DatabaseAccessCode();
            selectedCourse = databaseAccessCode.findCourse(courseId);
            if (selectedCourse==null){
                new Alert(Alert.AlertType.WARNING,"Course not found...");
                return;
            }

            txtCourseName.setText(selectedCourse.getCourseName());
            txtCourseFee.setText(String.valueOf(selectedCourse.getFee()));

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    ObservableList<String> courseObList = null;
    private void loadAllCourses() {
        try{
            DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
            courseObList = FXCollections.observableArrayList(databaseAccessCode.findAllCourses()
                    .stream().map(e->e.getCourseId()+" | "+e.getCourseName()).collect(Collectors.toList()));
            cmbCourse.setItems(courseObList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {

        if(selectedCourse==null || selectedStudent==null){
            new Alert(Alert.AlertType.WARNING,"please return to home and come back... or try after choose potential data").show();
            return;
        }

        try {
            Registration registration =
                    new Registration(
                            UUID.randomUUID().toString(),
                            new Date(),
                            null,
                            rBtnCash.isSelected()? PaymentType.CASH:PaymentType.CARD,
                            selectedStudent.getStudentId(),
                            selectedCourse.getCourseId());
            DatabaseAccessCode databaseAccessCode = new DatabaseAccessCode();
            boolean isSaved = databaseAccessCode.register(registration);
            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "registration was successful..", ButtonType.CLOSE).show();
                clearFields();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.CLOSE).show();
        }

    }

    private void clearFields() {
        cmbCourse.setValue(null);
        cmbStudent.setValue(null);

        txtEmail.clear();
        txtName.clear();
        txtCourseFee.clear();
        txtCourseName.clear();

        selectedStudent=null;
        selectedCourse=null;
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("../view/" + location + ".fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle(location);
    }
}
