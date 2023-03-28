package com.xl.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *  需要在配置成bean才能使用
 *
 * 如果 Bean 实现了 BeanPostProcessor 接口，则 Spring 调用该接口的预初始化方法 postProcessBeforeInitialzation() 对 Bean 进行加工操作，
 * 此处非常重要，Spring 的 AOP 就是利用它实现的。
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 	实例化、依赖注入完毕，
     * 在调用显示的初始化之前完成一些定制的初始化任务
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization被重写调用,bean："+bean+"："+beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }


    /**
     * 实例化、依赖注入、初始化完毕时执行
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization 被重写调用,bean："+bean+"："+beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
