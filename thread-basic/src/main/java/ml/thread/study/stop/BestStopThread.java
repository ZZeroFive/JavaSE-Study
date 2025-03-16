package ml.thread.study.stop;


import java.awt.*;

/**
 * 停止线程：
 * 通过异常统一处理中断请求，减少代码冗余
 */
public class BestStopThread {

    private String opType;

    public static void threadTask() {

        try {
            for (int i = 0; i < 50_000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("received interrupt request.");
                    throw new InterruptedException();
                }
                System.out.printf("i=%d\n", i);
            }
        } catch (InterruptedException ex) {
            System.out.println("handle interrupt request.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(BestStopThread::threadTask);
        t.start();

        Thread.sleep(1_00);
        t.interrupt();
        System.out.printf("%s has send interrupt request.\n", Thread.currentThread().getName());
    }
}
