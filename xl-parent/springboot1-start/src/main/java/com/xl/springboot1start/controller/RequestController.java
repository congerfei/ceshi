package com.xl.springboot1start.controller;

import com.xl.springboot1start.request.ReqVo1;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 测试请求体  的数据转换
 */
@Controller
@ResponseBody
@Log4j2
public class RequestController {

    /**
     * Spring Boot中使用Convert接口实现类型转换器
     *  value 访问路径
     *  produces  响应体格式
     *  consumes   请求体格式
     *  method   请求方法  post/get
     * @param req  请求体    ---------这个时候前面是不加@
     * @return
     */
    @RequestMapping(value = "/req1" ,produces="application/json",consumes = "application/x-www-form-urlencoded",method = RequestMethod.POST)
    public String req1( ReqVo1 req){
        log.info(req);
        return req.toString();
    }

    /**
     *
     * @param req
     * @return
     */
    @PostMapping(value = "/req2")
    public String req2(@RequestBody ReqVo1 req){
        log.info("请求体: {}",req);
        return req.toString();
    }



}
