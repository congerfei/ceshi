package com.xl.springboot1start.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 默认的单例
 */
@Controller
public class ThreadControllerTest {

    private Integer stock = 100;

    /**
     * 使用jemeter测试，开启100个线程，发现最后结果不是0，并且有些重复的
     */
    @RequestMapping("/reduceNum")
    @ResponseBody
    public void reduceNum() {
        stock --;
        System.out.println(stock);
    }



}
