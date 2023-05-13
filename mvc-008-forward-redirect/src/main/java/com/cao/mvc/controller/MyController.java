package com.cao.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    /**
     * 处理器方法返回ModelAndView,实现forward转发操作
     * 语法：setViewName("forward:视图文件完整路径")
     * forward特点：不和视图解析器一起工作，相当于项目中没有视图解析器
     * @return
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","我的springmvc程序");
        mv.addObject("fun","执行的是doSome方法");
        /*
            显示转发：
                用于一些特殊需求.
                比如：如果要跳转的页面不在WEB-INF目录之下的话，这个时候视图解析器就用不了
                    比如：直接访问根目录下的hello.jsp，因为不在WEB-INF目录下，mv.setViewName("hello")
                        浏览器会自动加上视图解析器的前缀和后缀去WEB-INF下寻找，但是很明显hello.jsp是在根目录下的
                        所以不能找到404.
                        如果用forward转发：不会和视图解析器一起工作，就不会自动加上前缀和后缀
         */
        mv.setViewName("forward:/hello.jsp") ;
        return mv;
    }

    /**
     * 处理器方法返回ModelAndView实现重定向操作
     * 语法：setViewName("redirect:视图的完整路径")
     * redirect特点：不和视图解析器一起工作，相当于项目中没有视图解析器
     *
     * 框架对重定向的操作：
     *      框架会把Model中的简单数据类型，转为String使用，作为第二次请求的参数使用
     *      目的是：使用第一次请求和第二次请求之间可以传递数据
     *
     *      思考：为什么在hello.jsp页面取不出Model中的数据呢？
     *          因为我们把数据放在了第一次请求的请求域中，而浏览器发送第二次请求的时候，第二次的请求域中没有数据
     *          也就是说请求域变了。所以取不出来。
     *          但是因为框架给第二次请求加上了请求参数，所以可以使用request.getParameter("")取出请求体中的数据
     *      重定向不能访问WEB-INF目录下的资源
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        //数据放入到request作用域中
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //重定向：语句执行到这里，浏览器发送第二次请求
        //请求地址：http://localhost:8080/mvc_008/hello.jsp?myName=ccc&myAge=22
        mv.setViewName("redirect:/hello.jsp") ;

        //重定向不能访问WEB-INF目录下的资源
        //mv.setViewName("redirect:/WEB-INF/view/show.jsp");
        return mv;
    }
}
