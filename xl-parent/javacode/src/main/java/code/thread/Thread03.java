package code.thread;

/**
 * Author: xl
 * date :2020/12/17 21:08
 * description:模拟抢票，发现多线程高并发的问题
 *      多线程操作同一个资源的情况下，线程不安全，数据紊乱
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Thread03  implements  Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while(ticketNums>0){
            try {
                //睡0.2s 这里会抛出异常，这里睡0.2秒，为了更好的看清并发造成的多人抢到同一张票
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        Thread03 thread03 = new Thread03();
        new Thread(thread03,"小明").start();
        new Thread(thread03,"老师").start();
        new Thread(thread03,"黄牛党").start();
    }


}
