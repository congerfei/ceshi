package code.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Author: xl
 * date :2020/12/21 20:25
 * description:ip
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TestInetAddress {

    public static void main(String[] args) {

        try {
            //查询本机地址
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
            System.out.println("#################");
            System.out.println(inetAddress1); //   /127.0.0.1
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost); //    xl/192.168.137.1
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println(loopbackAddress); // localhost/127.0.0.1

            //查询网站地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println("#################");
            System.out.println("百度IP:"+inetAddress2);



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }


}
