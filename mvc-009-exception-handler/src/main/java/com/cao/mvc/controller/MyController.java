package com.cao.mvc.controller;

import com.cao.mvc.exception.AgeException;
import com.cao.mvc.exception.MyUserException;
import com.cao.mvc.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        ModelAndView mv = new ModelAndView();
        if (!"ccc".equals(name)){
            throw new NameException("名字不正确。。。");
        }
        if (age==null || age > 80){
            throw new AgeException("年龄不正确。。。");
        }
        //数据放入到request作用域中
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show") ;

        return mv;
    }
}
