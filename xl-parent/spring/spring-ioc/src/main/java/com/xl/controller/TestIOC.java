package com.xl.controller;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: xl
 * date :2021/2/17 17:09
 * description:测试ioc的原理(由于框架是要考虑扩展性的,所有直接用set是不可取的)   ctrl+alt+v   快速生成变量名
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TestIOC {

    @Test//自己写set方法实现注入,已知道的是2个对象以及set方法,框架是要考虑扩展性的,所有不能写死
    public void testIoc01() throws Exception {
        UserController userController = new UserController();

        UserService userService = new UserService();

        //如何将userService 赋值给userController的属性呢?1.构造器 2.set方法

        //1.已知userController,如何得到set方法呢?反射  这种方式我们先给他一个set方法
        //先得到该class类
        Class<? extends UserController> aClass = userController.getClass();
        //获取所有的属性  //private com.xl.controller.UserService com.xl.controller.UserController.userService
        Field userService1 = aClass.getDeclaredField("userService");
        //只有通过方法才能设置具体的属性值
        String name = userService1.getName();
        System.out.println(name); //userService

        //需要拼接我们需要的方法名  setUserService
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        String setMethodName = "set" + name;

        System.out.println(userController.getUserService());//-----这个时候还是一个null的
        //通过方法注入属性的对象,这里通过方法名,参数类型得到具体的方法对象,
        Method method = aClass.getMethod(setMethodName, UserService.class);
        //通过反射来运行该方法
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());

    }



}
