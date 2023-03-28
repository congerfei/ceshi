package com.xl.springboot3admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Author: xl
 * date :2020/11/7 12:29
 * description:所有服务的注册中心
 *  * 配置中心
 *  * @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到该服务。
 *  *
 *  * 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@SpringBootApplication
@EnableEurekaServer//表示这是一个注册中心，也可以用@EnableDiscoveryClient
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class,args);
    }


    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().ignoringAntMatchers("/eureka/**");//新版的默认开启了csrf防止网页注入，需要放开/eureka下的请求
            super.configure(http);
        }
    }

}
