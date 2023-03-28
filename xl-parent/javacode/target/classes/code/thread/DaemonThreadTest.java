package code.thread;

/**
 * 当用户线程都结束的时候，JVM就会退出，守护线程也随着关闭
 *
 */
public class DaemonThreadTest {



    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                for(;;);
            }
        });

        thread.setDaemon(true);//设置为守护线程，发现main跑完程序就停止了，不设置为守护线程，将在自己的死循环里面一直跑
        thread.start();
        System.out.println("main  run over ");
    }




}
