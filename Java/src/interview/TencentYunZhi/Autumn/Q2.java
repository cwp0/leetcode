package interview.TencentYunZhi.Autumn;

/**
 * @Program: Java
 * @Package: interview.TencentYunZhi.Autumn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/12 11:04
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        long left = 1, right = m;
        long res = 1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canDistribute(mid, n, m, k)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    // 小明在分到x个苹果时，是否能合理分配别的苹果
    private static boolean canDistribute(long x, int n, int m, int k) {
        long total = x;
        // 从小明向左边分配
        if (k > 1) {
            long left = k - 1;
            long leftApples = Math.min(x-1, left);
            total += (long) leftApples * (leftApples + 1) / 2;
            total += left - leftApples;
        }

        // 从小明向右边分配
        if (k < n) {
            long right = n-k;
            long rightApples = Math.min(x-1, right);
            total += (long) rightApples * (rightApples + 1) / 2;
            total += right - rightApples;
        }

        return total <= m;
    }

}