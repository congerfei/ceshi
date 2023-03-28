package com.xl.springaop.tran;

/**
 * Author: xl
 * date :2020/11/25 18:11
 * description:事务类
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MyTransaction {
    //开启事务
    public void before(){
        System.out.println("开启事务");
    }
    //提交事务
    public void after(){
        System.out.println("提交事务");
    }
}
