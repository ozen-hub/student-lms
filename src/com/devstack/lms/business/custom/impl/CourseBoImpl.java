package com.devstack.lms.business.custom.impl;

import com.devstack.lms.business.custom.CourseBo;
import com.devstack.lms.dao.DaoFactory;
import com.devstack.lms.dao.custom.CourseDao;
import com.devstack.lms.dao.custom.impl.CourseDaoImpl;
import com.devstack.lms.dto.CourseDto;
import com.devstack.lms.entity.Course;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class CourseBoImpl implements CourseBo {

    private final CourseDao courseDao = (CourseDao) DaoFactory.getDao(DaoFactory.DaoType.COURSE);

    @Override
    public boolean create(CourseDto dto) throws SQLException, ClassNotFoundException {
        return courseDao.create(toCourse(dto));
    }

    @Override
    public CourseDto find(String id) throws SQLException, ClassNotFoundException {
        Course course = courseDao.find(id);
        if (course!=null){
            return toCourseDto(course);
        }
        return null;
    }

    @Override
    public boolean update(CourseDto dto) throws SQLException, ClassNotFoundException {
        return courseDao.update(toCourse(dto));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return courseDao.delete(id);
    }

    @Override
    public List<CourseDto> findAll() throws SQLException, ClassNotFoundException {
       /* List<Course> courseList = courseDao.findAll();
        List<CourseDto> dtoList = new ArrayList<>();
        for (Course c:courseList){
            dtoList.add(
                    new CourseDto(
                            c.getCourseId(), c.getCourseName(), c.getFee()
                    )
            );
        }*/
        return courseDao.findAll().stream().map(this::toCourseDto).collect(Collectors.toList());
    }

    private CourseDto toCourseDto(Course c){
        return new CourseDto(
                c.getCourseId(), c.getCourseName(), c.getFee()
        );
    }
    private Course toCourse(CourseDto c){
        return new Course(
                c.getCourseId(), c.getCourseName(), c.getFee()
        );
    }

}
