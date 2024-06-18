package com.devstack.lms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DashboardFormController {
    public AnchorPane context;

    public void btnOpenStudentFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StudentForm");
    }

    private void setUi(String location) throws IOException {
        URL resource = getClass().getResource("../view/" + location + ".fxml");
        Stage stage = (Stage) context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(new Scene(FXMLLoader.load(resource)));
        stage.setTitle(location);
    }

    public void btnOpenCourseFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseForm");
    }

    public void btnOpenRegistrationFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("RegisterForm");
    }

    public void makeDumpFileOnAction(ActionEvent actionEvent) {
        try{
            String uuid= UUID.randomUUID().toString();
            String date= new SimpleDateFormat("yyyyMMdd").format(new Date());

            String fileName = "backup_"+uuid+"_"+date+".sql";

            String path = "C:\\Users\\User\\Desktop\\DSMP\\Intake-3\\se-system\\lms\\mysqldump.exe";

            String command = String.format("%s -h %s -P %s -u %s -p%s %s -r %s",
                    path,"localhost","3306","root","1234","devstack_lms",fileName);

            Process process = Runtime.getRuntime().exec(command);

            int processState = process.waitFor();
            if(processState==0){
                System.out.println("success!.. -> "+fileName);
            }else{
                System.out.println("try Again");
            }
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }


    }
}
