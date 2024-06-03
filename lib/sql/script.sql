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
     user_name VARCHAR(45) UNIQUE NOT NULL ,
     password TEXT,
     CONSTRAINT PRIMARY KEY (user_id)
);
DESC user_table;