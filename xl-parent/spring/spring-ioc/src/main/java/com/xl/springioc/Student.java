package com.xl.springioc;

/**
 * Author: xl
 * date :2020/11/25 10:25
 * description:学生类，获取对象的几种方法
 *  1.通过默认的无参构造器
 *  2.静态方法返回
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Student {
    //无参构造器默认有，除非自己写有构造器


    //静态工厂方法
    public static Student getInstances(){
        return new Student();
    }

    //利用实例工厂方法创建对象
    public Student getInstance(){
        Student student = new Student();
        return student;
    }

    public void study(){
        System.out.println("学生正在学习...");
    }

}
