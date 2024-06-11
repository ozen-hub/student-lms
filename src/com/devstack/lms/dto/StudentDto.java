package com.devstack.lms.dto;

public class StudentDto {
    private String studentId;
    private String studentName;
    private String address;
    private String email;
    private int age;

    public StudentDto() {
    }

    public StudentDto(String studentId, String studentName, String address, String email, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.email = email;
        this.age = age;
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
}
