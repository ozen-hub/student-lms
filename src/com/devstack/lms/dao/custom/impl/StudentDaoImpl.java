package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.StudentDao;
import com.devstack.lms.entity.Student;

import java.util.Collections;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean create(Student student) {
        return false;
    }

    @Override
    public Student find(String s) {
        return null;
    }

    @Override
    public boolean update(Student student, String s) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        return Collections.emptyList();
    }
}
