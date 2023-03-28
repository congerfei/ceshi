package com.xl.springbootxl.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: xl
 * date :2020/12/16 14:08
 * description:日志测试
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Log4jTest {
    Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    @Test
    public void test(){
        logger.info("INFO：进入测试类");
    }


}
