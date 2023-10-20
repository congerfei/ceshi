package com.xl.springboot1start.controller;

import com.xl.springboot1start.config.MyHttpInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
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
@Log4j2
public class MainController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        log.info("访问次数："+MyHttpInterceptor.count);
        return "Hello World!";
    }

}
