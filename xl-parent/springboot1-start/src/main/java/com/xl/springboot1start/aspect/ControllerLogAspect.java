package com.xl.springboot1start.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *    该类不能获取到请求体，因为@RequestBody 接收了，在通过流读取会报错 getInputStream() has already been called for this request
 *    请求体需要自己在controller中打印
 */
@Aspect
@Component
public class ControllerLogAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);
    @Pointcut("execution(* com.xl..controller.*.*(..))")
    public void printLog() {

    }
    /**
     * 会话ID
     */
    private final static String SESSION_TOKEN_KEY = "sessionTokenId";

    @Around("printLog()")
    private Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        String token = java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        MDC. put(SESSION_TOKEN_KEY, token);
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        // 获取请求相关信息
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();

        // 获取调用方法相信
        Signature signature = pjp.getSignature();
        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();

        LOGGER.info("请求开始, {}#{}() URI: {}, method: {}, URL: {}, params: {}", className, methodName, uri, method, url, queryString);
        //result的值就是被拦截方法的返回值
        try {
            //proceed方法是调用实际所拦截的controller中的方法，这里的result为调用方法后的返回值
            Object result = pjp.proceed();
            long endTime = System.currentTimeMillis();
            //定义请求结束时的返回数据，包括调用时间、返回值结果等
            LOGGER.info("请求结束, {}#{}(), URI: {}, method: {}, URL: {}, time: {}ms, result: {} ", className, methodName, uri, method, url, (endTime - startTime), result);
            return result;
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            LOGGER.error("请求出错, {}#{}(), URI: {}, method: {}, URL: {}, time: {}ms", className, methodName, uri, method, url, (endTime - startTime), e);
            throw e;
        }finally {
            MDC. remove(SESSION_TOKEN_KEY);
        }
    }


}