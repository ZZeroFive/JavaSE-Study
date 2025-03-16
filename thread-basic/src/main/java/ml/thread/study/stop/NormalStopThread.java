package ml.thread.study.stop;


/**
 * 停止线程：
 * 正常停止线程，线程通过获取中断请求，响应并退出线程
 *
 */
public class NormalStopThread {


    public static void threadTask() {
        for (int i = 0; i < 50_000; i++) {
            if (Thread.interrupted()) {
                System.out.printf("%s received interrupt request, exit.\n", Thread.currentThread().getName());
                return;
            }
            System.out.printf("i=%d\n", i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(NormalStopThread::threadTask);
        t.setName("normal-stop-thread");
        t.start();

        Thread.sleep(1_00);
        t.interrupt();
        System.out.printf("%s has send interrupt request.", Thread.currentThread().getName());
    }

}
