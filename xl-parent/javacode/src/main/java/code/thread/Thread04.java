package code.thread;

/**
 * Author: xl
 * date :2020/12/17 22:29
 * description:设置标志位，让线程停止
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Thread04 implements Runnable {

    boolean flag =true;

    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println("该线程运行"+i++);
        }
        System.out.println("该线程停止");
    }

    public  void  stop(){
        flag=false;
    }


    public static void main(String[] args) {
        Thread04 thread04 = new Thread04();
        Thread thread = new Thread(thread04);
        thread.start();
        for(int i =0;i<1000;i++){
            System.out.println("main线程在跑"+i);
            while (i==10){
                thread04.stop();
                break;
            }
        }
    }
}
