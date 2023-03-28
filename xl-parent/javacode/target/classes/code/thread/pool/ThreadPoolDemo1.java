package code.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo1 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = getExecutor();

        try {
            for (int i = 1; i <= 10; i++) {
                final int tempInt = i;
                threadPool.execute(() -> {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
                });
            }

            System.out.println("当前核心线程数:"+threadPool.getCorePoolSize()
                    +" 当前池中线程数:"+threadPool.getPoolSize()
                    +" 当前阻塞队列任务数:"+threadPool.getQueue().size());

            Thread.sleep(3000);
            System.out.println("==========================================");
            System.out.println("执行完毕!!!当前核心线程数:"+threadPool.getCorePoolSize()
                    +" 当前池中线程数:"+threadPool.getPoolSize()
                    +" 当前阻塞队列任务数:"+threadPool.getQueue().size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static ThreadPoolExecutor getExecutor() {
        //相当于Executors.newSingleThreadExecutor()
        return new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

}
