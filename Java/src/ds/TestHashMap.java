package ds;

import java.util.*;

/**
 * @Program: Java
 * @Package: ds
 * @Class: TestHashMap
 * @Description: 对HashMap进行学习
 * @Author: cwp0
 * @CreatedTime: 2024/04/09 13:20
 * @Version: 1.0
 */
public class TestHashMap {
    public static void main(String[] args) {
        // 将字符床s每种字符所对应的index记录在HashMap中。
        String s = "godding";
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                // 为字符c创建新的LinedList
                map.put(c, new LinkedList<>());
            }
            // 将字符c所在的index i 加入c的 LinkedList
            map.get(c).add(i);
        }
        System.out.println(map);
    }
}