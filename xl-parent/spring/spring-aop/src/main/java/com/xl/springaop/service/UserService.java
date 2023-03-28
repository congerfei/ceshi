package com.xl.springaop.service;

import com.xl.springaop.pojo.User;

/**
 * Author: xl
 * date :2020/11/25 18:08
 * description: 需要对此接口扩展事务，其实很简单
 *  1.需要扩展的接口
 *  2.扩展的业务操作，也就是要开启事务
 *  3.将2个接口整合在一起
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public interface UserService {
    //添加 user
    public void addUser(User user);
    //删除 user
    public void deleteUser(int uid);
}
