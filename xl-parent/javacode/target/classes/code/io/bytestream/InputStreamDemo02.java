package code.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 10:53
 * description:字节输入流 ----将文件读入内存中
 *              这是为啥呢？没错解码的正是String，查看new String()的源码，String构造方法有解码功能，并且默认编码是utf-8，代码如下：
 *              this.value = StringCoding.decode(bytes, offset, length);再点进decode，循序渐进发现，默认编码是UTF-8
                尽管字节流也能有办法决绝乱码问题，但是还是比较麻烦，于是java就有了字符流，字符为单位读写数据，字符流专门用于处理文本文件。如果处理纯文本的数据优先考虑字符流，其他情况就只能用字节流了（图片、视频、等等只文本例外）。
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class InputStreamDemo02 {

    public static void main(String[] args) throws IOException {

        File file = new File("xl.txt");
        if (file.exists()) {
            System.out.println("实际文件已存在:"+file.getName());

            FileInputStream fis = new FileInputStream(file);
            byte[] len = new byte[1024];
            int read;
            while((read = fis.read(len))>-1){//读取的是多少位字节,但是要输出到控制台或者其他地方就需要指定与文件一致的编码格式
                System.out.println(new String(len));//通过String的构造器将读取的字节输出,解决输出到控制台的乱码问题,String默认会使用utf-8的
            }
            fis.close();
        }else {
            boolean newFile = file.createNewFile();//如果实际不存在,就创建一个,并返回是否创建成功,默认是当前项目下 即 ceshi/xl.txt
            System.out.println("实际文件不存在,但已新建:"+file.getName());

        }
    }

}
