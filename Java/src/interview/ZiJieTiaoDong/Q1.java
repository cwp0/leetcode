package interview.ZiJieTiaoDong;

/**
 * @Program: Java
 * @Package: interview.ZiJieTiaoDong
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/20 19:40
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int x = Math.abs(a[1] - a[0]);
            for (int i = 2; i < n; i++) {
                x = gcd(x, Math.abs(a[i] - a[i-1]));
            }
            System.out.println(x);
        }
        scanner.close();
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}