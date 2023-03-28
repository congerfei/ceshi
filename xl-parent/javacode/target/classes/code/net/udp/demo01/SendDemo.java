package code.net.udp.demo01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Author: xl
 * date :2020/12/29 12:06
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建发送端套接字对象
        DatagramSocket ds = new DatagramSocket();
        // 2.创建数据并把数据打包
        byte[] bys = "Hello,World!".getBytes();
        DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("127.0.0.1"), 10086);
        // 3.从此套接字发送数据包
        ds.send(dp);
        // 4.关闭此数据包的套接字
        ds.close();
    }
}
