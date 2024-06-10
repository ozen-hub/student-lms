package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.UserDao;
import com.devstack.lms.entity.User;

import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean create(User user) {
        return false;
    }

    @Override
    public User find(String s) {
        return null;
    }

    @Override
    public boolean update(User user, String s) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
