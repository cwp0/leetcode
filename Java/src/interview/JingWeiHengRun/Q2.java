package interview.JingWeiHengRun;

/**
 * @Program: Java
 * @Package: interview.JingWeiHengRun
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/29 15:10
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.println(gcd(a, b) + " " + lcm(a, b));
        scanner.close();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    private static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

}