package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.UserBo;
import com.devstack.lms.dao.DaoFactory;
import com.devstack.lms.dao.custom.UserDao;
import com.devstack.lms.dao.custom.impl.UserDaoImpl;
import com.devstack.lms.dto.StudentDto;
import com.devstack.lms.dto.UserDto;
import com.devstack.lms.entity.User;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    private final UserDao userDao=  DaoFactory.getDao(DaoFactory.DaoType.USER);
    @Override
    public boolean create(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.create(
                new User(
                        dto.getUserId(), dto.getUsername(), dto.getPassword()
                )
        );
    }

    @Override
    public boolean login(String username, String password) throws ClassNotFoundException, SQLException {
        return userDao.login(username,password);
    }
}
