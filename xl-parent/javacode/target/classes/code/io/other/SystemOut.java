package code.io.other;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Author: xl
 * date :2020/12/29 11:18
 * description:标准输出流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SystemOut {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;

        ps.println("Hello,World");
        ps.write("Hello,World".getBytes());

        ps.close();
    }
}
