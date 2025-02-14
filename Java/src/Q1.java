/**
 * @Program: Java
 * @Package: PACKAGE_NAME
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/19 10:09
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        // "abcabcabc";3
        // "aaaaa"; 1
        // "ababcabcdabcde" 5
        // "abcdebcdecdede" 5
        // s长度不超过1w，给定字符串由英文字母、符号、数字、空格组成

        System.out.println(length("abcabcabc"));
        System.out.println(length("aaaaa"));
        System.out.println(length("ababcabcdabcde"));
        System.out.println(length("abcdebcdecdede"));

    }
    public static int length(String s) {
        int res = 0;

        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(right - left, res);
        }
        return res;
    }

}