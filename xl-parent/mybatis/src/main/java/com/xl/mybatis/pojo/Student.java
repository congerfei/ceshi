package com.xl.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: xl
 * date :2020/12/15 19:34
 * description: 学生
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Integer id;
    private String name;
    private Teacher teacher;

}
