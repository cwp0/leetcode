package interview.XieCheng.Autumn;

/**
 * @Program: Java
 * @Package: interview.XieCheng.Autumn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/19 19:00
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            set.add(a[i]);
        }

        if (k == 0) {
            System.out.println(set.size());
            return;
        }

        Arrays.sort(a);

        int left = 0;
        int remain = n;

        while (left < n - m) {
            if (a[left + m - 1] - a[left] <= k) {
                remain--;
                left += m; // 跳过m个数字
            } else {
                break;
            }
        }
        System.out.println(remain);
    }
}