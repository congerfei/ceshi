package com.xl.springboot02consumer.controller;

import com.xl.springboot02consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xl
 * date :2020/12/3 20:19
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@RestController
public class HiController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return consumerService.sayHiFromClientOne(name);
    }

}
