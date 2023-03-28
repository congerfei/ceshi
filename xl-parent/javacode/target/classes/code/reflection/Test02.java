package code.reflection;

/**
 * Author: xl
 * date :2020/12/5 13:25
 * description: 测试Class 获取的三种方式(通过该类的class文件，通过该类的java文件，通过该类已经存在的对象) ，通过User类来演示,三个hashcode证明三种方式获得是同一个
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test02 {

    public static void main(String[] args) {

        User user = new User();

        //方式一，通过已经存在的对象来获得
        Class<? extends User> c1 = user.getClass();
        System.out.println("c1的hashcode:"+c1.hashCode());

        //方式二，通过class文件的形式获取，推荐只用这种来获取该类的Class对象
        Class c2 = User.class;
        System.out.println("c2的hashcode:"+c2.hashCode());

        //方式三，通过反射的形式获得，先可以理解成我们的java文件，如果有错可以再纠正
        try {
            Class<?> c3 = Class.forName("code.reflection.User");
            System.out.println("c3的hashcode:"+c3.hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        //基本的数据类型还可以通过Type来获取
        Class c4 = Integer.TYPE;

        //获取父类类型
        Class c5 = c1.getSuperclass();
        System.out.println("c5的hashcode:"+c5.hashCode());

        //方式四,通过类加载器获取
        ClassLoader classLoader = new Test02().getClass().getClassLoader();
        Class<?> c6 = null;
        try {
            c6 = classLoader.loadClass("code.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("c6的hashcode:"+c6.hashCode());

    }

}
