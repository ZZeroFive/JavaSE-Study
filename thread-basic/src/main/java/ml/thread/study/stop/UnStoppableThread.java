package ml.thread.study.stop;

/**
 * 停止线程：
 * 不响应中断请求的线程是无法停止的
 */
public class UnStoppableThread {

    /**
     * 线程任务
     * 打印50万次输出
     */
    public static void threadTask() {
        for (int i = 0; i < 50_000; i++) {
            System.out.printf("i=%d\n", i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(UnStoppableThread::threadTask);
        t.start();

        // 让线程运行0.1秒后向线程发出中断请求
        Thread.sleep(1_00);

        t.interrupt();
        System.out.printf("%s has send interrupt() request.\n", Thread.currentThread().getName());
    }
}
