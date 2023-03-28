package com.xl.springbootxl.configs.security;

import com.xl.springbootxl.configs.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *  只要引入  spring-boot-starter-security  就有一个默认的登陆界面    login  可以访问到
 *
 *    WebSecurityConfigurerAdapter  是 Security的核心配置类
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单登录
                .defaultSuccessUrl("/index")  //  登录成功之后跳转到哪个 url
                .failureForwardUrl("/fail")   //  登录失败之后跳转到哪个 url
                .and()
                .authorizeRequests() // 认证配置
                .anyRequest() // 任何请求
                .authenticated(); // 都需要身份验证
        // 关闭 csrf
        http.csrf().disable();
    }

    /**
     * 在MyUserDetailsService  中进行账号的对比后  然后需要进行认证了
     * @param auth
     * @throws Exception
     */
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    // 注入 PasswordEncoder 类到 spring 容器中
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
