package ds;

import java.util.Deque;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestDeque
 * @Description: 对Deque进行学习
 * @Author: cwp0
 * @CreatedTime: 2024/04/09 20:08
 * @Version: 1.0
 */
public class TestDeque {
    public static void main(String[] args) {
        // 创建Deque对象
        Deque<String> deque = new java.util.LinkedList<>();
        // 添加元素
        deque.addFirst("Java");
        deque.addLast("Python");
        deque.addFirst("C++");
        deque.addLast("C#");
        deque.addFirst("JavaScript");
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

        // 添加元素
        deque.offer("Java");
        // 添加元素
        deque.offerFirst("Python");
        // 添加元素
        deque.offerLast("C++");
        System.out.println("deque = " + deque);
        // 删除元素
        deque.poll();
        // 删除元素
        deque.pollFirst();
        // 删除元素
        deque.pollLast();
        System.out.println("deque = " + deque);
        // 获取元素
        System.out.println("deque.peek() = " + deque.peek());
        // 获取元素
        System.out.println("deque.peekFirst() = " + deque.peekFirst());
        // 获取元素
        System.out.println("deque.peekLast() = " + deque.peekLast());


        // 清空集合
        deque.clear();
        System.out.println("deque = " + deque);
        System.out.println("deque.isEmpty() = " + deque.isEmpty());
    }
}