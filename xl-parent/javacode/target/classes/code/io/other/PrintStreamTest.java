package code.io.other;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Author: xl
 * date :2020/12/29 11:20
 * description:字节打印流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("ps.txt");//打印到当前项目下  /ceshi/ps.txt

        ps.println(97);
        ps.write(97);

        ps.close();
    }
}
