package code.thread.wait;

/**
 *  wait()的作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁
 *  如果不唤醒会一直阻塞着
 */
public class WaitTest  {

    private static Object object=new Object();
    public static void main(String[] args) {
        Thread thread0=new Thread(){
            @Override
            public void run() {
//                尝试延迟2s  比thread1后进入，模拟先使用唤醒后等待场景
//                try {
//                    sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                synchronized (object) {
                    System.out.println(System.currentTimeMillis()+":"+Thread.currentThread().getName()+"进入启动wait");
                    try {
                        object.wait();//使当前线程进入等待（进入Object.wait队列）并释放对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis()+":"+Thread.currentThread().getName()+"线程执行结束");
                }
            }
        };
        thread0.start();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (object) {
                    System.out.println(System.currentTimeMillis()+":"+Thread.currentThread().getName()+"进入启动notify");
                    try {
                        sleep(5000);
                        object.notify();//随机在Object.waitd队列中唤醒一个正在等待该对象锁的线程
                        System.out.println(System.currentTimeMillis()+":"+Thread.currentThread().getName()+"唤醒一个等待的线程");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
    }
}
