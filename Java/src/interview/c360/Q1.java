package interview.c360;

/**
 * @Program: Java
 * @Package: interview.c360
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/28 17:14
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        final int MOD = 1000000007;

        // dp[i]表示前i个字符能组成的原串个数
        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 当前字符
            if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9') {
                dp[i] = (dp[i-1] + dp[i]) % MOD;
            }

            // 前两个字符
            int twoDigit = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] = (dp[i] + dp[i-2]) % MOD;
            }

        }
        System.out.println(dp[n]);
    }
}