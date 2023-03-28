package com.xl.springbootxl.mapper;

import com.xl.springbootxl.pojo.TRlInf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TRlInfMapperTest {

    @Autowired
    private TRlInfMapper tRlInfMapper;

    @Test
    public void testQueryMenuTree(){
        TRlInf tRlInf = tRlInfMapper.queryById("RL001");
        System.out.println(tRlInf);
    }



}
