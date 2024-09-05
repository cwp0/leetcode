public class DeadLockSample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    public void createDeadLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1 get lock1");
                // 让线程1休眠，确保线程2可以获取到lock2
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread1 try get lock2.");
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread2 get lock2");
                // 让线程2休眠，确保线程1可以获取到lock2
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread2 try get lock1.");
                }
            }
        });
        thread1.start();
        thread2.start();

    }
    public static void main(String[] args) {
        DeadLockSample deadLockSample = new DeadLockSample();
        deadLockSample.createDeadLock();

    }
}