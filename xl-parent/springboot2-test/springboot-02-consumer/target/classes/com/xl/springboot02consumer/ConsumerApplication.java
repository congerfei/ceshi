package com.xl.springboot02consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author: xl
 * date :2020/12/3 18:29
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerApplication {
    //这个服务名字觉得有点问题，简单说就是通过这个桥来访问2个同名的服务来实现负载均衡
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }


}
