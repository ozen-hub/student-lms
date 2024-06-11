package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.RegistrationBo;
import com.devstack.lms.dao.custom.RegistrationDao;
import com.devstack.lms.dao.custom.impl.RegistrationDaoImpl;
import com.devstack.lms.dto.RegistrationDto;
import com.devstack.lms.entity.Registration;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class RegistrationBoImpl implements RegistrationBo {

    private final RegistrationDao registrationDao = new RegistrationDaoImpl();

    @Override
    public boolean create(RegistrationDto dto) throws SQLException, ClassNotFoundException {
        return registrationDao.create(
                new Registration(
                        dto.getRegisterId(),
                        dto.getDate(),
                        dto.getNic(),
                        dto.getPaymentType(),
                        dto.getStudent(),
                        dto.getCourse()
                )
        );
    }

    @Override
    public RegistrationDto find(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(RegistrationDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<RegistrationDto> findAll() throws SQLException, ClassNotFoundException {
        return Collections.emptyList();
    }
}
