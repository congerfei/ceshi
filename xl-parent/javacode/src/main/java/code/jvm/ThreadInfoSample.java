package code.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 *  输出运行中的各个线程
 *
 *  Monitor Ctrl-Break
 *  Attach Listener
 *  Signal Dispatcher
 *  Finalizer
 *  Reference Handler
 *  main
 */
public class ThreadInfoSample {

    private ThreadInfo threadInfo;

    public ThreadInfoSample() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] ids = bean.getAllThreadIds();

        ThreadInfo[] infos = bean.getThreadInfo(ids);

        for (ThreadInfo info : infos) {

            System.out.println(info.getThreadName());

        }

    }


    public static void main(String[] args) {
        new ThreadInfoSample();
    }
}
