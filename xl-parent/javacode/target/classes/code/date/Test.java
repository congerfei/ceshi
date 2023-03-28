package code.date;

/**
 * Author: Administrator
 * date :2020/8/19/019 20:27
 * description:
 */
public class Test {


    public static void main(String[] args) {
        java.util.Date utilDate=new java.util.Date();

        System.out.println("java.util.Date："+utilDate); //Fri Feb 11 11:01:06 CST 2022
        System.out.println("java.util.Date.getTime()："+utilDate.getTime()); //1644548466770
    }
}
