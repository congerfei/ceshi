package code.io.objectio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Author: xl
 * date :2020/12/29 11:23
 * description:  对象的序列化,保存到磁盘上
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ObjectOut {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("oos.txt"));

        Student s = new Student("曹晨磊", 30);
        oos.writeObject(s);

        oos.close();
    }
}

class Student implements Serializable {
    private static final long serialVersionUID = 5923003911550370832L;
    private String name;
    private Integer age;

    public Student() {
        super();
    }

    public Student(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
