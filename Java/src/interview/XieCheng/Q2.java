package interview.XieCheng;

import java.util.Scanner;

/**
 * @Program: cloudsim-package
 * @Package: org.cloudbus.fog
 * @Class: Main1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/28 20:28
 * @Version: 1.0
 */

/*
游游拿到了一个数组，她可以进行最多一次操作：选择一个元素全是偶数的区间，使这个区间所有元素除以2。
游游希望最终所有元素之和尽可能大，你能帮帮她吗？

输入描述
第一行输入一个正整数n，代表数组的大小。
第二行输入n个正整数a_i，代表数组的元素。
1<= n<= 10^5
-10^9<= a_i <= 10^9

输出描述
一个整数，代表最终所有元素之和的最大值。

实例
输入
5
8 -4 2 -6 -5
输出
-1
说明
选择区间[-4, 2, -6]，得到[8, -2, 1, -3, -5]，所有元素之和为-1。
 */

public class Q2 {
    // 动态规划求解
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        long[] dp = new long[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        long res = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}