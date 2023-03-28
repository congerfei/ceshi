package code.reflection;

/**
 * Author: xl
 * date :2020/12/5 13:09
 * description:反射
 * 加载完类之后,在堆内存的方法区中就产生了一个 Class?类型的对象(一个类只有个Class对象),这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。这个对象就像一面镜子,透过这个镜子看到类的结构,所以我们形象的称之为:反射
 * 本质理解：得到Class对象后反向获取该类的所有信息
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test01 {

    //通过反射来获取对象
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射来获取对象，类的路劲是手动输入的，所以不确认是否能正常获取，会报异常，这里我们直接抛出即可，系统也不知道对象是啥直接用Class来接收
        Class<?> c1 = Class.forName("code.reflection.User");
        System.out.println(c1); //class code.reflection.User 得到User 的Class对象 这里不是User对象哟，一个类在内存中只有一个Class对象，封装了User的所有信息

    }


}


