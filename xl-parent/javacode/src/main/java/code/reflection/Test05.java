package code.reflection;

/**
 * Author: xl
 * date :2020/12/5 14:32
 * description:类什么时候被初始化？简单说使用了就会被初始化，初始化子类的时候，一定会先初始化父类的
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test05 {

    static{
        System.out.println("main类被初始化了");
    }

    public static void main(String[] args) {
        //主动引用 和反射 都会初始化类
        //Son s = new Son();
        /**
         * 结果：  ---对结果分析，初始化子类的时候，一定会先初始化父类的
         * main类被初始化了
         * 父类被初始化
         * 子类被初始化
         *
         */

        //System.out.println(Son.b);//把main中的其他代码注释掉就这一句运行
        /**
         *  结果：  ----也可以理解成，我们其实没用到子类的东西，这个b就是父类的，所有没有初始化子类Son
         * main类被初始化了
         * 父类被初始化
         * 10
         */

        //Son[] sons = new Son[10];//
        /**
         * 结果：----开辟空间和命名该空间，Son也没有被初始化
         *  main类被初始化了
         */

        System.out.println(Son.M);
        /**
         * 结果： ------常量的加载也没有初始化Son，
         *  main类被初始化了
         *      5
         */

    }


}

class Father{
    static int b = 10;

    static {
        System.out.println("父类被初始化");
    }

}

class Son extends Father{
    static{
        System.out.println("子类被初始化");
    }

    static final int  M = 5;
}
