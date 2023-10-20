package code.thread.join;

/**
 * A线程调用了B线程的join(),择A线程等待B线程执行完才执行后续的代码  理解：将b线程加入A线程先跑B线程  再跑A线程
 *
 * 在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，
 * 但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {

    Thread threadOne = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("child threadOne  over!");

        }

    });

    Thread threadTwo = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                threadOne.join();//线程Two中调用线程threadOne的join，那么阻塞到线程A执行完成
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("child threadTwo  over!");

        }

    });


        threadOne.start();
        threadTwo.start();


        System.out.println("启动完，等待子线程完成");

        threadTwo.join();//主线程调用了threadTwo的join方法，此时主线程阻塞了，等待运行完，才运行下面这句话


        System.out.println("all thread run over");





    }





}
