package code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xl
 * date :2021/1/4 22:58
 * description:测试jvm堆溢出  记得设置启动参数
 *     vm args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *      限制java堆的最大值和最小值的大小设置为20Mb,从而避免自动扩展,
 *      通过参数-XX:+HeapDumpOnOutOfMemoryError 可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
 *    内存溢出：申请内存的时候，内存已经都正在使用
 *    内存泄漏： 占用了内存，但是不使用
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject()); //不停的往list中加
        }
    }

    /**
     *  直接运行main ,以下是堆溢出打印的异常
     * java.lang.OutOfMemoryError: Java heap space
     * Dumping heap to java_pid11164.hprof ...
     * Heap dump file created [28333592 bytes in 0.066 secs]
     *
     * 如何分析解决呢?可以使用jdk自带的工具  D:\Java\jdk1.8.0_191\bin\jvisualvm.exe
     *
     *
     */

}
