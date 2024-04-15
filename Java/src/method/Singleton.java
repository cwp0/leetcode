package method;

/**
 * @Program: Java
 * @Package: method
 * @Class: Singleton
 * @Description: 双重检验锁定的方式实现Java单例模式
 * @Author: cwp0
 * @CreatedTime: 2024/04/15 16:46
 * @Version: 1.0
 */
public class Singleton {
    // 详见：https://javaguide.cn/java/concurrent/java-concurrent-questions-02.html#%E5%A6%82%E4%BD%95%E7%A6%81%E6%AD%A2%E6%8C%87%E4%BB%A4%E9%87%8D%E6%8E%92%E5%BA%8F

    // 单例模式中用于保存实例的字段，被声明为volatile，确保对该变量的写入操作会立即反映到所有线程中，这样可以防止可能发生的指令重排序问题。
    private volatile static Singleton uniqueInstance;
    // 私有的构造方法确保该类不能在外部被初始化，只能通过getUniqueInstance()方法获取实例
    private Singleton() {
    }

    // 双重检查锁定的机制，实现对外提供的获取单例实例的方法。
    public static Singleton getUniqueInstance() {
        // 第一层检查：首先检查 uniqueInstance 是否为 null。如果不是 null，意味着实例已经被创建，则直接返回这个实例。
        if (uniqueInstance == null) {
            // 类对象加锁
            synchronized (Singleton.class) {
                // 第二层检查：在同步代码块内再次检查 uniqueInstance 是否为 null。
                // 这种双重检查是为了在等待锁的线程获取到锁后再次确认实例是否已经被创建，因为在等待锁的过程中可能有其他线程已经创建了实例。
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        System.out.println(getUniqueInstance());
    }

}