package interview.MeiTuan.Sec;

/**
 * @Program: Java
 * @Package: interview.MeiTuan.Sec
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 10:01
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        long cost1 = 0; // 偶数变奇数
        long cost2 = 0; // 奇数边偶数的代价

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] % 2 == 0) {
                cost1 += a[i] + 1;
            } else {
                cost2 += a[i] + 1;
            }
        }
        System.out.println(Math.min(cost1, cost2));
    }
}