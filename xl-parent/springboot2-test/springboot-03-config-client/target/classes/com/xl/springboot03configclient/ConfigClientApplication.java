package com.xl.springboot03configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author: xl
 * date :2020/12/4 17:07
 * description: 测试读取配置中心的配置文件
 *              1.导包
 *              2.配置 这里认识到了 系统配置文件 bootstrap.yml>application
 *              3.先启动config-server ，在启动client即可启动服务即可，然后发现端口启动在8100,也就是读取的我们仓库的配置文件
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }



}
