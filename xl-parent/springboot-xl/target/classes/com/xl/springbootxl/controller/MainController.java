package com.xl.springbootxl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: xl
 * date :2020/11/6 15:49
 * description:用于测试服务是否正常
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Controller
public class MainController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";

    }


    @GetMapping("/index")
    @ResponseBody
    public String index() {
        return "success";
    }

    @PostMapping("/fail")
    @ResponseBody
    public String fail() {
        return "fail";
    }





}
