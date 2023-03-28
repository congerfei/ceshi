package code.jvm;

/**
 * Author: xl
 * date :2020/11/17 20:42
 * description:执行一个所谓的java程序的时候，真真正正在执行的是一个叫java虚拟机的进程
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StackstuTest {

    public static void main(String[] args) throws InterruptedException {
        int i = 2;
        int j = 3;
        int k = i + j;

        Thread.sleep(6000);

        System.out.println("hello");
    }

}
