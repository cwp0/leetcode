package interview.HeMa;

/**
 * @Program: Java
 * @Package: interview.HeMa
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/09 19:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((i-j) % 2 == 0 || (i-j) % 5 == 0) {
                    if (dp[j] != Long.MIN_VALUE) {
                        dp[i] = Math.max(dp[i], dp[j] + a[i]);
                    }
                }
            }
        }

        long res = Long.MIN_VALUE;
        for (int i = n-5; i < n; i++) {
            if (i >= 0 && dp[i] != Long.MIN_VALUE) {
                res = Math.max(res, dp[i]);
            }
        }

        if (res == Long.MIN_VALUE) {
            res = 0;
        }
        System.out.println(res);
    }
}