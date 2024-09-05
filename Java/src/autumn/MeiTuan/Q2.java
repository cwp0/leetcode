package autumn.MeiTuan;

/**
 * @Program: Java
 * @Package: autumn.MeiTuan
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 10:45
 * @Version: 1.0
 */

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();

        int n = scanner.nextInt();

        long totalCost = 0;

        long prevX = scanner.nextLong();
        long prevY = scanner.nextLong();

        totalCost += Math.abs(a - prevX) + Math.abs(b - prevY);
        totalCost += Math.abs(c - prevX) + Math.abs(d - prevY);
        for (int i = 1; i < n; i++) {
            long xi = scanner.nextLong();
            long yi = scanner.nextLong();

            totalCost +=  2 * (Math.abs(c - xi) + Math.abs(d - yi));
        }
        System.out.println(totalCost);
        scanner.close();

    }
}