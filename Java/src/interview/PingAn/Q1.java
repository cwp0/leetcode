package interview.PingAn;

/**
 * @Program: Java
 * @Package: interview.PingAn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/30 19:59
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] dp = new int[n+1][m+1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= 1) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
                if (j >= 2) dp[i][j] = (dp[i][j] + dp[i-1][j-2]) % MOD;
                if (j >= 3) dp[i][j] = (dp[i][j] + dp[i-1][j-3]) % MOD;
                if (j >= 4) dp[i][j] = (dp[i][j] + dp[i-1][j-4]) % MOD;
            }
        }
        System.out.println(dp[n][m]);
    }
}