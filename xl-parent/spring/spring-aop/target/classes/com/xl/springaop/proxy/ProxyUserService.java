package com.xl.springaop.proxy;

import com.xl.springaop.pojo.User;
import com.xl.springaop.service.UserService;
import com.xl.springaop.tran.MyTransaction;

/**
 * Author: xl
 * date :2020/11/25 18:14
 * description: User 扩展事务的增强类 ---静态代理的方式---可以对任意一个方法进行增强而不改动其他的方法
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ProxyUserService implements UserService {

    //需要扩展事务的类
    private UserService userService;

    //事务类
    private MyTransaction transaction;

    //使用构造函数实例化
    public ProxyUserService(UserService userService, MyTransaction transaction){
        this.userService = userService;
        this.transaction = transaction;
    }

    @Override
    public void addUser(User user) {
        transaction.before();
        userService.addUser(user);
        transaction.after();
    }

    @Override
    public void deleteUser(int uid) {
        transaction.before();
        userService.deleteUser(uid);
        transaction.after();
    }
}
