package com.devstack.lms.business.custom;

import com.devstack.lms.dto.StudentDto;
import com.devstack.lms.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo {
    public boolean create(UserDto dto) throws SQLException, ClassNotFoundException;
}
