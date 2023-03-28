package code.thread;

/**
 * Author: xl
 * date :2020/12/17 20:35
 * description:多线程
 *      1.继承Thread，重写run（）方法，调用start（）开启线程
 *         总结： 线程开启不一定立即执行，油cpu调度
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Thread01  extends  Thread{

    @Override
    public void run() {
        for (int i = 0;i<200;i++){
            System.out.println("我在看代码"+i++);
        }
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01();
        thread01.start();

        for (int i = 0;i<1000;i++){
            System.out.println("我在学习多线程"+i++);
        }
    }
}
