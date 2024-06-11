package com.devstack.lms.business.custom;

import com.devstack.lms.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseBo {
    public boolean create(CourseDto dto) throws SQLException, ClassNotFoundException;
    public CourseDto find(String id) throws SQLException, ClassNotFoundException;
    public boolean update(CourseDto dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public List<CourseDto> findAll() throws SQLException, ClassNotFoundException;
}
