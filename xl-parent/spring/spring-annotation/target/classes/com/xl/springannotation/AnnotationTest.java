package com.xl.springannotation;

import com.xl.springannotation.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: xl
 * date :2021/1/3 17:25
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class AnnotationTest {

    @Test
    public void test01(){
        //ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("****.xml");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfig.class);
        Object person = ac.getBean("person");//这个参数是id,默认就是我们bean方法的名称,也可以通过bean的参数设置
        System.out.println(person);

    }

}
