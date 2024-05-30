package com.devstack.lms.db;

import com.devstack.lms.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
