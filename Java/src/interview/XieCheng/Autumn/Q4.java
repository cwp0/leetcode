package interview.XieCheng.Autumn;

/**
 * @Program: Java
 * @Package: interview.XieCheng.Autumn
 * @Class: Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/19 19:01
 * @Version: 1.0
 */
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int p = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int left = 0, right = (int) 2e9;
        while (left < right) {
            int mid = (left + right) / 2;
            if (canAchieve(mid, a, b, p)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    // 判断可否在limit时间下分配通行证
    private static boolean canAchieve(int limit, int[] a, int[] b, int p) {
        int n = a.length;
        int k = b.length;

        for (int i = 0, j = 0; i < n; i++) {
            if (j >= k) {
                return false;
            }
            while (j < k && Math.abs(a[i] - b[j]) + Math.abs(b[j] - p) > limit) {
                j++;
            }
            if (j >= k) {
                return false;
            }
            j++;
        }
        return true;
    }
}