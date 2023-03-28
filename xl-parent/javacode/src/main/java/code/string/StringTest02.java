package code.string;

/**
 * Author: xl
 * date :2020/12/29 10:04
 * description: 测试String 构造方法
 * public String()	初始化构造一个空白字符串
 * public String(char[] value)	通过字符数组初始化字符串
 * public String(byte[] bytes)	通过使用平台的默认字符集解码指定的字节数组来构造新的String
 * public String(byte[] bytes, Charset charset)	通过使用自定义的字符集解码指定的字节数组来构造新的String
 * public String(StringBuffer buffer)	字符串缓冲区的内容被复制，重新分配一个新的字符串
 * public String(StringBuilder builder)	字符串构建器的内容被复制，重新分配一个新的字符串
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StringTest02 {

    public static void main(String[] args) {
        new String();
        System.out.println(new String(new byte[]{'b', 'c', 'd'}));
    }
}
