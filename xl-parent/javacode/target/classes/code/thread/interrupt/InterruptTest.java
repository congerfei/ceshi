package code.thread.interrupt;

/**
 * 了解到sleep为啥可能会抛出InterruptedException异常了，中间可能使用了interrupt()标记了中断
 * interrupt()只会给线程设置一个中断标志，线程仍会继续运行。
 */
public class InterruptTest extends Thread{

    public void run(){
        for (int i = 0 ; i < 5; i++){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("愉快的玩耍" + i);
        }
    }

    public static void main(String[] args){
        InterruptTest test = new InterruptTest();
        test.start();
        test.interrupt();
        System.out.println("线程是否被中断："+ test.isInterrupted());
        System.out.println("线程是否存活：" + test.isAlive());
    }
}
