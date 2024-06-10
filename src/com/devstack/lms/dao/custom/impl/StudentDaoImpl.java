package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.CrudUtil;
import com.devstack.lms.dao.custom.StudentDao;
import com.devstack.lms.db.DbConnection;
import com.devstack.lms.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean create(Student student) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO student VALUES(?,?,?,?,?)",
                student.getStudentId(),student.getStudentName(),student.getAddress(), student.getAge(),student.getEmail());
    }

    @Override
    public Student find(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM student WHERE student_id=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, s);

        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(5),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE student SET student_name=?, address=?, age=?,email=? WHERE student_id=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, student.getStudentName());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getStudentId());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM student WHERE student_id=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, s);

        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public List<Student> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Student> search(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";

        String sql = "SELECT * FROM student WHERE student_name LIKE ? OR email LIKE ?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, searchText);
        preparedStatement.setString(2, searchText);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            studentList.add(new Student(
                    resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(5),
                    resultSet.getInt(4)
            ));
        }
        return studentList;
    }
}
