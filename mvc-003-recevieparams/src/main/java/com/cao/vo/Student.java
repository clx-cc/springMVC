package com.cao.vo;

//保存请求参数的一个普通类
public class Student {
    //请求参数名要和属性名一样
    private String name;
    private Integer age;

    public Student() {
        System.out.println("---student的无参构造---");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName" + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge" + age);
        this.age = age;
    }
}
