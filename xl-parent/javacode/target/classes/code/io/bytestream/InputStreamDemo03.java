package code.io.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 10:53
 * description:
 *      字节流写数据的三种方式
 * 方法	描述
* public void write(int b)	                        写入一个字节
 * public void write(byte[] b)	                    写入一个字节数组
 * public void write(byte[] b, int off, int len)	写入一个字节数组的一部分
 *
 * 字节流读数据的三种方式
 * 方法	描述
 * public abstract int read()	                     读入一个字节
 * public int read(byte[] b)	                     读入一个字节数组
 * public int read(byte[] b, int off, int len)	     读入一个字节数组的一部分
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class InputStreamDemo03 {

    //字节流复制文件的四种方式
    public static void main(String[] args) throws IOException {
        method1();
        method2();
        method3();
        method4();
    }

    // 基本字节流一次读写一个字节
    public static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("sFolder\\demo.txt");
        FileOutputStream fos = new FileOutputStream("dFolder\\demo.txt");

        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        fos.close();
        fis.close();
    }

    // 基本字节流一次读写一个字节数组
    public static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("sFolder\\demo.txt");
        FileOutputStream fos = new FileOutputStream("dFolder\\demo.txt");

        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        fos.close();
        fis.close();
    }

    // 字节缓冲流一次读写一个字节
    public static void method3() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sFolder\\demo.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("dFolder\\demo.txt"));

        int by;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }

        bos.close();
        bis.close();
    }

    // 字节缓冲流一次读写一个字节数组
    public static void method4() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("sFolder\\demo.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("dFolder\\demo.txt"));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        bos.close();
        bis.close();
    }

}
