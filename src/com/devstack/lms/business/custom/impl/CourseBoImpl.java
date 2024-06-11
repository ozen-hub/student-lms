package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.CourseBo;
import com.devstack.lms.dto.CourseDto;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class CourseBoImpl implements CourseBo {
    @Override
    public boolean create(CourseDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public CourseDto find(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(CourseDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CourseDto> findAll() throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}
