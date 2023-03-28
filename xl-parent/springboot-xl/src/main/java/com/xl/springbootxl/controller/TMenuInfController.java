package com.xl.springbootxl.controller;


import com.xl.springbootxl.common.ResultVO;
import com.xl.springbootxl.pojo.TMenuInf;
import com.xl.springbootxl.service.TMenuInfService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/menu")
@Log
public class TMenuInfController {
    @Autowired
    private TMenuInfService tMenuInfService;

    @PostMapping("/getmenu")
    public  ResultVO getSmgTUsrInf() {
        ArrayList<TMenuInf> tMenuInfInfos = tMenuInfService.queryMenuTree();
        return new ResultVO(tMenuInfInfos);
    }


}
