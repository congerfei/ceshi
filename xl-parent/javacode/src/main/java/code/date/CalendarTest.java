package code.date;

import java.util.Calendar;

/**
 * Author: Administrator
 * date :2020/8/19/019 19:16
 * description:Calendar  ,将日期当成一个对象，分成许多个属性
 */
public class CalendarTest {

    public static void main(String[] args) {


        //首先获取一个实例化的对象，由于Calendar是抽象类，因此不能new
        Calendar calendar =Calendar.getInstance();
        System.out.println(calendar);//java.util.GregorianCalendar[time=1597835814114,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2020,MONTH=7,WEEK_OF_YEAR=34,WEEK_OF_MONTH=4,DAY_OF_MONTH=19,DAY_OF_YEAR=232,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=7,HOUR_OF_DAY=19,MINUTE=16,SECOND=54,MILLISECOND=114,ZONE_OFFSET=28800000,DST_OFFSET=0]

//获取年份
        int year = calendar.get(Calendar.YEAR);
//获取月份(月份的话需要在原来的基础上+1)
        int month = calendar.get(Calendar.MONTH)+ 1;
//小时--24小时
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
//小时--12小时
        int hour1= calendar.get(Calendar.HOUR);
//分钟
        int minute = calendar.get(Calendar.MINUTE);
//秒
        int second = calendar.get(Calendar.SECOND);
//星期几
        int day = calendar.get(Calendar.DAY_OF_WEEK);
//过去一小时，其他的时间加减处理同理
        calendar.add(Calendar.HOUR, -1);
    }
}
