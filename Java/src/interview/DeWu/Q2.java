package interview.DeWu;

/**
 * @Program: Java
 * @Package: interview.DeWu
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/11 10:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            int g = gcd(a, gcd(b, gcd(c, d)));

            if (g == 1) {
                System.out.println(-1);
            } else {
                System.out.println(findSmallestDivisor(g));
            }
        }
        scanner.close();
    }


    // 找出大于1的最小因子
    public static int findSmallestDivisor(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}