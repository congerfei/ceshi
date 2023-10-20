package com.xl.springboot1start.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {

    /**
     *  类型
     * @return
     */
    String logType() default "";

    /**
     * 操作描述
     */
    String oprDesc() default "";


}
