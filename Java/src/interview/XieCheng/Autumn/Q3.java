package interview.XieCheng.Autumn;

import java.util.Scanner;

/**
 * @Program: Java
 * @Package: interview.XieCheng.Autumn
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/19 19:01
 * @Version: 1.0
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int left = 1, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canAchieve(a, n, k, l, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    // 判断能否通过k次训练达到指定值target
    private static boolean canAchieve(int[] a, int n, int k, int l, int target) {
        int[] dp = new int[n+1];

        int trainings = 0;
        int endWindow = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] < target) {
                if (i > endWindow) {
                    trainings++;
                    endWindow = i + l - 1;
                }
            }
            if (trainings > k) {
                return false;
            }
        }
        return true;
    }
}