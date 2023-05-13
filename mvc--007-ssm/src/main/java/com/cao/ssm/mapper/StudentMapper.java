package com.cao.ssm.mapper;

import com.cao.ssm.pojo.Student;

import java.util.List;

public interface StudentMapper {

     int insert(Student student);

     List<Student> selectAll();

}
