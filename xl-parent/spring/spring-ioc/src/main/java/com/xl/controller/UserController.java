package com.xl.controller;

/**
 * Author: xl
 * date :2021/2/17 17:07
 * description:使用反射讲解属性注入的原理
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class UserController {
    private UserService userService;


    //第一种方式实现关联注入,自己写set方法
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
