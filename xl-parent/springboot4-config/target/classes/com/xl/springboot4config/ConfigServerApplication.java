package com.xl.springboot4config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Author: xl
 * date :2020/12/4 16:17
 * description:  分布式配置中心
 *                  1.导包 spring-cloud-config-server  + 一个start-web用于启动
 *                  2.配置仓库的git地址即可
 *                  3.启动注解@EnableConfigServer/
 *                  4.http://localhost:3344/application-test.yml  直接可以访问到我们的github上的配置文件
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@SpringBootApplication
@EnableConfigServer//配置中心的注解
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
        System.out.println("配置中心服务端启动成功!");
    }
}
