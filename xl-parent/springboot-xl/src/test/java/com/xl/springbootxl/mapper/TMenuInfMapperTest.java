package com.xl.springbootxl.mapper;

import com.xl.springbootxl.pojo.TMenuInf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TMenuInfMapperTest {

    @Autowired
    private TMenuInfMapper tMenuInfMapper;

    @Test
    public void testQueryMenuTree(){
        ArrayList<TMenuInf> tMenuInfs = tMenuInfMapper.queryMenuTree();
        for (TMenuInf tMenuInf : tMenuInfs) {
            System.out.println(tMenuInf);
        }
    }



}
