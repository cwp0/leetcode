package interview.DiDi;

/**
 * @Program: Java
 * @Package: interview.DiDi
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/13 19:40
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int left = 0;
        int right = 0;
        int sum = 0, maxLen = 0;
        // 滑动窗口
        while (right < n) {


            sum += a[right];
            // 增大窗口
            right++;

            while(sum > m) {
                sum -= a[left];
                // 缩小窗口
                left++;
            }
            maxLen = Math.max(maxLen, right - left);

        }
        System.out.println(maxLen);

    }
}