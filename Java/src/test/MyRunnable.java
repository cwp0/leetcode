package test;


import java.util.Date;

/**
 * @Program: Java
 * @Package: test
 * @Class: MyRunnable
 * @Description: 测试线程池
 * @Author: cwp0
 * @CreatedTime: 2024/05/17 19:52
 * @Version: 1.0
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + "End. Time = " + new Date());

    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}