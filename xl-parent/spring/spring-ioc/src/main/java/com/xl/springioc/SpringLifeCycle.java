package com.xl.springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 生命周期的整个执行过程描述如下。
 * Spring 启动，查找并加载需要被 Spring 管理的 Bean，对 Bean 进行实例化。
 * 对 Bean 进行引用以及属性的注入。
 * 如果 Bean 实现了 BeanNameAware 接口，则 Spring 调用 Bean 的 setBeanName() 方法传入当前 Bean 的 id 值。
 * 如果 Bean 实现了 BeanFactoryAware 接口，则 Spring 调用 setBeanFactory() 方法传入当前工厂实例的引用。
 * 如果 Bean 实现了 ApplicationContextAware 接口，则 Spring 调用 setApplicationContext() 方法传入当前 ApplicationContext 实例的引用。
 * 如果 Bean 实现了 BeanPostProcessor 接口，则 Spring 调用该接口的预初始化方法 postProcessBeforeInitialzation() 对 Bean 进行加工操作，此处非常重要，Spring 的 AOP 就是利用它实现的。
 * 如果 Bean 实现了 InitializingBean 接口，则 Spring 将调用 afterPropertiesSet() 方法。
 * 如果在配置文件中通过 init-method 属性指定了初始化方法，则调用该初始化方法。
 * 如果 BeanPostProcessor 和 Bean 关联，则 Spring 将调用该接口的初始化方法 postProcessAfterInitialization()。此时，Bean 已经可以被应用系统使用了。
 * 如果在 <bean> 中指定了该 Bean 的作用域为 singleton，则将该 Bean 放入 Spring IoC 的缓存池中，触发 Spring 对该 Bean 的生命周期管理；如果在 <bean> 中指定了该 Bean 的作用域为 prototype，则将该 Bean 交给调用者，调用者管理该 Bean 的生命周期，Spring 不再管理该 Bean。
 * 如果 Bean 实现了 DisposableBean 接口，则 Spring 会调用 destory() 方法销毁 Bean；如果在配置文件中通过 destory-method 属性指定了 Bean 的销毁方法，则 Spring 将调用该方法对 Bean 进行销毁。
 *
 */
public class SpringLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {


    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        System.out.println("调用setNameString设置属性值");
        this.nameString = nameString;
    }

    public void start(){
        System.out.println("SpringLifeCycle 中自定义的初始化方法");
    }

    private String nameString ;

    public static void main(String[] args) {
        //1.还在需要被管理的bean ,对 Bean 进行实例化。 这个时候只是使用了new，并没有对对象进行初始化，2.继续读取bean的属性配置进行赋值
        ClassPathXmlApplicationContext  ac = new ClassPathXmlApplicationContext("application3.xml");
        SpringLifeCycle springLifeCycle = (SpringLifeCycle)ac.getBean("springLifeCycle");
        System.out.println(springLifeCycle);

        System.out.println(springLifeCycle.getNameString());

        //手动销毁 Bean
        ac.close();

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware.setBeanName被重写调用,Spring将Bean的Id传递给setBeanName()方法，传入的字符串："+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware.setBeanFactory被重写调用,Spring将调用setBeanFactory()方法，将BeanFactory容器实例传入,传入的beanFactory："+beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware.setApplicationContext被重写调用,applicationContext："+applicationContext);
    }

    /**
     *  自定义的初始化方法之前被调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet 被重写调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy被重写调用");
    }
}
