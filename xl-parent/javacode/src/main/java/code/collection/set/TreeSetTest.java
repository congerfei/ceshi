package code.collection.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Author: xl
 * date :2020/12/29 10:56
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class TreeSetTest {
    public static void main(String[] args) {
        // 创建集合
        Collection<Student> collection = new TreeSet<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // 主要条件
                int sort1 = s1.getAge() - s2.getAge();
                // 次要条件
                int sort2 = sort1 == 0 ? s1.getName().compareTo(s2.getName()) : sort1;
                return sort2;
            }
        });

        // 添加元素
        collection.add(new Student("王五", 22));
        collection.add(new Student("王五", 22));
        collection.add(new Student("张三1", 20));
        collection.add(new Student("张三0", 20));
        collection.add(new Student("李四0", 18));
        collection.add(new Student("李四1", 18));
        System.out.println(collection.toString());
    }
}
