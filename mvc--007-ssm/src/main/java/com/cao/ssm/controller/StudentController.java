package com.cao.ssm.controller;

import com.cao.ssm.pojo.Student;
import com.cao.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //注册学生
    @RequestMapping(value = "/addStudent.do")
    public ModelAndView addStudent(Student student){
        String tips = "注册成功";
        try {
            int count = studentService.addStudent(student);
        } catch (Exception e) {
            tips = "注册失败";
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips",tips);
        mv.setViewName("show");
        return mv;
    }
    //展示学生列表
    @RequestMapping("/getList.do")
    @ResponseBody
    public List<Student> getList(){
        return studentService.getAll();
    }
}
