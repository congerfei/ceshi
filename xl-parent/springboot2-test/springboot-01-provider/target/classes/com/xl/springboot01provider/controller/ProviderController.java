package com.xl.springboot01provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: xl
 * date :2020/12/3 19:38
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Controller
public class ProviderController {

    /**
     * 注意引入一下web包,如果觉得没错，还没出来，清理下缓存在试试
     * @param name
     * @return
     */
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    @ResponseBody
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from ："+port ;
    }

}
