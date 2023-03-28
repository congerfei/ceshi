package com.xl.springbootxl.controller;


import com.xl.springbootxl.common.ResultVO;
import com.xl.springbootxl.pojo.TUsrInf;
import com.xl.springbootxl.service.TUsrInfService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Log
public class TUsrInfController {

    @Autowired
    private TUsrInfService tUsrInfService;

    @GetMapping(value = "/getUserById")
    public ResultVO queryTreeMenu(@RequestParam String id){
        log.info("传入参数{}"+id);
        TUsrInf tUsrInf = tUsrInfService.getTUsrInfById(id);
        return new ResultVO(tUsrInf);
    }


}
