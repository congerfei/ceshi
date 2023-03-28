package code.object;

/**
 * Author: xl
 * date :2020/12/29 10:16
 * description:Object 所有类的父类
 *  方法	描述
 * public boolean equals(Object obj)	表示某个其它对象是否“等于”此对象
 * public final class<?> getClass()	    返回此Object的运行时类
 * public int hashCode()	            返回对象的哈希码值
 * public String toString()	            返回对象的字符串表示形式
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class ObjectTest {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.getClass().getName());
    }
}
