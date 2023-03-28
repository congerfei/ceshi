package code.math;

/**
 * Author: xl
 * date :2020/11/17 15:39
 * description: Math 的求整数运算
 *  static double ceil(double a)	返回大于或等于 a 的最小整数
 * static double floor(double a)	返回小于或等于 a 的最大整数
 * static double rint(double a)	    返回最接近 a 的整数值，如果有两个同样接近的整数，则结果取偶数
 * static int round(float a)	    将参数加上 1/2 后返回与参数最近的整数
 * static long round(double a)	    将参数加上 1/2 后返回与参数最近的整数，然后强制转换为长整型
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Mathtest {


    public static void main(String[] args) {
        System.out.println(Math.round(-1.5));//
    }
}
