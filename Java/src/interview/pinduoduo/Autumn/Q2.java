package interview.pinduoduo.Autumn;

/**
 * @Program: Java
 * @Package: interview.pinduoduo.Autumn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/08 15:06
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];

            long sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum = (sum + arr[i]) % MOD;
            }

            // 先计算最大子数组和
            long maxSubArraySum = maxSubArraySum(arr);

            if (maxSubArraySum > 0) {
                // sum + maxSubArraySum * (2^k - 1) % MOD
                long increment = (modPow(2, k, MOD) - 1 + MOD) % MOD;
                sum = (sum + maxSubArraySum * increment % MOD) % MOD;
            }

            if (sum < 0) {
                sum += MOD;
            }
            System.out.println(sum);
        }
        scanner.close();
    }
    private static long maxSubArraySum(int[] arr) {
        long maxSoFar = arr[0];
        long maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    private static long modPow(long base, int exp, int mod) {
        long res = 1;
        base = base % mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return res;
    }

}