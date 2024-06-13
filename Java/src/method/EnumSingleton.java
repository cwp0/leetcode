package method;

/**
 * @Program: Java
 * @Package: method
 * @Class: EnumSingleton
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/06/13 15:50
 * @Version: 1.0
 */
public enum EnumSingleton {
    INSTANCE;
    public void someMethod() {
        System.out.println("Singleton established.");
    }

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.someMethod();
    }

}