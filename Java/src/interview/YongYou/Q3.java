package interview.YongYou;

/**
 * @Program: Java
 * @Package: interview.YongYou
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/16 19:03
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] snacks = new int[n];

        for (int i = 0; i < n; i++) {
            snacks[i] = scanner.nextInt();
        }

        // dp[i][j]表示区间i,j能获得的最大值
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = snacks[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(snacks[i] - dp[i+1][j], snacks[j] - dp[i][j-1]);
            }
        }
        System.out.println(dp[0][n-1] >= 0 ? "true" : "false");

    }
}