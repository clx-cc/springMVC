package com.cao.ssm.service.impl;

import com.cao.ssm.mapper.StudentMapper;
import com.cao.ssm.pojo.Student;
import com.cao.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    @Transactional
    public int addStudent(Student student) {
        int count = studentMapper.insert(student);
        if (count != 1){
            throw new RuntimeException("添加失败");
        }
        return count;
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }
}
