package code.net.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: xl
 * date :2020/12/21 22:19
 * description: URL 下载网络上的资源,付费音乐下载实例
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class URLDemo01 {
    public static void main(String[] args) throws Exception{
            URL url = new URL("https://vd2.bdstatic.com/mda-jb0e84zuc4bxyki9/sc/mda-jb0e84zuc4bxyki9.mp4?auth_key=1608563775-0-0-88b211b27999ffbfdd8765b60cc0233e&bcevod_channel=searchbox_feed&pd=1&pt=3&abtest=7873_1-8010_3-8446_2");//有异常要抛出
            System.out.println(url.getProtocol());//协议
            System.out.println(url.getHost());
            //还有其他信息自己玩

            //下载上述地址的资源,包括付费音乐
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //得到输入流,将资源写入内存中
            InputStream  is = httpURLConnection.getInputStream();

            //新建输出流,将资源从内存中写入到本地
            FileOutputStream fos = new FileOutputStream("xl-parent/javacode/src/main/java/code/net/url/ship.mp4");

            byte[] buffer = new byte[1024];//一个字节一个字节写太慢了,建立一个缓冲区
            int len;
            while((len = is.read(buffer))!=-1){//将缓冲区的数据写入内存中,如果返回的值的等于 -1 ,则表示读取完毕
                fos.write(buffer,0,len);//将内存中的数据写入到磁盘中
            }

            System.out.println("下载完成!");

            fos.close();
            is.close();
            httpURLConnection.disconnect();

    }
}
