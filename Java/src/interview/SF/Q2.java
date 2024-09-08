package interview.SF;

/**
 * @Program: Java
 * @Package: interview.SF
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 20:36
 * @Version: 1.0
 */

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test = 0; test < T; test++) {
            int K = scanner.nextInt();
            int t = scanner.nextInt();
            int N = scanner.nextInt();

            int[] x = new int[N];
            int[] y = new int[N];

            for (int i = 0; i < N; i++) {
                x[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                y[i] = scanner.nextInt();
            }

            int maxDistancePerDay = K;
            int currentPosition = 0;

            boolean[] usedEnhance = new boolean[N];
            for (int day = 1; day <= t; day++) {
                currentPosition += maxDistancePerDay;
                for (int i = 0; i < N; i++) {
                    if (x[i] <= currentPosition && !usedEnhance[i]) {
                        maxDistancePerDay = Math.max(maxDistancePerDay, K + y[i]);
                        usedEnhance[i] = true;
                    }
                }
            }
            System.out.println(currentPosition);

        }
        scanner.close();
    }
}