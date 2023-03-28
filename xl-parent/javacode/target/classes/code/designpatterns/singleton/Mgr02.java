package code.designpatterns.singleton;

/**
 * Author: Administrator
 * date :2020/8/6/006 20:23
 * description:懒汉模式，使用的时候才初始化，
 * 带来了线程不安全的问题，如果同时进入if，可以给getInstence加锁synchronized,
 * 可以锁定if里面的new，然后配合双重判断是比较好的
 */
public class Mgr02 {

    private static Mgr02 mgr02;

    private Mgr02(){

    }

    public static Mgr02 getInstance(){
        if(mgr02 == null){
            mgr02 = new Mgr02();
        }
        return mgr02;
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1==m2);//true
    }


}
