package com.xl;

import com.xl.springaop.proxy.ObjectInterceptor;
import com.xl.springaop.proxy.ProxyUserService;
import com.xl.springaop.service.UserService;
import com.xl.springaop.service.impl.UserServiceImpl;
import com.xl.springaop.tran.MyTransaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

/**
 * Author: xl
 * date :2020/11/25 18:16
 * description:静态代理的方式
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */

public class ProxyTest {
    /**
     * 静态代理类测试
     */
    @Test
    public void testOne(){
        MyTransaction transaction = new MyTransaction();
        UserService userService = new UserServiceImpl();
        //产生静态代理对象
        ProxyUserService proxy = new ProxyUserService(userService, transaction);
        proxy.addUser(null);
        proxy.deleteUser(0);
    }

    /**
     * JDK动态代理
     */
    @Test
    public void test2(){
        //目标类
        Object target = new UserServiceImpl();
        //事务类
        MyTransaction transaction = new MyTransaction();
        ObjectInterceptor proxyObject = new ObjectInterceptor(target, transaction);
        /**
         * 三个参数的含义：
         * 1、目标类的类加载器
         * 2、目标类所有实现的接口
         * 3、拦截器
         */
        UserService userService = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), proxyObject);
        userService.addUser(null);
        userService.deleteUser(0);

    }

    /**
     * 使用Spring-aop进行增强
     */
    @Test
    public void testAop(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService useService = (UserService) context.getBean("userService");
        useService.addUser(null);
        useService.deleteUser(0);
    }

    /**
     * 使用注解得方式来完成aop
     */
    @Test
    public void testAopAnnation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UserService useService = (UserService) context.getBean("userService");
        useService.addUser(null);
        useService.deleteUser(0);
    }

    
}
