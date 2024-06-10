package com.devstack.lms.dao.custom;

import com.devstack.lms.dao.CrudDao;
import com.devstack.lms.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao extends CrudDao<Student,String> {
    public List<Student> search(String searchText) throws SQLException, ClassNotFoundException;
}
