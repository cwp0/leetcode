package interview.Honor.Autumn;

/**
 * @Program: Java
 * @Package: interview.Honor.Autumn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/21 18:58
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int D = scanner.nextInt();
        int T = scanner.nextInt();

        // 定义dp[t][m]为在 t 时间内拥有 m 点魔法值可以走的最远距离
        int[][] dp = new int[T+1][M+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // base case
        dp[0][M] = 0; // 第 0 秒走 0 米，第0秒有M点魔法，不是0点魔法

        int maxDistance = 0;
        // 状态转移
        for (int t = 1; t <= T; t++) {
            for (int m = 0; m <= M; m++) {
                if (dp[t-1][m] >= 0) {
                    // 三种选择：
                    // 不使用魔法，移动17m
                    dp[t][m] = Math.max(dp[t][m], dp[t-1][m] + 17);

                    // 使用魔法，移动60m
                    if (m >= 10) {
                        dp[t][m-10] = Math.max(dp[t][m-10], dp[t-1][m] + 60);
                    }

                    // 原地不动
                    if (m + 4 <= M) {
                        dp[t][m+4] = Math.max(dp[t-1][m], dp[t][m+4]);
                    }

                    maxDistance = Math.max(maxDistance, dp[t][m]);
                }

            }
        }

        boolean canEscape = false;
        int time = 0;
        for (int t = 1; t <= T; t++) {
            for (int m = 0; m <= M; m++) {
                if (dp[t][m] >= D) {
                    canEscape = true;
                    time = t;
                    break;
                }
            }
            if (canEscape) {
                break;
            }
        }

        if (canEscape) {
            System.out.println("YES " + time);
        } else {
            System.out.println("NO " + maxDistance);
        }
    }
}