package com.xl.mybatis.test;

import com.xl.mybatis.mapper.TeacherMapper;
import com.xl.mybatis.pojo.Teacher;
import com.xl.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * Author: xl
 * date :2020/12/15 20:05
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TeacherTest  {

    Logger logger = Logger.getLogger(TestUser.class);

    SqlSession sqlSession = MybatisUtils.getSqlSession();

    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = teacherMapper.getTeachers();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();

    }



}
