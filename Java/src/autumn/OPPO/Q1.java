package autumn.OPPO;

/**
 * @Program: Java
 * @Package: autumn.OPPO
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 19:33
 * @Version: 1.0
 */

import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long t = scanner.nextLong();
        int[] a = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sum += a[i];
        }

        long goodChoices = 0;
        double lowBound = (sum - t) / 2.0;
        double upperBound = sum / 2.0;

        for (int i = 0; i < n; i++) {
            if (a[i] >= lowBound && a[i] <= upperBound) {
                goodChoices++;
            }
        }
        System.out.println(goodChoices);
    }
}