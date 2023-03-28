package com.xl.servlet02maven;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Author: xl
 * date :2020/12/8 19:23
 * description:过滤器测试
 *  写一个过滤器，然后注册进容器中
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class FilterTest implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取初始化参数，这些可以在filter下配置
        String testParam = filterConfig.getInitParameter("百度网址");
        // 输出初始化参数
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 获取客户机的 IP 地址
        String ipAddress = request.getRemoteAddr();
        // 记录 IP 地址和当前时间戳
        System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

        // 把请求传回过滤链
        System.out.println("FilterTest 执行前....");
        filterChain.doFilter(request,response);//让我们的请求继续走，如果不写
        System.out.println("FilterTest 执行后....");
    }

    public void destroy() {
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
        System.out.println("过滤器被销毁了...");
    }
}
