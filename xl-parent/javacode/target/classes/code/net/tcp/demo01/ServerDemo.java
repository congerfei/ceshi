package code.net.tcp.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: xl
 * date :2020/12/29 12:10
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建服务端的ServerSocket对象
        ServerSocket ss = new ServerSocket(10086);
        // 2.侦听要连接到此套接字并接受它
        Socket s = ss.accept();
        // 3.获取输入流对象，读数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("数据是：" + data);
        // 4.释放资源
        s.close();
        ss.close();
    }
}
