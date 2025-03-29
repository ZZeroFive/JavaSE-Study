package api.basic.study.newdate;

import java.time.*;

public class DemoNewDateApi {

    // 学习使用JDK 新的时间API
    // 1.表示当前时刻
    public static void demoEpochTime() throws InterruptedException {
        // 时刻是物理时间 不包括任务时区概念
        long epochTime = System.currentTimeMillis();
        System.out.println("当前时刻 " + epochTime);
        //  指定时间戳
        Instant instant1 = Instant.ofEpochMilli(epochTime);
        System.out.println(instant1.toEpochMilli());
        Thread.sleep(1_000);

        // 当前时刻的Java对象表示 获取当前时间戳
        Instant instant2 = Instant.now();
        // 获取时间戳  完成和时间戳的相互转换
        System.out.println(instant2.toEpochMilli());

        //  时间比较
        System.out.println(instant1.isBefore(instant2));
        System.out.println(instant1.isAfter(instant2));

        // 时间计算 以下是相同时间戳
        System.out.println(instant1.plusSeconds(10).toEpochMilli());
        System.out.println(instant1.plus(Duration.ofSeconds(10)).toEpochMilli());
    }

    /**
     * Instant + Zone 信息 ===> ZonedTimeInstant
     * ZonedDateTime 含有时区的时间
     */
    public static void demoZonedDateTme() {
        // 当前时刻 + 东八区时区 = 中国时间
        Instant instant = Instant.now();
        ZonedDateTime chinaDateTime = instant.atZone(ZoneId.of("UTC+08:00"));
        // 西八区 相差16小时
        ZonedDateTime westTime = instant.atZone(ZoneId.of("UTC-08:00"));
        // 直接打印 打印的格式 date.toString()+'T'+time.toString()+offset.toString()+[zoneOffset]
        System.out.println("东八区当前时间 " + chinaDateTime.toString());
        System.out.println("西八区当前时间 " + westTime);
        // 单独打印日期 时间 时区偏移
        System.out.println("东八区日期 " + chinaDateTime.toLocalDate().toString());
        System.out.println("东八区时间 " + chinaDateTime.toLocalTime().toString());
        System.out.println("东八区时区偏移信息 " + chinaDateTime.getOffset().toString());

        // 定义一个纽约时区时间
        ZonedDateTime newYorkTime = instant.atZone(ZoneId.of("America/New_York"));
        System.out.println("纽约时间 " + newYorkTime);

    }
    // ZonedDateTime计算时间
    public static void demoZonedDateTimeCalcTime() {
        Instant instant = Instant.now();
        ZonedDateTime chinaDateTime = instant.atZone(ZoneId.of("UTC+08:00"));
        ZonedDateTime westTime = instant.atZone(ZoneId.of("UTC-08:00"));
        System.out.println("东八区当前时间 " + chinaDateTime);
        System.out.println("西八区当前时间 " + westTime);

        // 比较时间
        System.out.println(chinaDateTime.compareTo(westTime));
        // 相同时间定义：日期、时间、时区都需要相同
        System.out.println(chinaDateTime.equals(westTime));
        System.out.println(chinaDateTime.toEpochSecond() == westTime.toEpochSecond());

        // 加减时间
        System.out.println(chinaDateTime.plus(Duration.ofSeconds(60)));
        System.out.println(westTime.plus(Duration.ofSeconds(60)));

        // 自动换算日期 当前时间是2025-03-29 加3天成为4.1
        System.out.println(chinaDateTime.plusDays(3));

    }

    public static void main(String[] args) throws InterruptedException {
        // demoEpochTime();
        // demoZonedDateTme();
        demoZonedDateTimeCalcTime();
    }
}
