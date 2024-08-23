package method;

/**
 * @Program: Java
 * @Package: method
 * @Class: ProducerConsumerExample
 * @Description: 实现生产者消费者模型
 * @Author: cwp0
 * @CreatedTime: 2024/08/22 20:46
 * @Version: 1.0
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerExample {

    // 定义缓冲区的容量
    private static final int BUFFER_CAPACITY = 10;

    // 创建一个共享缓冲区
    private final BlockingQueue<Integer> buffer = new LinkedBlockingQueue<>(BUFFER_CAPACITY);

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        // 启动生产者线程
        new Thread(example.new Producer()).start();

        // 启动消费者线程
        new Thread(example.new Consumer()).start();
    }

    // 生产者类
    class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                try {
                    produce(value++);
                    Thread.sleep(1000); // 模拟生产过程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void produce(int value) throws InterruptedException {
            // 将产品放入缓冲区，若缓冲区满则等待
            buffer.put(value);
            System.out.println("Produced: " + value);
        }
    }

    // 消费者类
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    consume();
                    Thread.sleep(1500); // 模拟消费过程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void consume() throws InterruptedException {
            // 从缓冲区中取出产品，若缓冲区空则等待
            int value = buffer.take();
            System.out.println("Consumed: " + value);
        }
    }
}

