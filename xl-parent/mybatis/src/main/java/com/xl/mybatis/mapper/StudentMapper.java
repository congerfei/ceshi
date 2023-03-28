package com.xl.mybatis.mapper;

import com.xl.mybatis.pojo.Student;

import java.util.List;

/**
 * Author: xl
 * date :2020/12/15 20:00
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public interface StudentMapper {

    List<Student> getStudents();

}
