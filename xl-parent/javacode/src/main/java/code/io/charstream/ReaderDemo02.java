package code.io.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Author: xl
 * date :2020/12/22 12:37
 * description:  字符流写数据的五种方式
 * 方法	描述
 * public void write(int c)	写入一个字符
 * public void write(char[] cbuf)	写入一个字符数组
 * public void write(char[] cbuf, int off, int len)	写入一个字符数组的一部分
 * public void write(String str)	写入一个字符串
 * public void write(String str, int off, int len)	写入一个字符串的一部分
 *
 * 字符流读数据的四种方式
 * 方法	描述
 * public int read()	读入一个字符
 * public int read(char[] cbuf)	读入一个字符数组
 * public int read(char[] cbuf, int offset, int length)	读入一个字符数组的一部分
 * public String readLine()	读入一个字符串
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ReaderDemo02 {
        //字符流复制文本的七种方式
        public static void main(String[] args) throws IOException {
            method1();
            method2();
            method3();
            method4();
            method5();
            method6();
            method7();
        }

    // 基本字符流一次读写一个字符
    public static void method1() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("sFolder\\demo.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dFolder\\demo.txt"));

        int ch;
        while ((ch = isr.read()) != -1) {
            osw.write(ch);
        }

        osw.close();
        isr.close();
    }

    // 基本字符流一次读写一个字符数组
    public static void method2() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("sFolder\\demo.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("dFolder\\demo.txt"));

        char[] chs = new char[1024];
        int len;
        while ((len = isr.read(chs)) != -1) {
            osw.write(chs, 0, len);
        }

        osw.close();
        isr.close();
    }

    // 文件字符流一次读写一个字符
    public static void method3() throws IOException {
        FileReader fr = new FileReader("sFolder\\demo.txt");
        FileWriter fw = new FileWriter("dFolder\\demo.txt");

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fw.close();
        fr.close();
    }

    // 文件字符流一次读写一个字符数组
    public static void method4() throws IOException {
        FileReader fr = new FileReader("sFolder\\demo.txt");
        FileWriter fw = new FileWriter("dFolder\\demo.txt");

        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(chs)) != -1) {
            fw.write(chs, 0, len);
        }

        fw.close();
        fr.close();
    }

    // 字符缓冲流一次读写一个字符
    public static void method5() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sFolder\\demo.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("dFolder\\demo.txt"));

        int ch;
        while ((ch = br.read()) != -1) {
            bw.write(ch);
        }

        bw.close();
        br.close();
    }

    // 字符缓冲流一次读写一个字符数组
    public static void method6() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sFolder\\demo.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("dFolder\\demo.txt"));

        char[] chs = new char[1024];
        int len;
        while ((len = br.read(chs)) != -1) {
            bw.write(chs, 0, len);
        }

        bw.close();
        br.close();
    }

    // 字符缓冲流特有功能复制文本文件
    public static void method7() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sFolder\\demo.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("dFolder\\demo.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
