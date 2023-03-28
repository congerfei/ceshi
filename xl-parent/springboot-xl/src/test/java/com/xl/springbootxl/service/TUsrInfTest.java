package com.xl.springbootxl.service;

import com.xl.springbootxl.pojo.TUsrInf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TUsrInfTest {

    @Autowired
    private TUsrInfService tUsrInfTest;

    @Test
    public void test(){
        TUsrInf tUsrInfById = tUsrInfTest.getTUsrInfById("13711111111");
        System.out.println(tUsrInfById);
    }



}