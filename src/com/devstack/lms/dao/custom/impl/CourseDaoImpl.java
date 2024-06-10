package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.CourseDao;
import com.devstack.lms.entity.Course;

import java.util.Collections;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public boolean create(Course course) {
        return false;
    }

    @Override
    public Course find(String s) {
        return null;
    }

    @Override
    public boolean update(Course course, String s) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Course> findAll() {
        return Collections.emptyList();
    }
}
