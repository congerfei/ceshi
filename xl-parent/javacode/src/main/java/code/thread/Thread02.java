package code.thread;

/**
 * Author: xl
 * date :2020/12/17 20:53
 * description: 实现Runnable接口 实现run方法，并将对象传入  new Thread（） 中 执行start（）方法
 *          总结：Thread类也是实现了Runnable ，所有只要实现了Runnable接口就是一条线程
 *
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Thread02 implements  Runnable {
    @Override
    public void run() {
        for (int i = 0;i<200;i++){
            System.out.println("我在看代码"+i++);
        }
    }

    public static void main(String[] args) {
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread02);
        thread.start();

        for (int i = 0;i<1000;i++){
            System.out.println("我在看代码"+i++);
        }
    }
}
