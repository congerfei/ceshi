package com.xl.springbootxl.service.impl;


import com.xl.springbootxl.mapper.TMenuInfMapper;
import com.xl.springbootxl.pojo.TMenuInf;
import com.xl.springbootxl.service.TMenuInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 *
 */
@Service
public class TMenuInfServiceImpl implements TMenuInfService {


    @Autowired
    TMenuInfMapper tMenuInfMapper;

    @Override
    public ArrayList<TMenuInf> queryMenuTree() {
        return tMenuInfMapper.queryMenuTree();
    }
}
