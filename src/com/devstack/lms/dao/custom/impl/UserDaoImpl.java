package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.UserDao;
import com.devstack.lms.db.DbConnection;
import com.devstack.lms.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean create(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user_table VALUES(?,?,?)";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());

        return preparedStatement.executeUpdate()>0;
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
