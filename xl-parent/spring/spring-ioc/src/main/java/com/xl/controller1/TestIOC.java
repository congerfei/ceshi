package com.xl.controller1;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * Author: xl
 * date :2021/2/17 17:09
 * description:手写Autowired注解 ,不需要set方法了   ctrl+alt+v   快速生成变量名
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TestIOC {
    @Test
    public void testMyAutoWired(){
        UserController userController = new UserController();

        Class<? extends UserController> aClass = userController.getClass();

        //获取所有的属性值
        Stream.of(aClass.getDeclaredFields()).forEach(
                field -> {
                    String name = field.getName();
                    MyAutoWired annotation = field.getAnnotation(MyAutoWired.class);
                    if(annotation != null){
                        field.setAccessible(true);
                        //获取属性的类型
                        Class<?> type = field.getType();
                        System.out.println(type); //class com.xl.controller.UserService
                        try {
                            Object o = type.newInstance(); //这里要抛出异常


                            System.out.println(o); //com.xl.controller.UserService@4cc77c2e UserService的一个实际对象
                            field.set(userController,o);//-------------特别关键不需要set方法就可以设置属性


                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        System.out.println(userController.getUserService());

    }



}
