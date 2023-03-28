package com.xl.servlet01;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: xl
 * date :2020/11/23 12:34
 * description: servlet 测试 ,手写class以及web.xml文件  放进tomcat文件夹中
 *  1.com.xl包下编写MyServlet类继承GenericServlet，并重写service（）方法，
 *  2.通过maven或者Java直接编译，得到.class文件
 *  3.tomcat的webapp文件夹下新建一个项目 firstServlet，下面新建一个WEB-INF/classes   文件夹，
 *          注意点：因为我们包在com.xl下面，所有我们class文件也要在这个下面 WEB-INF/classes/com/xl/下面即可
 *  4.WEB-INF下新建web.xml文件，这里面信息我先放在resource/web.xml里面,也就是一个servlet 一个servletMapping
 *  5.启动tomcat， bin/startup.bat 双击即可，前提是配好环境变量、
 *  6.访问http://localhost:8080/firstServlet/my
 *      其中firstServlet是webapp下面我们新建的文件夹，也就是我们的项目，/my 是servletMapping中配置的
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */

public class MyServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //得到输出流PrinterWriter对象，Servlet使用输出流来产生响应
        PrintWriter out = servletResponse.getWriter();
        //使用输出流对象向客户端发送字符
        out.println("XXXXX");//XX表示在客户端显示的内容
        out.close();
    }
}
