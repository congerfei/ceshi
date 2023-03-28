package com.xl.service;


import com.xl.springboot02consumer.service.ConsumerService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Author: xl
 * date :2020/12/3 18:28
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */

@SpringBootTest
public class ConsumerServiceTest {

    @Resource
    ConsumerService consumerService;

    @Test
    public void  content(){
        System.out.println("hello");
    }

}
