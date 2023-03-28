package code.reflection;

/**
 * Author: xl
 * date :2020/12/5 14:02
 * description:类的加载过程,
 *  思考为什么m最后是100？
 *  分析一下输出结果：程序开始跑，”栈“中启动main方法，
 *  加载过程：将class字节码信息，也就是我们类的基本信息（1.静态变量 2.静态方法 3.常量池 4.方法 ...）加载到内存中，
 *  并将这些静态数据转换成方法区的运行时数据，然后封装成一个对应的Class对象存放在 ”堆“中，
 *  链接过程：将jvm类的二进制文件合并到jvm的运行状态之中的过程，省略掉一些我们简单理解就是加载静态对象并赋值（默认都是0），
 *  这些都是方法区中分配的，这就是我们 m的初始值是0的由来
 *  初始化过程：执行类构造器<clinit>()方法的过程，简单理解就是合并静态资源，
 *  我们下面代码就会依次运行 m=300 ，m=100 ,这就是我们的结果m=100的由来
 *
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test04 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /**
         *  输出结果：
         * 静态代码块被加载
         * A的无参构造器被调用
         * 100
         */
    }

}

class A{
    //静态代码块
    static {
        System.out.println("静态代码块被加载");
        m=300;
    }
    static int m=100;


    public A(){
        System.out.println("A的无参构造器被调用");
    }
}
