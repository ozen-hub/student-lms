package com.devstack.lms.db;

import com.devstack.lms.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {

    public boolean saveStudent(Student student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql="INSERT INTO student VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getStudentId());
        preparedStatement.setString(2,student.getStudentName());
        preparedStatement.setString(3,student.getAddress());
        preparedStatement.setInt(4,student.getAge());
        preparedStatement.setString(5,student.getEmail());

        int affectedRowCount = preparedStatement.executeUpdate();

        if(affectedRowCount>0){
          return true;
        }
        return false;
    }

    public List<Student> findAllStudents(String searchText) throws ClassNotFoundException, SQLException {
        searchText="%"+searchText+"%";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql="SELECT * FROM student WHERE student_name LIKE ? OR email LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,searchText);
        preparedStatement.setString(2,searchText);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()){
            studentList.add(new Student(
                    resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(5),
                    resultSet.getInt(4)
            ));
        }
        return studentList;
    }
}
