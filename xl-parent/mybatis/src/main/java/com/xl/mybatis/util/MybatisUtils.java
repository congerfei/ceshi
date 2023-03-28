package com.xl.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: xl
 * date :2020/12/13 16:43
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MybatisUtils {

    static SqlSessionFactory sqlSessionFactory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取mybatis关键配置文件失败！");
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();

    }


}
