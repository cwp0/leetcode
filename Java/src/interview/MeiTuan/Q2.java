package interview.MeiTuan;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.MeiTuan
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/04/13 10:59
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = slidingWindow(s);
        System.out.println(res);
    }

    private static int slidingWindow(String s) {
        int res = 0;
        // 滑动窗口
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> window1 = new HashMap<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 窗口变化后对数据进行处理
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 是否需要缩小窗口
            if (window.containsKey('A') && window.containsKey('B')) {
                if (window.get('A').equals(window.get('B'))) {
                    res = Math.max(right-left, res);
                }
            }
        }

        int left1 = 0, right1 = 0;
        while (right1 < s.length()) {
            char c = s.charAt(right1);
            // 扩大窗口
            right1++;
            // 窗口变化后对数据进行处理
            window1.put(c, window1.getOrDefault(c, 0) + 1);
            // 是否需要缩小窗口
            if (window1.containsKey('A') && window1.containsKey('B')) {
                if (window1.get('A').equals(window1.get('B'))) {
                    res = Math.max(right1 - left1, res);

                    char d = s.charAt(left1);
                    // 缩小窗口
                    left1++;
                    // 窗口变化后对数据进行处理
                    window1.put(d, window1.get(d) - 1);

                }
            }

        }



        return res;
    }

}