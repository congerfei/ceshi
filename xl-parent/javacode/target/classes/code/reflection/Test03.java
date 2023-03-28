package code.reflection;

import java.lang.annotation.ElementType;

/**
 * Author: xl
 * date :2020/12/5 13:43
 * description:所有类型的Class对象
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Test03 {

    public static void main(String[] args) {

        Class c1 = Object.class;
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class; //一维数组
        Class c4 = int[].class;//二维数组
        Class c5 = Override.class;//注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;//包装类
        Class c8 = Void.class;
        Class c9 =  Class.class;

        //操作很简单，sout输出语句写好，Ctrl+d复制行，先在上面按住Alt，选中c1,鼠标往下拉选就行了，同理复制过来
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        /**
         *  结果
         * class java.lang.Object
         * interface java.lang.Comparable
         * class [Ljava.lang.String;
         * class [I
         * interface java.lang.Override
         * class java.lang.code.annotation.ElementType
         * class java.lang.Integer
         * class java.lang.Void
         * class java.lang.Class
         */

        //学过反射，我们应该这下面的值应该是一样的，举一反三的能力
        //只要元素类型和维度是一样的就是同一个Class对象
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());


    }


}
