package com.cao.ssm.service;

import com.cao.ssm.pojo.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);
    List<Student> getAll();
}
