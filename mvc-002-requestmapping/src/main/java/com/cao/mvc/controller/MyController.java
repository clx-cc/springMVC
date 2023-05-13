package com.cao.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//这个方法放到类上就表示这个控制器下所有方法的父地址
@RequestMapping("/user")
public class MyController {

    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response,
                               HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","我的springmvc程序");
        mv.addObject("fun","执行的是doSome方法"+request.getParameter("name"));
        mv.setViewName("show");
        return mv;
    }
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","我的springmvc程序");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");
        return mv;
    }
}
