package api.basic.study.newdate;

import java.time.Duration;
import java.time.Instant;

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

    public static void main(String[] args) throws InterruptedException {
        demoEpochTime();
    }
}
