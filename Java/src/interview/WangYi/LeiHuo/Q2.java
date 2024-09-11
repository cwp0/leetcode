package interview.WangYi.LeiHuo;

/**
 * @Program: Java
 * @Package: interview.WangYi.LeiHuo
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/11 14:08
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt() + 1;
        int Y = scanner.nextInt() + 1;
        scanner.close();

        int res = X + Y - gcd(X, Y);
        System.out.println(res);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}