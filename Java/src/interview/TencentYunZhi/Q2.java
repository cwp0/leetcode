package interview.TencentYunZhi;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/07/02 20:17
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();

        long left = 1;
        long right = m;
        long res = 0;

        // 二分查找
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isPossable(mid, n, m, k)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }
    private static boolean isPossable(long x, long n, long m, long k) {
        long leftApples = m - x;
        long leftSum = 0;
        if (k > 1) {
            long l = Math.max(1, x - (k - 1));
            long r = x - 1;
            leftSum = (r - l + 1) * (r + l) / 2 + (k - 1) - (r - l + 1);
        }

        long rightSum = 0;
        if (k < n) {
            long l = Math.max(1, x - (n - k));
            long r = x - 1;
            rightSum = (r - l + 1) * (r + l) / 2 + (n - k) - (r - l + 1);
        }
        return leftSum + rightSum <= leftApples;
    }

}