package com.xl.springbootxl.datasource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Author: xl
 * date :2020/12/16 13:23
 * description: 数据库连接测试,导数据库连接的包和druid连接池的包，配置数据库连接参数，写测试类测试数据源
 *              踩过的坑：测试类的包，不在主启动类的同名包下
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {

    @Resource
    DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println(dataSource);
        /**
         * {
         * 	CreateTime:"2020-12-16 13:52:06",
         * 	ActiveCount:0,
         * 	PoolingCount:0,
         * 	CreateCount:0,
         * 	DestroyCount:0,
         * 	CloseCount:0,
         * 	ConnectCount:0,
         * 	Connections:[
         * 	]
         * }
         */

    }

}
