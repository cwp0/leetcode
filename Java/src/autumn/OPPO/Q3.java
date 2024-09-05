package autumn.OPPO;

/**
 * @Program: Java
 * @Package: autumn.OPPO
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 19:33
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {

    private static final int MOD =  1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        scanner.close();

        // dp[i][j]表示一个数的前i位数字除以3余数为j的数组
        long[][] dp = new long[n+1][3];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int mod = 0; mod < 3; mod++) {
                if (dp[i][mod] > 0) {
                    if (ch == '?') {
                        if (i == 0) {
                            for (int digit = 1; digit <= 9; digit++) {
                                int newMod = (mod * 10 + digit) % 3;
                                dp[i+1][newMod] = (dp[i+1][newMod] + dp[i][mod]) % MOD;
                            }
                        } else {
                            for (int digit = 0; digit <= 9; digit++) {
                                int newMod = (mod * 10 + digit) % 3;
                                dp[i+1][newMod] = (dp[i+1][newMod] + dp[i][mod]) % MOD;
                            }
                        }
                    } else {
                        int digit = ch - '0';
                        int newMod = (mod * 10 + digit) % 3;
                        dp[i+1][newMod] = (dp[i+1][newMod] + dp[i][mod]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[n][0]);
    }
}