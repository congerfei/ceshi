package code.io.objectio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Author: xl
 * date :2020/12/29 11:23
 * description:  对象的反序列化,从磁盘读取
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ObjectIn {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));

        Student s = new Student("曹晨磊", 30);
        oos.writeObject(s);

        oos.close();
    }
}
