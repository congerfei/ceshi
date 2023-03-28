package com.xl.springannotation.config;

import com.xl.springannotation.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: xl
 * date :2021/1/3 17:12
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Configuration // 等价于之前的配置文件beans.xml,告诉spring这是一个配置类
@ComponentScan//spring组件扫描,可以带参数确认扫描包和排除包
public class MyConfig {

    @Bean("person")   //给容器种注册一个bean,类型为返回值的类型,id默认是用方法名作为id,也可以传参数
    public Person person(){
        return new Person("xl",25);
    }




}
