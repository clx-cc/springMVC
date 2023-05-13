package com.cao.mvc.controller;

import com.cao.mvc.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {

    /**
     * 处理器方法返回String---表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request,String name, Integer age){
        System.out.println("doReturnView：" + " name：" + name + " age：" + age);
        //可以手动向request域中添加数据
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        //show是逻辑视图名称，项目中配置了视图解析器
        //框架对视图进行forward操作
        return "show";
    }

    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request,String name, Integer age){
        System.out.println("doReturnView2：" + " name：" + name + " age：" + age);
        //可以手动向request域中添加数据
        request.setAttribute("name",name);
        request.setAttribute("age",age);
        //返回完整视图路径，项目中不能配置视图解析器
        //框架对视图进行forward操作
        //如果此时配置了视图解析器：路径会冲突：/WEB-INF/view/WEB-INF/view/show.jsp.jsp
        return "/WEB-INF/view/show.jsp";
    }

    //处理器方法返回void,响应ajax请求
    //手工实现ajax，json数据：代码有重复，1，java对象转换为json 2，通过HttpServletResponse响应数据
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnVoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("doReturnView2：" + " name：" + name + " age：" + age);
        //处理ajax，使用json数据格式
        //Service调用完成了，使用Student表示处理结果
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        //把结果对象转为json数据
        String json = "";
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json" + json);
        }
        //输出数据，响应ajax请求
        response.setContentType("application/json;utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        out.close();
    }

    //处理器方法返回一个Student对象，通过框架转换为json格式，响应ajax请求
    //@ResponseBody注解：将处理器方法返回的对象转换为json字符串，通过HttpServletResponse返回给浏览器
    @ResponseBody
    @RequestMapping(value = "/returnStudentJson.do")
    public Student doStudentJsonObject(String name, Integer age) {
        System.out.println("doReturnView2：" + " name：" + name + " age：" + age);
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    /**
     * 处理器方法返回json数组
     */
    @ResponseBody
    @RequestMapping(value = "/returnStudentJsonArray.do")
    public List<Student> doStudentJsonArrayObject(String name, Integer age) {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        list.add(student);
        Student student1 = new Student("lll", 23);
        Student student2 = new Student("xxx", 24);
        list.add(student1);
        list.add(student2);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/returnStringObject.do",produces = "text/plain;charset = utf-8")
    public String doReturnStringObject(String name, Integer age) {

        return "处理器方法的返回值是String，但是因为有@ResponseBody注解，所以表示数据，不是视图";
    }



}
