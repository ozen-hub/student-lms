package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.StudentBo;
import com.devstack.lms.dao.DaoFactory;
import com.devstack.lms.dao.custom.StudentDao;
import com.devstack.lms.dao.custom.impl.StudentDaoImpl;
import com.devstack.lms.dto.StudentDto;
import com.devstack.lms.entity.Student;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentBoImpl implements StudentBo {

    private final StudentDao studentDao = (StudentDao) DaoFactory.getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public boolean create(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDao.create(toStudent(dto));
    }

    @Override
    public StudentDto find(String id) throws SQLException, ClassNotFoundException {
        Student student = studentDao.find(id);
        if (student!=null) toStudentDto(student);
        return null;
    }

    @Override
    public boolean update(StudentDto dto) throws SQLException, ClassNotFoundException {
        return studentDao.update(toStudent(dto));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return studentDao.delete(id);
    }

    @Override
    public List<StudentDto> findAll() throws SQLException, ClassNotFoundException {
        return studentDao.findAll().stream().map(this::toStudentDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> search(String searchText) throws SQLException, ClassNotFoundException {
        return studentDao.search(searchText).stream().map(this::toStudentDto).collect(Collectors.toList());
    }

    private StudentDto toStudentDto(Student s){
        return new StudentDto(
                s.getStudentId(),s.getStudentName(),s.getAddress(),s.getEmail(),s.getAge()
        );
    }
    private Student toStudent(StudentDto s){
        return new Student(
                s.getStudentId(),s.getStudentName(),s.getAddress(),s.getEmail(),s.getAge()
        );
    }

}
