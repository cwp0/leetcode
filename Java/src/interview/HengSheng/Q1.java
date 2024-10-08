package interview.HengSheng;

/**
 * @Program: Java
 * @Package: interview.HengSheng
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/26 19:28
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long currentS = 0;
        long maxS = -1;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (a[right] > k) {
                left = right + 1;
                currentS = 0;
                continue;
            }

            if (right > left) {
                currentS += gcd(a[right - 1], a[right]);
            }
            maxS = Math.max(maxS, currentS);
        }
        System.out.println(maxS);

    }
    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}