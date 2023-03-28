package code.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 想要什么返回结果看 Callable的泛型写的什么
 */
public class Thread05 implements Callable<String> {
    @Override
    public String call() throws Exception {

        return "hello";
    }

    public static void main(String[] args) {
        //创建异步任务，需要传入Callable接口的实现类
        FutureTask<String> futureTask = new FutureTask<>(new Thread05()) ;
        //启动线程
        new Thread(futureTask).start();

        //通过futureTask获取返回结果
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


}
