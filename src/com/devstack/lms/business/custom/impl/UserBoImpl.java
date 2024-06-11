package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.UserBo;
import com.devstack.lms.dto.StudentDto;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    @Override
    public boolean create(StudentDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }
}
