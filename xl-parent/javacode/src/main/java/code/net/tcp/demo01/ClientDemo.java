package code.net.tcp.demo01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Author: xl
 * date :2020/12/29 12:09
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建客户端的Socket对象
        Socket s = new Socket("127.0.0.1", 10086);
        // 2.获取输出流对象，写数据
        OutputStream os = s.getOutputStream();
        os.write("Hello,World!".getBytes());
        // 3.释放资源
        s.close();
    }
}
