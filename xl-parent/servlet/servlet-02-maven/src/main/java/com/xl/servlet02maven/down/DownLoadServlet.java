package com.xl.servlet02maven.down;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Author: xl
 * date :2020/12/9 16:20
 * description:测试下载，图片存放再resource下，以后应该是某台服务器的位置
 *          理解一下下载：弹出一个框也就是我们要下载的相关信息，文件名，大小 (如果没有弹出框，浏览器下载的位置设置一下，下载访问就行了)
 *          1.资源路径  String realPath = "...\servlet-02-maven\\src\\main\\resources\\1.jpg";
 *          2.设置resp让浏览器知道这是一个下载请求  resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
 *          3.将服务器资源读取到内存（输入流new FileInputStream(realPath);），将通过将resp的一个输出流，输出到客户端浏览器（resp.getOutputStream()）
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class DownLoadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.要获取下载文件的绝对路径，也就是我们要下载资源的位置
        String realPath = "D:\\congerfei\\code\\ceshi\\xl-parent\\servlet\\servlet-02-maven\\src\\main\\resources\\1.jpg";
        System.out.println("下载文件的路径："+realPath);

        //正常我们是弹出一个下载框，有文件名，大小，
        //2.下载的文件名是啥？截取资源的路径就可以得到文件名字
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        //3.设置想办法让浏览器能够支持下载我们需要的东西，中文文件名设置一下编码URLEncoder.encode(fileName,"UTF-8")，否则可能乱码
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
        //resp.setContentType("application/x-msdownload");// 指明response的返回对象是文件流


        //4.获取下载文件的输入流，将文件读到内存中
        FileInputStream in = new FileInputStream(realPath);
        //5.创建缓冲区
        int len = 0;
        byte[] bufffer = new byte[1024];
        //6.获取OutputStream对象，将流写到磁盘中
        ServletOutputStream out = resp.getOutputStream();
        //7.将FileInputStream流写入到buff缓冲区，使用ServletOutputStream将缓冲区中的数据输出到客户端
        while((len = in.read(bufffer))>0){
            out.write(bufffer,0,len);
        }
        in.close();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
