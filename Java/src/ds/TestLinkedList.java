package ds;

import java.util.LinkedList;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestLinkedList
 * @Description: 对LinkedList中的常用方法进行学习
 * @Author: cwp0
 * @CreatedTime: 2024/04/09 19:59
 * @Version: 1.0
 */
public class TestLinkedList {
    public static void main(String[] args) {
        // 创建LinkedList对象
        LinkedList<String> list = new LinkedList<>();
        // 添加元素
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("C#");
        list.add("JavaScript");
        System.out.println("list = " + list);
        // 获取元素
        System.out.println("list.get(0) = " + list.get(0));
        // 修改元素
        list.set(0, "Java SE");
        System.out.println("list = " + list);
        // 删除元素
        list.remove(0);
        System.out.println("list = " + list);
        // 获取元素个数
        System.out.println("list.size() = " + list.size());
        // 判断是否包含某个元素
        System.out.println("list.contains(\"Python\") = " + list.contains("Python"));
        // 判断是否为空
        System.out.println("list.isEmpty() = " + list.isEmpty());
        // 清空集合
        list.clear();
        System.out.println("list = " + list);
        System.out.println("list.isEmpty() = " + list.isEmpty());
    }
}