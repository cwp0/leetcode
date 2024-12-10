package autumn.JingDongZhaoPinHui;

/**
 * @Program: Java
 * @Package: autumn.JingDongZhaoPinHui
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/12/07 10:17
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.nextLine();
        Map<Character, Integer> priority = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            priority.put(order.charAt(i), i);
        }

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        Arrays.sort(strings, (s1, s2) -> {
            int len1 = s1.length();
            int len2 = s2.length();
            int minLen = Math.min(len1, len2);

            for (int i = 0; i < minLen; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                if (c1 != c2) {
                    return priority.get(c1) - priority.get(c2);
                }
            }
            return len1 - len2;
        });
        for (String str : strings) {
            System.out.println(str);
        }
    }
}