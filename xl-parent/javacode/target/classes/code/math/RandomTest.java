package code.math;

import java.util.Random;

/**
 * Author: xl
 * date :2020/12/9 11:19
 * description:N位数随机数   生成7位数字符串,随机数不足前面补0
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        //Random.nextInt()方法，是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
//        for (int i =0;i<1000;i++) {
//            int i1 = random.nextInt(9999999);
//            if (i1<1000000){
//                System.out.println("第"+i+"次:"+i1);
//            }
//        }

        //如何确保生成的是7位数呢?
        String num = random.nextInt(9999999)+"";
        StringBuffer sb = new StringBuffer();
        System.out.println(sb);
        for(int i =0;i<7-num.length();i++){ //如果小于7位
            sb.append("0");
        }
        num = sb.toString()+num;//前面补0
        System.out.println(num);

    }


}
