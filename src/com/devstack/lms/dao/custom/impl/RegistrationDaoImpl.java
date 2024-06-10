package com.devstack.lms.dao.custom.impl;

import com.devstack.lms.dao.custom.RegistrationDao;
import com.devstack.lms.db.DbConnection;
import com.devstack.lms.entity.Registration;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class RegistrationDaoImpl implements RegistrationDao {
    @Override
    public boolean create(Registration registration) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO registration VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
        preparedStatement.setString(1, registration.getRegisterId());
        preparedStatement.setObject(2, registration.getDate());
        preparedStatement.setObject(3, registration.getNic());
        preparedStatement.setString(4, registration.getPaymentType().name());
        preparedStatement.setString(5, registration.getStudent());
        preparedStatement.setString(6, registration.getCourse());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Registration find(String s) {
        return null;
    }

    @Override
    public boolean update(Registration registration) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Registration> findAll() {
        return Collections.emptyList();
    }
}
