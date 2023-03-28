package com.xl.springaop.service.impl;

import com.xl.springaop.pojo.User;
import com.xl.springaop.service.UserService;

/**
 * Author: xl
 * date :2020/11/25 18:09
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        System.out.println("增加 User");
    }
    @Override
    public void deleteUser(int uid) {
        System.out.println("删除 User");
    }

}
