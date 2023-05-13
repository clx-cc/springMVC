package com.cao.mvc.handler;


import com.cao.mvc.exception.AgeException;
import com.cao.mvc.exception.NameException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice：控制器增强（也就是给控制器增加功能-----异常处理功能）
 *      位置：在类的上面
 *
 *  特点：需要让框架知道这个注解所有的包名，需要在springmvc的配置文件中声明组件扫描器
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //定义方法，处理异常

    /*
        处理异常的方法和控制器方法一样，可以有多个参数，可以有ModelAndView、String、void、对象类型的返回值

        形参：Exception 表示Controller中抛出的异常对象
        通过形参可以获取发生的异常信息。

        @ExceptionHandler(value = 异常的class:表示异常的类型，当发生此类型异常时，由当前方法来处理)
     */
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception e){

        //处理NameException的异常
        /*
            异常发生时，要处理的逻辑：
                1、需要把异常记录下来，记录到数据库，日志文件
                记录日志时间，哪个方法发生的，异常错误信息
                2、发送通知，把异常的信息通过邮件，短信，微信发送给相关人员
                3、给用户友好的提示

         */
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","姓名必须是ccc,其他人不能访问");
        mv.addObject("ex",e);
        mv.setViewName("nameError");

        return mv;
    }
    @ExceptionHandler(AgeException.class)
    public ModelAndView doAgeException(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你的年龄不对");
        mv.addObject("ex",e);
        mv.setViewName("ageError");
        return mv;
    }
    //处理其他的异常
    /*
        这个异常处理方法只能有一个，是用来处理其他异常的：也就是我们没有发现的异常
        @ExceptionHandler注解的value可以没有
     */
    @ExceptionHandler
    public ModelAndView doDefaultException(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","其他异常");
        mv.addObject("ex",e);
        mv.setViewName("defaultError");
        return mv;
    }

}
