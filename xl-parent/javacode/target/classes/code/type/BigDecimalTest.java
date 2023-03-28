package code.type;

import java.math.BigDecimal;

/**
 * Author: xl
 * date :2020/12/29 9:59
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bd1 = new BigDecimal("0.09");
        BigDecimal bd2 = new BigDecimal("0.01");
        // public BigDecimal add(BigDecimal val)：加
        System.out.println("add:" + bd1.add(bd2));

        BigDecimal bd3 = new BigDecimal("1.0");
        BigDecimal bd4 = new BigDecimal("0.32");
        // public BigDecimal subtract(BigDecimal val)：减
        System.out.println("subtract:" + bd3.subtract(bd4));

        BigDecimal bd5 = new BigDecimal("1.015");
        BigDecimal bd6 = new BigDecimal("100");
        // public BigDecimal multiply(BigDecimal val)：乘
        System.out.println("multiply:" + bd5.multiply(bd6));

        BigDecimal bd7 = new BigDecimal("1.301");
        BigDecimal bd8 = new BigDecimal("100");
        // public BigDecimal divide(BigDecimal val)：除
        System.out.println("divide:" + bd7.divide(bd8));
    }
}
