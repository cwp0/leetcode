package interview.XiaoMi;

/**
 * @Program: Java
 * @Package: interview.XiaoMi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/05 15:47
 * @Version: 1.0
 */

import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[][] dp = new int[n+1][x]; // 前i个元素操作后的和 % x = r的最少次数
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            int num = a[i-1];
            for (int r = 0; r < x; r++) {
                // 删除元素
                dp[i][r] = Math.min(dp[i][r], dp[i-1][r] + 1);

                // 保留元素不加1
                int newMod = (r+num) % x;
                dp[i][newMod] = Math.min(dp[i][newMod], dp[i-1][r]);

                // 保留元素+1
                int newMod1 = (r+num+1) % x;
                dp[i][newMod1] = Math.min(dp[i][newMod1], dp[i-1][r] + 1);

            }
        }
        System.out.println(dp[n][0]);
    }
}