package com.xl.springaop.proxy;

import com.xl.springaop.tran.MyTransaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: xl
 * date :2020/11/25 18:43
 * description:JDK动态代理类--代理对象能够代理多个目标类，多个目标方法。
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ObjectInterceptor implements InvocationHandler {

    //目标类
    private Object target;
    //切面类（这里指事务类）
    private MyTransaction transaction;

    //通过构造器赋值
    public ObjectInterceptor(Object target,MyTransaction transaction){
        this.target = target;
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        //开启事务
        this.transaction.before();
        //调用目标类方法
        method.invoke(this.target, args);
        //提交事务
        this.transaction.after();
        return null;
    }
}
