package code.io.other;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: xl
 * date :2020/12/29 11:18
 * description:标准输入流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SystemIn {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;

        int by;
        while ((by = is.read()) != -1) {
            System.out.print((char) by);
        }

        is.close();
    }
}
