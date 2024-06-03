package com.devstack.lms.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CourseFormController {
    public AnchorPane context;
    public TextField txtCourseName;
    public Button btnSave;
    public TextField txtCourseFee;
    public TextField txtSearch;
    public TableView tblCourses;
    public TableColumn colCourseName;
    public TableColumn colCourseFee;
    public TableColumn colOption;

    public void saveCourseOnAction(ActionEvent actionEvent) {
    }

    public void btnBackToHomeOnAction(ActionEvent actionEvent) {
    }

    public void btnNewCourseOnAction(ActionEvent actionEvent) {
    }
}
