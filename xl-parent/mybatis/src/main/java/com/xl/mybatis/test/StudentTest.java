package com.xl.mybatis.test;

import com.xl.mybatis.mapper.StudentMapper;
import com.xl.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Author: xl
 * date :2020/12/15 20:02
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StudentTest {

    Logger logger = Logger.getLogger(TestUser.class);


    SqlSession sqlSession = MybatisUtils.getSqlSession();

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.getStudents();
        sqlSession.close();

    }



}
