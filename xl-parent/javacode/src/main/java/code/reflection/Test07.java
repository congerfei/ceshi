package code.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: xl
 * date :2020/12/5 15:13
 * description: 获取类的所有信息：
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class<?> c1 = Class.forName("code.reflection.User");

        //类名
        System.out.println(c1.getName());//获取类的全限名字
        System.out.println(c1.getSimpleName());//获取类的名字

        //属性
        //Field[] fields = c1.getFields();//只能找到public属性
        Field[] fields = c1.getDeclaredFields();//可以找到全部的属性
        for (Field field : fields) {
            System.out.println(field);
        }

        Field name = c1.getDeclaredField("name");//获取指定属性的值，这里需要抛出异常,如上c1.getField("name"),只能指定public的属性
        System.out.println();

        //方法
        Method[] methods = c1.getMethods();//获取子类及其父类的所有public方法
        for (Method method : methods) {
            System.out.println(method);
        }

        Method[] declaredMethods = c1.getDeclaredMethods();//获取本类的所有方法包括私有的
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        Method setName = c1.getDeclaredMethod("setName", String.class);//获取指定的方法，第二个参数是我们方法的参数，防止重载分辨不出

        //获取构造器
        Constructor<?>[] constructors = c1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }


    }
}
