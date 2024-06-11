package com.devstack.lms.business.custom;

import com.devstack.lms.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {
    public boolean create(StudentDto dto) throws SQLException, ClassNotFoundException;
}
