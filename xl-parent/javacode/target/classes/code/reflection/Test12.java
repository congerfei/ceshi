package code.reflection;


import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Author: xl
 * date :2020/12/5 16:51
 * description:反射来操作注解
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test12 {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("code.reflection.Student");

        //通过反射获得注解,@Retention(RetentionPolicy.RUNTIME),一定要是RUNTIME，否则是得不到的
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);//@code.reflection.TableXL(value=db_student),通过这个测试知道只能获取类上的
        }

        //如何得到注解里面的值？
        Annotation annotation = c.getAnnotation(TableXL.class);
        //强转一下
        TableXL tableXL = (TableXL) annotation ;
        String value = tableXL.value();
        System.out.println(value);//db_student

        //获取属性上的
        Field name = c.getDeclaredField("name");
        //Annotation annotation2 = c.getAnnotation(FiledXL.class);//直接通过这种是获取不了属性上的注解的
        Annotation nameAnnotation = name.getAnnotation(FiledXL.class);//得到name上的@FiledXL注解
        FiledXL filedXL = (FiledXL) nameAnnotation;
        System.out.println(filedXL.columnName());//db_name
        System.out.println(filedXL.type());//varchar
        System.out.println(filedXL.length());//3

        //获取方法上注解，可以自己试试

    }
}

//添加一个类名的注解
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableXL{
    String value();
}
//添加一个属性的注解
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledXL{
    String columnName();//表的字段名
    String type(); //字段类型
    int length();//字段的大小
}


@TableXL(value = "db_student")
class Student{
    @FiledXL(columnName = "db_id",type = "int",length = 10)
    private int id;
    @FiledXL(columnName = "db_age",type = "int",length = 10)
    private int age;
    @FiledXL(columnName = "db_name",type = "varchar",length = 3)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
