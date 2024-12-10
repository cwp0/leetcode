package autumn.JingDongZhaoPinHui;

/**
 * @Program: Java
 * @Package: autumn.JingDongZhaoPinHui
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/12/07 10:17
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] prefix = new long[n];
        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + a[i];
        }

        long total = prefix[n-1];
        long minCost = Long.MAX_VALUE;

        for (int i = 0; i < n-1; i++) {
            long sum1 = prefix[i];
            long sum2 = total - sum1;
            long cost = sum1 * sum2;
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);

    }
}