package code.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Administrator
 * date :2020/8/19/019 18:50
 * description: 对日期格式的一些归纳,
 *  前端一般传的是json串，我们进行解析成字符串，但是日期属性一般是空的，需要我们new一个当前时间存进去，此时如果日期的格式Java类型是string，则可以直接存进去java对象中，然后存进数据库，
 *  如果Java类型是java.util.Date，则需要将字符串进行强转一下   java.util.Date date = sdf.parse("2020-08-19 20:20:20");其中SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
 *   此外还要记住java.util.Date 转换成字符串的方法   String date3=sdf.format(new Date());
 * 不管数据库存的日期什么格式，+
 * 一般我们都是给个将字符串形式的出来，如果数据库存的字符串直接存，日期格式用下面方法转一下
 * String sql1="insert into student"+"(id,date)"+"values("+id111+","+"to_date('2015-02-22 21:35:44','yyyy-mm-dd hh24:mi:ss')";
 */
public class UtilDateTest {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date); //Wed Aug 19 18:51:36 CST 2020

        //可以将毫秒数转成date类型，Date date =new Date(1429339937748l);
        long date2 = System.currentTimeMillis();
        System.out.println(date2);//1597840199012


        System.out.println(date.getTime());//1597840198998  getTime()也是得到long型的当前系统时间
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);//2020-08-19 19:01:21.929  后面是带了毫秒的


        //如果数据存的日期是字符串的
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//设定一个存的方式
        String date3=sdf.format(new Date());
        System.out.println(date3);//2020-08-19 07:06:17   此时直接存进数据库即可

        //如果数据库存的日期是数据库中的date类型的呢,    将字符串强转成date
        try {
            Date d = sdf.parse(date3);
            System.out.println(d.toLocaleString());//2020-8-19 7:23:34
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
