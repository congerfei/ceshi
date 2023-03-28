package code.io.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 12:55
 * description:缓冲流
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class BufferStreamDemo01 {

    //如果ceshi/xl.txt不存在,先用file.FileDemo01,创建文件,随便写点中文
    public static void main(String[] args) throws IOException {
        File file = new File("xl.txt");
        FileReader fr = new FileReader(file);
        BufferedReader bf = new BufferedReader(fr);
        int read;
        while((read =bf.read() )!= -1){
            System.out.print((char)read);
        }
        bf.close();
        fr.close();

    }



}
