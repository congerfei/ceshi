package code.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: xl
 * date :2020/12/29 10:24
 * description:按要求格式化 日期
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        //1、将日期格式化为字符串
        Date d = new Date();
        System.out.println("java.util.Date："+d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = sdf.format(d);
        System.out.println(s);

        //2、将字符串格式化为日期
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d2=null;
        try {
            d2 = sdf2.parse("2020-07-15 01:02:03"); //可能转化异常
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(d2);



    }
}
