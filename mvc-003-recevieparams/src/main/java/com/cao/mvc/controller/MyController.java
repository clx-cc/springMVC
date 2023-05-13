package com.cao.mvc.controller;

import com.cao.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    @RequestMapping(value = "/receiveProperty.do",method = RequestMethod.POST)
    public ModelAndView receiveProperty(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/receiveParam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname") String name, @RequestParam(value = "rage",required = false) Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/receiveObeject.do")
    public ModelAndView receiveObeject(Student student){
        System.out.println("name："+student.getName()+"age："+student.getAge());
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());
        mv.addObject("student",student);
        mv.setViewName("show");
        return mv;
    }
}
