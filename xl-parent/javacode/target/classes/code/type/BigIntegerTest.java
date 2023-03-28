package code.type;

import java.math.BigInteger;

/**
 * Author: xl
 * date :2020/12/29 9:58
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class BigIntegerTest {

    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("100");
        BigInteger bi2 = new BigInteger("50");

        // public BigInteger add(BigInteger val)：加
        System.out.println("add:" + bi1.add(bi2));

        // public BigInteger subtract(BigInteger val)：减
        System.out.println("subtract:" + bi1.subtract(bi2));

        // public BigInteger multiply(BigInteger val)：乘
        System.out.println("multiply:" + bi1.multiply(bi2));

        // public BigInteger divide(BigInteger val)：除
        System.out.println("divide:" + bi1.divide(bi2));
    }
}
