package api.basic.study.date;

import java.util.Date;
import java.util.TimeZone;

public class DemoDate {

    /**
     * 演示Date 时区有关性 但不是本地时间
     */
    public static void demoZoneRelated() {
        System.out.printf("JVM默认时区信息： %s\n", TimeZone.getDefault());
        Date d = new Date();
        System.out.printf("当前时间: %s\n", d);
        // 格林威治标准时间
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+00:00"));
        System.out.printf("修改JVM默认时区信息：%s\n", TimeZone.getDefault());
        d = new Date();
        System.out.printf("修改时区后的当前时间： %s\n", d);
    }
    public static void main(String[] args) {
        demoZoneRelated();

    }
}
