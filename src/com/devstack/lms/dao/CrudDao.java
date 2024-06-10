package com.devstack.lms.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T,ID> {
    public boolean create(T t) throws SQLException, ClassNotFoundException;
    public T find(ID id) throws SQLException, ClassNotFoundException;
    public boolean update(T t) throws SQLException, ClassNotFoundException;
    public boolean delete(ID id) throws SQLException, ClassNotFoundException;
    public List<T> findAll();
}
