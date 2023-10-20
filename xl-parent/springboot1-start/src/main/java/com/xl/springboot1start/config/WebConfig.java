package com.xl.springboot1start.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @program: ceshi
 * @description: 拦截器
 * @author: xl
 * @create: 2023-06-13 10:36
 **/





@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    /**
     * 可定义多个拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 定义过滤拦截的url名称，拦截所有请求
        registry.addInterceptor(new MyHttpInterceptor()).addPathPatterns("/**");
//		registry.addInterceptor(其他拦截器).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}