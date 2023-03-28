package com.xl.servlet02maven;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/11/23 15:10
 * description: 实现Servlet接口，要实现其5个接口方法
 *          使用maven创建好环境后直接实现Servlet，然后注册进web服务器中，也就是我们所说的配置servlet映射
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class MyServlet01 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("MyServlet01正在初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //专门向客服端提供响应的方法
        System.out.println("MyServlet01正在提供服务");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("MyServlet01正在销毁");
    }



}
