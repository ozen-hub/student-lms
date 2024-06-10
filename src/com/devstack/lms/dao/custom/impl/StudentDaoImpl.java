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
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE student_id=?",s);
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
        return CrudUtil.execute("UPDATE student SET student_name=?, address=?, age=?,email=? WHERE student_id=?",
                student.getStudentName(),student.getAddress(),student.getAge(),student.getEmail(),student.getStudentId());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM student WHERE student_id=?",s);
    }

    @Override
    public List<Student> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Student> search(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE student_name LIKE ? OR email LIKE ?",
                searchText,searchText);

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
