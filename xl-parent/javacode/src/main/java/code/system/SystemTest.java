package code.system;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * Author: xl
 * date :2020/12/29 10:18
 * description:系统类
 *  方法	描述
 * public static long currentTimeMillis()	    以毫秒为单位返回当前时间
 * public static void exit(int status)	        终止当前运行的Java虚拟机
 * public static void gc()	                    运行垃圾收集器
 * public static String lineSeparator()	        返回依赖于系统的行分隔符字符串
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SystemTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.getenv());//系统的环境变量
    }

    @Test
    public void test01(){
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charset in Use=" + getDefaultCharSet());
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }
}
