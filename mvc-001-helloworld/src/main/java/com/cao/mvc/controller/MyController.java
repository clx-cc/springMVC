package com.cao.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器对象：对象放在springMVC容器中
 */
@Controller
public class MyController {

    //处理用户提交的请求：springMVC是使用方法来处理请求的，方法是自定义的
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(){
        //在这个方法中就可以处理some.do的请求了.相当于service调用处理完成了
        ModelAndView mv = new ModelAndView();
        //添加数据：框架在请求的最后实际上是把数据放到request作用域中了
        //request.setAttribute("msg","第一个web程序");
        mv.addObject("msg","第一个web程序");
        mv.addObject("fun","doSome方法执行");
        //指定视图：指定视图的完整路径
        //框架在底层实际上执行的forward操作，request.getRequestDispatcher("/show.jsp").forward(...);
//        mv.setViewName("/WEB-INF/view/show.jsp");

        //当配置了视图解析器：可以使用逻辑名称（文件名）来指定视图
        //框架底层会使用视图解析器的前缀+逻辑名称+后缀来组成路径，这是就是字符串连接操作。
        // /WEB-INF/view + show +.jsp
        mv.setViewName("show");
        return mv;
    }
}
