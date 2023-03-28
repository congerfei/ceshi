package code.io.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 12:37
 * description:  字符流 -----------存在中文的文本文件优先考虑用字符流
 *                  字符流 = 字节流 + 编码表
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ReaderDemo01 {

        //如果ceshi/xl.txt不存在,先用file.FileDemo01,创建文件,随便写点中文
        public static void main(String[] args) throws IOException {
            File file = new File("xl.txt");
            FileReader fr = new FileReader(file);
            int read = fr.read();
            System.out.println((char)read);//直接读取到了一个"我"
            fr.close();

        }

}
