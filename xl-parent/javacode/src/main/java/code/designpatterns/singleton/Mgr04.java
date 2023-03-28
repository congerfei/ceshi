package code.designpatterns.singleton;

/**
 * 枚举，不仅可以使用线程同步，还可以防止反序列化
 */
public enum Mgr04 {

    MGR04;

    public static void main(String[] args) {
        for (int i=0;i<100;i++){
            new Thread(()->{
                System.out.println(Mgr04.MGR04.hashCode());
            }).start();
        }
    }


}
