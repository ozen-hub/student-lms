package com.devstack.lms.view.tm;

import javafx.scene.control.ButtonBar;

public class StudentTM {
    private String studentId;
    private String studentName;
    private String address;
    private String email;
    private int age;
    private ButtonBar bar;

    public StudentTM() {
    }

    public StudentTM(String studentId, String studentName, String address, String email, int age, ButtonBar bar) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.email = email;
        this.age = age;
        this.bar = bar;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ButtonBar getBar() {
        return bar;
    }

    public void setBar(ButtonBar bar) {
        this.bar = bar;
    }
}
