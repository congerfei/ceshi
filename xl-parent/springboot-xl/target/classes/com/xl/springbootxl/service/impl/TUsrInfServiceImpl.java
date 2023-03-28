package com.xl.springbootxl.service.impl;

import com.xl.springbootxl.mapper.TUsrInfMapper;
import com.xl.springbootxl.pojo.TUsrInf;
import com.xl.springbootxl.service.TUsrInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TUsrInfServiceImpl implements TUsrInfService {

    @Autowired
    TUsrInfMapper TUsrInfMapper;

    public TUsrInf getTUsrInfById(String id) {
        return TUsrInfMapper.queryById(id);
    }
}
