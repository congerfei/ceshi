package com.xl.springbootxl.mapper;

import com.xl.springbootxl.pojo.TUsrInf;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: xl
 * date :2020/12/16 13:55
 * description:测试用户的mapper
 *      整合mabatis：
 *          1.导包  mybatis-spring的整个包  ,并写pojo（建议用lombok） 一定要无参，mybatis用的到
 *          2.配置mapper包扫描,建议配上别名
 *          3.写mapper,,,不要想着数据库字段能和Java类字段对上，实际上只有少部分能对上，绝大部分对不上，老老实实写ResultMap
 *          4.测试 ，如果数据库有，但是返回的为null，检查结果集映射的字段是否写正确
 *          *****注意结果集中的映射 code.type 这是我们的返回对象*****************
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmgTUseInfTest {

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test() {
        //测试是否整合成功
        System.out.println(sqlSession);//org.mybatis.spring.SqlSessionTemplate@73d4066e
    }

    @Test
    public void testQueryById() {
        TUsrInfMapper mapper = sqlSession.getMapper(TUsrInfMapper.class);
        TUsrInf TUsrInf = mapper.queryById("13711111111");
        System.out.println(TUsrInf);
        //sqlSession.close();  整合了springboot 还不被允许关闭......
    }


    @Test
    public void testQuerySmgTUsrInf() {
        TUsrInfMapper mapper = sqlSession.getMapper(TUsrInfMapper.class);
        Map map = new HashMap();
        map.put("pswd","47EC2DD791E31E2EF2076CAF64ED9B3D");

        long start = System.currentTimeMillis();
        List<TUsrInf> TUsrInfs = mapper.querySmgTUsrInf(map);
        long end = System.currentTimeMillis();
        System.out.println("用时:"+(end-start));//查看用了多长的时间 3万5千条数据用时 3秒

        //sqlSession.close();  整合了springboot 还不被允许关闭......
    }

}
