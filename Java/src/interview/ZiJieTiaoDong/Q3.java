package interview.ZiJieTiaoDong;

/**
 * @Program: Java
 * @Package: interview.ZiJieTiaoDong
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/20 19:40
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    static final int MOD = 1000000007;
    static final int MAX_N = 20000;
    static long[] fac = new long[MAX_N+1];
    public static void main(String[] args) {
        preCompute();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(calculate(n));
        }


    }

    static long calculate(int n) {
        if (n == 1) return 0;

        long totalSum = 0;

        long fac_n_minus_1 = fac[n-1];
        for (int i = 1; i <= n; i++) {
            long left = i - 1;
            long right = n - i;
            long contribution = (left * (left + 1) / 2 + right * (right + 1) / 2) % MOD;
            contribution = (contribution * fac_n_minus_1) % MOD;
            totalSum = (totalSum + contribution) % MOD;
        }

        return totalSum;
    }

    static void preCompute() {
        fac[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            fac[i] = (fac[i-1] * i) % MOD;
        }
    }

}