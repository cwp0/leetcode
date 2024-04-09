package ds;

import java.util.ArrayDeque;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestArrayDeque
 * @Description: 学习ArrayDeque
 * @Author: cwp0
 * @CreatedTime: 2024/04/09 20:17
 * @Version: 1.0
 */
public class TestArrayDeque {
    public static void main(String[] args) {
        // 创建ArrayDeque对象
        ArrayDeque<String> deque = new ArrayDeque<>();
        // 添加元素
        deque.add("Java");
        deque.add("Python");
        deque.add("C++");
        deque.add("C#");
        deque.add("JavaScript");
        System.out.println("deque = " + deque);
        // 获取元素
        System.out.println("deque.getFirst() = " + deque.getFirst());
        System.out.println("deque.getLast() = " + deque.getLast());
        // 删除元素
        deque.removeFirst();
        deque.removeLast();
        System.out.println("deque = " + deque);
        // 获取元素个数
        System.out.println("deque.size() = " + deque.size());
        // 判断是否包含某个元素
        System.out.println("deque.contains(\"Python\") = " + deque.contains("Python"));
        // 判断是否为空
        System.out.println("deque.isEmpty() = " + deque.isEmpty());
        // 清空集合
        deque.clear();
        System.out.println("deque = " + deque);
        System.out.println("deque.isEmpty() = " + deque.isEmpty());
    }
}