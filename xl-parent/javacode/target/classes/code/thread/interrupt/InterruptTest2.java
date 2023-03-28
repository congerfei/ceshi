package code.thread.interrupt;

/**
 * 如何优雅的停止线程呢
 * 1.捕获该异常
 * 2.或者使用while(!isInterrupted())判断是否有标记 ,如果标记了就break
 */
public class InterruptTest2 extends Thread {

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                sleep(1000);
                System.out.println("愉快的玩耍" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        InterruptTest2 interruptTest2 = new InterruptTest2();
        interruptTest2.start();
        sleep(5000);//主线程休眠一会 等新开的线程跑一会
        interruptTest2.interrupt();


    }


}
