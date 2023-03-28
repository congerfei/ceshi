package com.xl.servlet03servletcontextlistener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/11/24 17:39
 * description: 通过继承HttpServlet，来完成servlet
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MyServlet02 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("MyServlet02准备初始化...");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet02正提供服务...");
    }


    @Override
    public void destroy() {
        System.out.println("MyServlet02开始销毁...");
    }

}
