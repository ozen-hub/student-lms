package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.CourseDao;
import com.devstack.lms.db.DbConnection;
import com.devstack.lms.entity.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean create(Course course) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO course VALUES(?,?,?)";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseName());
        preparedStatement.setDouble(3, course.getFee());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Course find(String s) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM course WHERE course_id=?";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, s);

        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            return new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)
            );
        }
        return null;
    }

    @Override
    public boolean update(Course course) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Course> findAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM course";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Course> courseList = new ArrayList<>();

        while (resultSet.next()) {
            courseList.add(new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)
            ));
        }
        return courseList;
    }
}
