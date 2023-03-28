package code.collection.set;

import java.util.Collection;
import java.util.HashSet;

/**
 * Author: xl
 * date :2020/12/29 10:54
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 创建集合
        Collection<Student> collection = new HashSet<Student>();

        // 添加元素
        collection.add(new Student("张三", 20));
        collection.add(new Student("张三", 20));
        collection.add(new Student("李四", 21));
        collection.add(new Student("李四", 21));
        collection.add(new Student("王五", 22));
        collection.add(new Student("王五", 22));
        System.out.println(collection.toString());
    }
}

class Student {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}

