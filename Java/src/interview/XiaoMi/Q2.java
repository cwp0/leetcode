package interview.XiaoMi;

/**
 * @Program: Java
 * @Package: interview.XiaoMi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/05 15:59
 * @Version: 1.0
 */

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int minAIndex = 0, minBIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[minAIndex]) {
                minAIndex = i;
            }
            if (b[i] < b[minBIndex]) {
                minBIndex = i;
            }
        }

        int sameMachineTime = a[minAIndex] + b[minBIndex];

        int diffMachineTime;
        if (minAIndex != minBIndex) {
            diffMachineTime = Math.max(a[minAIndex], b[minBIndex]);
        } else {
            // 找到第二小的机器
            int secMinA = Integer.MAX_VALUE, secMinB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i != minAIndex) {
                    secMinA = Math.min(secMinA, a[i]);
                    secMinB = Math.min(secMinB, b[i]);
                }
            }
            diffMachineTime = Math.min(Math.max(a[minAIndex], secMinB), Math.max(secMinA, b[minBIndex]));
        }


        System.out.println(Math.min(sameMachineTime, diffMachineTime));
    }
}