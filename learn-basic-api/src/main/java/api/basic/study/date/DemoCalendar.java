package api.basic.study.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DemoCalendar {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");

    /*
    * 该类提供类一些时间基本操作
    * 时间计算操作
    *
    * */

    public static void createCalendar() {

        // 还是基于JVM默认时区获取一个Calendar实例 当前时间戳
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar1.getTime()));
        // 基于指定时区获取Calendar实例 当前时间戳
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+00:00"));
        System.out.println(dateFormat.format(calendar2.getTime()));
        // 前面说过 旧API显示时间时，需要显式指定时区信息
        // 虽然使用不同时区创建类对应Calendar对象，但是Epoch Time还是一致的
        // 在使用simpleDateFormat格式化的时候，没有显示指定时区，还是JVM默认时区
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        System.out.println(dateFormat.format(calendar2.getTime()));
    }
    // 演示获取时间 日期相关信息
    public static void demoGetInfo() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+00:00"));
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.MONTH) == Calendar.MARCH);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY);
        System.out.println(c.getTimeInMillis());
    }
    // 演示比较时间
    public static void demoCompareTime() {
        long epochTime = System.currentTimeMillis();
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 使用指定时间戳创建Calendar对象
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(epochTime);
        System.out.println(dateFormat.format(c.getTimeInMillis()));


        Calendar namedTime = Calendar.getInstance();
        // 1000 * 60 * 60 1 小时
        namedTime.setTime(new Date(epochTime - 60 * 60 * 1000));
        System.out.println(dateFormat.format(namedTime.getTimeInMillis()));

        // 比较时间
        System.out.println(c.before(namedTime));
        System.out.println(c.after(namedTime));
    }

    public static void main(String[] args) {
        //  createCalendar();
        // demoGetInfo();
        demoCompareTime();
    }
}
