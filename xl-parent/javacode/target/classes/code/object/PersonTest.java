package code.object;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * Author: xl
 * date :2021/1/3 20:38
 * description:测试person的大小,默认都是未开启指针压缩
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class PersonTest {
    @Test
    public void test01(){
        System.out.println(ClassLayout.parseClass(Student.class).toPrintable());
    }

    @Test
    public void test02(){
        System.out.println(ClassLayout.parseClass(Person.class).toPrintable());

        Person p = new Person("小冷",25);
        System.out.println(ClassLayout.parseInstance(p).toPrintable());
    }



}
