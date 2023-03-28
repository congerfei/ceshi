package com.xl.controller1;

import com.xl.controller.UserService;

/**
 * Author: xl
 * date :2021/2/17 17:07
 * description: 手写@AutoWired注解
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class UserController {
    @MyAutoWired
    private UserService userService;

    //是不需要设置set/get方法的, 关键的注解实现中有  field.set(userController,o)
    public UserService getUserService() {
        return userService;
    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
