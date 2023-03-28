package code.thread;

/**
 * A线程调用了B线程的join(),择A线程等待B线程执行完才执行后续的代码
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
