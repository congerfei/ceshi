package code.type;

import org.junit.Test;

/**
 * Author: xl
 * date :2020/11/20 15:06
 * description: Integer.java 类，你会发现有一个内部私有类，IntegerCache.java，它缓存了从-128到127之间的所有的整数对象
 * 所以事情就成了，所有的小整数在内部缓存，然后当我们声明类似——
 * Integer c = 100;
 * 的时候，它实际上在内部做的是：
 * Integer i = Integer.valueOf(100);
 * 现在，如果我们去看valueOf()方法，我可以看到如果值的范围在-128到127之间，它就从高速缓存返回实例。
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class IntegerTest01 {


    @Test
    public void test1(){
        Integer i = 127;
        Integer j = 127;
        System.out.println(i == j); //true

        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b); //false
    }

}
