package com.xl.springboot1start.aspect;

import com.xl.springboot1start.annotation.MethodLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class MethodLogAspect {

    /**
     *
     * @param joinPoint        获取方法签名，参数等信息
     * @param methodLog      获取注解上的属性
     * @param result        获取返回结果
     */
    @AfterReturning(returning = "result" , pointcut = "@annotation(methodLog)")
    public void afterReturningMethod(JoinPoint joinPoint, MethodLog methodLog, Object result){
        /**
         * 这种可以直接获取属性中的值
         */
        String oprDesc = methodLog.oprDesc();

        /**
         *  1. 可以将业务数据塞进result中，
         *  2. 注解上属性中，比如描述字段使用 ｛0｝｛1｝ ｛2｝... 等
         *  3.然后进行替换
         */
        Map<String,String> logArgsMap = new HashMap<String,String>();
        /**
         * 将result中的业务数据复制给logArgsMap 即可
         */

        String[] logArgs = new String[5];//暂定5个动态数据，一般也够用了

        for (int i = 0; i < logArgs.length; i++) {
            logArgs[i] = logArgsMap.get("logArgs"+i);
            if(logArgs[i]==null){
                break;
            }
            oprDesc  = oprDesc.replace("{"+i+"}",logArgs[i]);
        }


        System.out.println("将数据存进数据库");//isOprLogDao.save()
    }


}
