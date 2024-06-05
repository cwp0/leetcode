package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @Program: Java
 * @Package: test
 * @Class: ThreadPoolExecutorDemo
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/05/17 20:01
 * @Version: 1.0
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5; // 线程池的核心线程数量
    private static final int MAX_POOL_SIZE = 10; // 线程池中最大的线程数量
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L; // 当线程池中的线程数量大于CORE_POOL_SIZE时，如果没有新任务提交，核心线程外的线程不会立即销毁，而是会等待KEEP_ALIVE_TIME后才销毁

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finish all Thread!");

    }

}