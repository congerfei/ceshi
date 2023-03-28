package code.io.other;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: xl
 * date :2020/12/29 11:22
 * description:字符打印流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class PrintWriterTest {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("pw.txt");

        pw.println("hello");
        pw.write("Hello");

        pw.close();
    }
}
