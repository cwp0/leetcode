/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: ConcurrentDemo
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/27 19:52
 * @Version: 1.0
 */
public class ConcurrentDemo {
    private static final int MAX_NUMBER = 100;  // 定义最大数字为100
    private static int number = 1;  // 当前要打印的数字，初始值为1
    private static final Object lock = new Object();  // 锁对象，用于线程间的通信

    public static void main(String[] args) {
        // 创建三个线程，每个线程使用不同的threadId（0, 1, 2）
        Thread t1 = new Thread(new PrintTask(1));
        Thread t2 = new Thread(new PrintTask(2));
        Thread t3 = new Thread(new PrintTask(0));

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintTask implements Runnable {
        private int threadId;  // 线程的标识符，用于控制打印顺序

        public PrintTask(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {  // 锁定lock对象，保证同一时刻只有一个线程可以访问
                    // 如果当前数字不能被对应线程处理，则等待
                    while (number % 3 != threadId) {
                        try {
                            lock.wait();  // 当前线程等待，释放锁
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();  // 处理线程中断
                        }
                    }
                    // 如果当前数字超过最大值，通知其他线程并结束循环
                    if (number > MAX_NUMBER) {
                        lock.notifyAll();  // 通知其他所有线程
                        break;  // 退出循环，结束线程
                    }
                    // 打印当前数字并自增
                    System.out.println("Thread-" + threadId + " prints: " + number++);
                    // 唤醒其他等待的线程
                    lock.notifyAll();
                }
            }
        }
    }
}

