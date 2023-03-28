package code.string;

/**
 * Author: xl
 * date :2020/11/20 17:08
 * description: 通过new的一定在堆中创建的对象，栈中创建的引用
 * <p>
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = "abc";//常量池中新建
        String str2 = "abc";//已经存在，常量池中的数据共享，直接指向之前的
        System.out.println(str1 == str2);//true

        String str3 = new String("123");//新建对象在堆中
        String str4 = "123";//常量池中新建
        System.out.println(str3 == str4);//false
    }


}
