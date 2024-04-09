package ds;

import java.util.*;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestHashSet
 * @Description: 对HashSet进行学习
 * @Author: cwp0
 * @CreatedTime: 2024/04/09 14:27
 * @Version: 1.0
 */
public class TestHashSet {
    public static void main(String[] args) {
        // HashSet 主要用来将一些元素进行去重后存取。
        HashSet<String> set = new HashSet<>();

        // add() 方法用来添加元素
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("apple"); // 重复元素不会被添加
        System.out.println(set);
        set.remove("banana"); // remove() 方法用来删除元素
        System.out.println(set);
        set.add("banana");
        System.out.println("size: " + set.size()); // size() 方法用来获取元素个数

        //使用for-each遍历
        for (String s : set) {
            System.out.println(s);
        }

        set.clear(); // clear() 方法用来清空集合
        System.out.println(set);


    }
}