package com.test;

import com.xl.springioc.Person;
import com.xl.springioc.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xl
 * date :2020/11/25 10:36
 * description:一个spring的创建过程
 *  1.导包spring-beans,以及spring-content 即可
 *  2.spring配置文件 application.xml
 *  3.写一个Student对象，然后配置进spring配置文件中即可
 *  4.ClassPathXmlApplicationContext读取配置文件，就可以使用spring管理的beans了
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class IOCTest {

    @Test
    public void test1(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");

        Student student = (Student) context.getBean("student3");
        student.study();

    }

    @Test
    public void test2(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application2.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person.toString());
    }



}
