package code.io.file;

import java.io.File;
import java.io.IOException;

/**
 * Author: xl
 * date :2020/12/22 10:34
 * description:文件对象 ,不是很难,具体使用点开Fiel对象,查看对象的属性和方法
 *          File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
 *         java.io.File    专门对文件进行操作的类，只能对文件本身进行操作，不能对文件内容进行操作。
 *         java.io.File    文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class FileDemo01 {

    public static void main(String[] args) throws IOException {

        File file = new File("xl.txt");// File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
        if (file.exists()) {
            System.out.println("实际文件已存在:"+file.getName());
        }else {
            boolean newFile = file.createNewFile();//如果实际不存在,就创建一个,并返回是否创建成功,默认是当前项目下 即 ceshi/readme.txt
            System.out.println("实际文件不存在,但已新建:"+file.getName());
        }






    }
}
