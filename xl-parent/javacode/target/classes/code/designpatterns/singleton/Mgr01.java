package code.designpatterns.singleton;

/**
 * Author: Administrator
 * date :2020/8/6/006 20:14
 * description:单例01,恶汉式，加载类的时候就已经加载了，将构造器私有化,提供一个get方法
 *
 */
public class Mgr01 {

    private static final Mgr01  mgr = new Mgr01();

    private Mgr01(){ }

    public static Mgr01 getInstance(){
        return mgr;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1==m2);//true
    }

}
