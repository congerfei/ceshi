package code.designpatterns.singleton;

/**
 * Author: Administrator
 * date :2020/8/6/006 20:49
 * description:使用静态内部类来实现单例,这是最完美的了
 * 另外表达式的运用，
 */
public class Mgr03 {

    private Mgr03 (){}

    private static class Mgr03Holder{
        private final static Mgr03 mgr03 = new Mgr03();
    }

    public static Mgr03 getInstance(){
        return Mgr03Holder.mgr03;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }

}
