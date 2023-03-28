package code.net.upload.demo01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Author: xl
 * date :2020/12/29 12:13
 * description:单线程文件上传
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket s = new Socket("127.0.0.1", 10086);
        // 打开本地文件准备上传
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src\\ClientDemo.java"));
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
            bos.flush();
        }
        // 告诉服务器上传结束
        s.shutdownOutput();
        // 接收服务器端的反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine();
        System.out.println("服务器反馈：" + data);
        // 释放资源
        bis.close();
        s.close();
    }
}
