package com.xl.springboot01provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Author: xl
 * date :2020/12/3 16:25
 * description: 可以通过激活不同的配置文件启动多次，添加一个springboot配置，照着之前的重新配置一下，激活文件记得改一下就行
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@EnableEurekaClient
@SpringBootApplication
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }



}
