package code.string;

/**
 * Author: xl
 * date :2020/12/29 10:08
 * description:可变String
 * StringBuffer	    StringBuilder
 * 内容可以变	    内容可以变
 *  线程安全	        线程不安全
 * 多线程操作字符串	单线程操作字符串
 *
 * 1、 StringBuilder 或 StringBuffer 的初始化分配的空间大小取决于调用的构造方法：
 * 无参构造默认大小为 16
 * 调用 int 类型参数构造，初始化大小为指定的 int 值。（更推荐这种方式，可以减少扩容次数，提高效率。）
 * 调用 String 类型或 CharSequence 类型参数的构造，初始化大小为：字符序列的长度 + 16
 * 2、扩容机制每次扩容大小为：原数组大小 * 2 + 2
 * 3、补充：
 * StringBuilder 调用 length() 方法时，返回值为有效字符个数，它的源码如下：
 * @Override
 * public int length() {
 *    return count;
 * }
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StringTest04 {
    public static void main(String[] args) {
        //线程安全的
        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb.toString());

        //线程不安全的
        StringBuilder sbu = new StringBuilder();
        sbu.append("Hello");
        sbu.append(" ");
        sbu.append("World");
        System.out.println(sb.toString());
    }
}
