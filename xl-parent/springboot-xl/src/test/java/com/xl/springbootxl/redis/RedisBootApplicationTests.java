package com.xl.springbootxl.redis;

import com.xl.springbootxl.configs.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {

        // 在企业开发的过程中，我们80%的情况下，都不会使用原生的方式去编写代码
        // 一般我们都去自己封装方法 RedisUtils

        // redisTemp 点出来，封装的 api 和原生操作是一样的
        // opsForValue 操作字符串 类似String
        // opsForSet 操作集合 类似set
        // opsForList 操作列表 类似 list
        // opsForHash 操作哈希 类似Hash
        System.out.println(redisTemplate);
        System.out.println(redisTemplate.opsForValue().get("xl"));


    }

}
