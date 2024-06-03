package com.devstack.lms.controller;

import com.devstack.lms.db.DatabaseAccessCode;
import com.devstack.lms.model.Course;
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
import java.util.List;
import java.util.stream.Collectors;

public class RegisterFormController {
    public AnchorPane context;
    public Button btnSave;
    public TextField txtName;
    public TextField txtCourseName;
    public TextField txtCourseFee;
    public ComboBox<String> cmbCourse;
    public ComboBox cmbStudent;
    public TextField txtEmail;
    public RadioButton rBtnCash;

    public void initialize(){
        loadAllCourses();

        /*============*/
        cmbCourse.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    setCourseDetails(newValue);
        });
        /*============*/

    }

    private void setCourseDetails(String newValue) {
        String[] splitData = newValue.split("\\|");
        String courseId=splitData[0].trim();

        try {
            DatabaseAccessCode databaseAccessCode
                    = new DatabaseAccessCode();
            Course course = databaseAccessCode.findCourse(courseId);
            if (course==null){
                new Alert(Alert.AlertType.WARNING,"Student not found...");
                return;
            }

            txtCourseName.setText(course.getCourseName());
            txtCourseFee.setText(String.valueOf(course.getFee()));

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
        setUi("DashboardForm");
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("../view/" + location + ".fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle(location);
    }
}
