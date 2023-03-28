package code.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: xl
 * date :2020/12/5 15:35
 * description: 通过反射动态创建对象，但是必须有无参构造器，因为默认的newInstance()就是调用的无参构造器
 * 这里需要了解下，如果一个类中不写构造器则默认有一个无参构造器，只要写了有参构造器，那么就没有无参构造器了，需要自己手动加一个
 * 思考：那么如果没有无参构造器如何创建对象的呢？
 * 其实也很简单，我们可以通过Class对象获取类的构造器以及属性，自己
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        Class<?> c = Class.forName("code.reflection.User");
        Object o = c.newInstance();//通过反射来获取对象，本质上是调用无参构造器
        User user = (User)o;
        System.out.println(user);

        //如果一个类中只有有参构造器，而无无参构造器，直接通过构造器的newInstance()来创建对象
        Constructor constructor = c.getDeclaredConstructor(String.class, int.class);//这里只能用基本数据类型的吗，为啥使用Integer报错了
        System.out.println("----------");
        User xl =(User) constructor.newInstance("xl", 25);
        System.out.println(xl);

        //通过反射调用普通方法,比如我们不知道类中有哪些方法，正常我们是需要遍历一下方法，然后通过反射的方式来调用方法
        User user3 = (User) c.newInstance();
        Method setName = c.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"congerfei");//invoke激活的意思 个人理解等价于 user3.setName("congerfei");可能我还没有理解其中的好处，到之后看看aop再来回头看看
        System.out.println(user3.getName());

        //通过反射直接调用属性，而不是通过setName,这里我们再Test09中进行测试了，另外注意要关闭权限检验，不然无法操作私有的属性
        User user4 = (User) c.newInstance();
        Field name = c.getDeclaredField("name");//得到属性name
        name.setAccessible(true);//关闭权限检验
        name.set(user4,"aaaaa");//如果没有关闭权限检测,这里会直接报错,因为属性是私有的，
        System.out.println(user4.getName());




    }

}
