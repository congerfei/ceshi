package com.xl.mybatis.test;

import com.xl.mybatis.mapper.UserMapper;
import com.xl.mybatis.pojo.User;
import com.xl.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * Author: xl
 * date :2020/12/13 17:03
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TestUser {
    Logger logger = Logger.getLogger(TestUser.class);


    //1.得到sqlSession对象
    SqlSession sqlSession = MybatisUtils.getSqlSession();



    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
    }


    @Test
    public void test1(){
        System.out.println(sqlSession);
    }

    @Test
    public void test2(){
        //得到需要的mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //方式一掌握
        List<User> userList = mapper.getUserList();

        //方式二 了解 ，
        //List<Object> objects = sqlSession.selectList("com.xl.dao.UserMapper.getUserList");

        System.out.println(userList);
        sqlSession.close();//用完记得关闭



    }

    //测试查询 新增
    @Test
    public void test3(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //按id查询
        User user = mapper.getUserById(1);
        System.out.println(user);


        //新增一个
        User user1 = new User();
        user1.setId(4);
        user1.setName("王五");
        user1.setPwd("123456");
        mapper.addUser(user1);
        System.out.println(mapper.getUserList());//检查是添加进去了

        //事务的再次理解,虽然插入了后，直接查也能查出来，但是直接进入数据库检查下 并没有查进去，这就是没有提交事务的原因
        sqlSession.commit();
        sqlSession.close();//用完记得关闭
    }

    //测试删除
    @Test
    public void test4(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //按id查询
        mapper.deleteById(4);
        sqlSession.commit();
        sqlSession.close();//用完记得关闭
    }

    //测试更新
    @Test
    public void test5(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //按id查询
        mapper.updateUser(new User(4,"wangwu","123456"));
        sqlSession.commit();
        sqlSession.close();//用完记得关闭
    }


    //测试只插入2个字段行不行
    @Test
    public void test6(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //新增一个
        User user1 = new User();
        user1.setId(5);
        user1.setName("liuliu");
        mapper.addUser(user1);
        //事务的再次理解,虽然插入了后，直接查也能查出来，但是直接进入数据库检查下 并没有查进去，这就是没有提交事务的原因
        sqlSession.commit();
        sqlSession.close();//用完记得关闭
    }


}
