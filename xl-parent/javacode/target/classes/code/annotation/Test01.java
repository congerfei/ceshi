package code.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xl
 * date :2020/12/5 12:08
 * description:内置注解
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test01 {

    //@Override就是一个重写父类的注解，如果标准在方法上，如果不是继承的方法则会报错
    @Override
    public String toString() {
        return super.toString();
    }

    //过时的注解，这是一个不推荐使用该方法的注解，如果使用就会出现一个划掉的斜杠，但是可以使用，或许有更好的方式
    @Deprecated
    public static void testDeprecated(){
        System.out.println("@Deprecated");
    }

    //镇压警告注解，正常编译，我们下面的方法没有被使用是会被提示的，但是使用完这个后就不会报这个提示了，这个可以使用多处位置，以及有多个参数
    @SuppressWarnings("all")
    public void testSuppressWarning(){
        List list = new ArrayList();
    }


    public static void main(String[] args) {
        testDeprecated();//提示的时候就有一个划掉的斜杠，可能是idea问题，写完了没有斜杠，不纠结这个问题
    }





}
