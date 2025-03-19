package ml.thread.study.stop;


/**
 * 停止线程：
 * 当停止处于WAITING、TIMED-WAITING状态当线程时，会出现InterruptedException
 *
 */
public class StopWithException {

    public static void threadTask_TimedWaitingStatus() {
        if (Thread.interrupted()) {
            System.out.printf("%s receive interrupt request.\n", Thread.currentThread().getName());
            return;
        }
        try {
            Thread.sleep(300_000);
        } catch (InterruptedException e) {
            System.out.printf("%s sleep error. isInterrupted: %b\n", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
    }

    public static void demo_threadTask_WaitingStatus() throws InterruptedException {
        Thread t = new Thread(StopWithException::threadTask_TimedWaitingStatus);
        t.setName("waiting-status-thread");

        t.start();


        Thread.sleep(1_000);
        System.out.printf("before send interrupt request, %s status %s\n", t.getName(), t.getState());
        t.interrupt();
        Thread.sleep(1_00);
        System.out.printf("send interrupt request, %s status %s\n", t.getName(), t.getState());
    }

    public static void threadTask_InterruptedAndSleep() {
        for (int i = 0; i < 50_000; i++) {
            System.out.println("i=" + i);
        }

        try {
            Thread.sleep(300_000);
        } catch (InterruptedException e) {
            System.out.printf("%s sleep error. isInterrupted: %b\n", Thread.currentThread().getName(), Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
    }

    public static void demo_threadTask_InterruptedAndSleep() throws InterruptedException {
        Thread t = new Thread(StopWithException::threadTask_InterruptedAndSleep);
        t.setName("waiting-status-thread-2");

        t.start();

        Thread.sleep(1_00);
        System.out.printf("before send interrupt request, %s status %s\n", t.getName(), t.getState());
        t.interrupt();
        System.out.printf("send interrupt request, %s status %s\n", t.getName(), t.getState());
    }

    public static void main(String[] args) throws InterruptedException {
        // demo_threadTask_WaitingStatus();
        demo_threadTask_InterruptedAndSleep();
    }
}
