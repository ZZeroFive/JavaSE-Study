package api.basic.study.security;


import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 演示SimpleDateFormat的线程安全性
 */
public class DemoSimpleDateFormat {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void setTime1() {
        Calendar c = simpleDateFormat.getCalendar();
        c.set(2024, 3, 30);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" 当前线程时间： " + Thread.currentThread().getName() + " " +simpleDateFormat.format(c.getTime()));
    }

    public static void setTime2() {
        Calendar c = simpleDateFormat.getCalendar();
        c.set(2026, 3, 30);
        System.out.println(" 当前线程时间： " + Thread.currentThread().getName() + " " + simpleDateFormat.format(c.getTime()));
    }

    public static void main(String[] args) throws InterruptedException {
        simpleDateFormat.getCalendar().set(2025, 3,30);
        System.out.println("当前线程 " + Thread.currentThread().getName() + " " + simpleDateFormat.format(simpleDateFormat.getCalendar().getTime()));
        Thread t1 = new Thread(DemoSimpleDateFormat::setTime1);
        t1.setName("[thread-2025-]");
        Thread t2 = new Thread(DemoSimpleDateFormat::setTime2);
        t2.setName("[thread-2026-]");
        t1.start();
        // 保证t1完成对日期对修改
        Thread.sleep(1_00);
        t2.start();
    }
}
