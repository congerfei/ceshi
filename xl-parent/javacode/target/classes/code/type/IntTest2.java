package code.type;

/**
 * Author: xl
 * date :2020/11/20 16:06
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class IntTest2 {
    public static void main(String[] args) {
        int i;
        if (test()) {
            i = 17;
        } //test()编译器无法确认，下面直接输出i 编译会报未初始化变量i ,如果直接if里面填true，则不会编译报错，如果是false，则会报编译错误
        //System.out.println(i);
    }

    static boolean test() {
        return false;
    }
}
