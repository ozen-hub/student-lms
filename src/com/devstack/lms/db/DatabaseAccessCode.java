package com.devstack.lms.db;

import com.devstack.lms.model.Course;
import com.devstack.lms.model.Student;
import com.devstack.lms.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {
    //=====Student management==========
    public boolean saveStudent(Student student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getStudentId());
        preparedStatement.setString(2, student.getStudentName());
        preparedStatement.setString(3, student.getAddress());
        preparedStatement.setInt(4, student.getAge());
        preparedStatement.setString(5, student.getEmail());

        int affectedRowCount = preparedStatement.executeUpdate();

        if (affectedRowCount > 0) {
            return true;
        }
        return false;
    }

    public List<Student> findAllStudents(String searchText) throws ClassNotFoundException, SQLException {
        searchText = "%" + searchText + "%";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "SELECT * FROM student WHERE student_name LIKE ? OR email LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, searchText);
        preparedStatement.setString(2, searchText);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> studentList = new ArrayList<>();

        while (resultSet.next()) {
            studentList.add(new Student(
                    resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(5),
                    resultSet.getInt(4)
            ));
        }
        return studentList;
    }

    public boolean deleteStudent(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "DELETE FROM student WHERE student_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);

        int affectedRowCount = preparedStatement.executeUpdate();

        if (affectedRowCount > 0) {
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "UPDATE student SET student_name=?, address=?, age=?,email=? WHERE student_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getStudentName());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setInt(3, student.getAge());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getStudentId());

        int affectedRowCount = preparedStatement.executeUpdate();

        if (affectedRowCount > 0) {
            return true;
        }
        return false;
    }

    public Student findStudent(String studentId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "SELECT * FROM student WHERE student_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, studentId);

        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(5),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

    //=====Student management==========

    //=====User management==========
    public boolean signup(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms",
                        "root",
                        "1234");

        String sql = "INSERT INTO user_table VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getUserId());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());

        int affectedRowCount = preparedStatement.executeUpdate();

        if (affectedRowCount > 0) {
            return true;
        }
        return false;
    }

    public boolean login(String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms",
                        "root",
                        "1234");

        String sql = "SELECT * FROM user_table WHERE username = '" + username + "' AND password = '" + password + "'";
        System.out.println(sql);
        //SELECT * FROM user_table WHERE username = 'username' AND password = 'password'
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            return true;
        }

        return false;
    }

    //=====User management==========

    //=====Course management==========
    public boolean saveCourse(Course course) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "INSERT INTO course VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, course.getCourseId());
        preparedStatement.setString(2, course.getCourseName());
        preparedStatement.setDouble(3, course.getFee());
        int affectedRowCount = preparedStatement.executeUpdate();

        if (affectedRowCount > 0) {
            return true;
        }
        return false;
    }
    public List<Course> findAllCourses() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "SELECT * FROM course";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        List<Course> courseList = new ArrayList<>();

        while (resultSet.next()) {
            courseList.add(new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)
            ));
        }
        return courseList;
    }
    public Course findCourse(String courseId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/devstack_lms", "root", "1234");

        String sql = "SELECT * FROM course WHERE course_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, courseId);

        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            return new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3)
            );
        }
        return null;
    }



    //=====Course management==========
}
