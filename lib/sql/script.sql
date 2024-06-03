CREATE DATABASE IF NOT EXISTS devstack_lms;
USE devstack_lms;
CREATE TABLE IF NOT EXISTS student(
                                      student_id VARCHAR(45),
                                      student_name VARCHAR(45),
                                      address TEXT,
                                      age INT,
                                      email VARCHAR(100) UNIQUE NOT NULL ,
                                      CONSTRAINT PRIMARY KEY (student_id)
);
DESC student;
CREATE TABLE IF NOT EXISTS user_table(
                                         user_id VARCHAR(45),
                                         username VARCHAR(45) UNIQUE NOT NULL ,
                                         password TEXT,
                                         CONSTRAINT PRIMARY KEY (user_id)
);
DESC user_table;
CREATE TABLE IF NOT EXISTS course(
                                     course_id VARCHAR(45),
                                     course_name VARCHAR(45),
                                     fee DECIMAL(10,2),
                                     CONSTRAINT PRIMARY KEY (course_id)
);
DESC course;

CREATE TABLE IF NOT EXISTS registration(
                                           registration_id VARCHAR(45),
                                           registered_date DATE,
                                           student VARCHAR(45),
                                           course VARCHAR(45),
                                           CONSTRAINT PRIMARY KEY (registration_id, student, course),
                                           CONSTRAINT FOREIGN KEY (student) REFERENCES student(student_id),
                                           CONSTRAINT FOREIGN KEY (course) REFERENCES course(course_id)
);
DESC registration;