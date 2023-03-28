package code.reflection;

import java.lang.reflect.Field;

/**
 * Author: xl
 * date :2020/12/5 16:14
 * description:测试一下反射的好处,我们类中没有getName，setName方法，直接利用反射通过name.set(teacher,"xl")来给对象赋值
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test09 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class c = Teacher.class;
        Teacher teacher =(Teacher) c.newInstance();

        //获取属性
        Field name = c.getDeclaredField("name");
        //关闭权限检测
        name.setAccessible(true);
        name.set(teacher,"xl");
        System.out.println(teacher);

    }
}

class Teacher{
    private String name;
    private Integer id;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
