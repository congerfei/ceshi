package code.date;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Author: Administrator
 * date :2020/8/19/019 20:17
 * description: 区别一下几种日期
 *      java.sql.date:  2020-08-19
 *      java.sql.time:   20:44:53
 *      java.sql.timestamp:    2020-08-19 20:44:53.174
 */
public class SqlDateTest {


    public static void main(String[] args) {



        Date date =new Date(System.currentTimeMillis());//没有无参构造器，只有一个long参数的构造器，new java.util.Date().getTime()也是long型的当前系统时间,可以作为参数
        System.out.println("date:"+date);//2020-08-19  获得到知道日的一个日期，所以如果需要具体时分秒的是不考虑这种的

        Time time =new Time(System.currentTimeMillis());//也是只有一个long参数的构造器
        System.out.println("time:"+time);//20:42:18   得到的是时分秒

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());//也是只有一个long参数的构造器
        System.out.println("timestamp:"+timestamp); //2020-08-19 20:44:53.174

        Date date2 =new Date(20220210);
        System.out.println("date2:"+date2);

    }


}
