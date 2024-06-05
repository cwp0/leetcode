package interview.Honor;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.Honor
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/05/16 19:15
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int D = scanner.nextInt();
        int T = scanner.nextInt();
        // 动态规划，定义 dp 为在 t 时间内拥有 m 点魔法可以走的最远距离
        int[][] dp = new int[T + 1][M + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // base case
        dp[0][M] = 0; // 第 0 秒最远距离为 0

        int maxDis = 0;

        for (int t = 1; t <= T; t++) {
            for (int m = 0; m <= M; m++) {
                if (dp[t-1][m] >= 0) {
                    // 移动 17 米
                    dp[t][m] = Math.max(dp[t][m], dp[t-1][m] + 17);

                    // 瞬移 60 米
                    if (m >= 10) {
                        dp[t][m-10] = Math.max(dp[t][m-10], dp[t-1][m] + 60);
                    }

                    // 原地不动
                    if (m <= M - 4) {
                        dp[t][m+4] = Math.max(dp[t][m+4], dp[t-1][m]);
                    }

                    maxDis = Math.max(maxDis, dp[t][m]);
                }
            }
        }

        boolean canEscape = false;
        int escapeTime = -1;
        for (int t = 1; t <= T; t++) {
            for (int m = 0; m <= M; m++) {
                if (dp[t][m] >= D) {
                    canEscape = true;
                    escapeTime = t;
                    break;
                }
            }
            if (canEscape) break;
        }

        if (canEscape) {
            System.out.println("YES " + escapeTime);
        } else {
            System.out.println("NO " + maxDis);
        }

    }
}