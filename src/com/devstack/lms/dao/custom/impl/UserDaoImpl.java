package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.CrudUtil;
import com.devstack.lms.dao.custom.UserDao;
import com.devstack.lms.db.DbConnection;
import com.devstack.lms.entity.User;
import com.devstack.lms.util.PasswordManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean create(User user) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("INSERT INTO user_table VALUES(?,?,?)",
                user.getUserId(), user.getUsername(), PasswordManager.hash(user.getPassword()));
    }

    @Override
    public User find(String s) {
        return null;
    }

    @Override
    public boolean update(User user) {
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

    @Override
    public boolean login(String username, String password) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM user_table WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println(sql);
        //SELECT * FROM user_table WHERE username = 'username' AND password = 'password'
        Statement statement = DbConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            return true;
        }

        return false;
    }
}
