package code.thread.juc.demo01;

/**
 * Author: xl
 * date :2020/12/19 16:19
 * description:卖票
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<40;i++){ //抢一次就退出没啥意思,让它抢40次
                    ticket.sale();
                }
            }
        },"A线程").start();

        new Thread(()->{
            for (int i =0;i<40;i++){
                ticket.sale();
            }
        },"B线程").start();

        new Thread(()->{
            for (int i =0;i<40;i++){
                ticket.sale();
            }
        },"C线程").start();


    }

}


class Ticket{
    private int  number = 30;

    public synchronized   void sale(){//有的票被抢到了2次,我们加一个锁,本质就是排队
        if(number>0){
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"抢到票了,还剩余"+number--+"张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
