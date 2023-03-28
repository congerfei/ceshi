package code.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 10:53
 * description:字节输入流 ----解决字节流的中文乱码,涉及到了 编码格式,有的中文编码格式占2位,有的占3位,
 *              用得最多得就是一次读取 1024个字节,然后将字节数组通过String得构造器解决
 *                 如果操作的是纯文本文件，优先使用字符流
 *                  如果操作的是图片、视频、音频、应用等二进制文件，优先使用字节流
                    如果不确定文件类型，优先使用字节流，字节流是万能的流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class InputStreamDemo01 {

    public static void main(String[] args) throws IOException {

        File file = new File("xl.txt");// File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
        if (file.exists()) {
            System.out.println("实际文件已存在:"+file.getName());

            FileInputStream fis = new FileInputStream(file);
//            int read = fis.read();
//            System.out.println((char) read);
//            read = fis.read();
//            System.out.println((char) read);//中文是多个字节组合的,所以读取一个字节的时候会出现乱码
            int read;
            while((read = fis.read())>-1){
                //System.out.print(read);//直接输出的都是对应的 ASICC码
                System.out.print((char) read); //输出的是乱码的,如何解决呢? demo02进行解决

            }
            fis.close();
        }else {
            boolean newFile = file.createNewFile();//如果实际不存在,就创建一个,并返回是否创建成功,默认是当前项目下 即 ceshi/xl.txt
            System.out.println("实际文件不存在,但已新建:"+file.getName());

        }
    }

}
