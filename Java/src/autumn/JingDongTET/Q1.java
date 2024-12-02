package autumn.JingDongTET;

/**
 * @Program: Java
 * @Package: autumn.JingDongTET
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/11/30 19:09
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        long low = Long.MIN_VALUE;
        long high = Long.MAX_VALUE;

        for (int i = 0; i < Q; i++) {
            long M = scanner.nextLong();
            long D = scanner.nextLong();

            low = Math.max(low, M - D);
            high = Math.min(high, M + D);

            if (low > high) {
                System.out.println(-1);
                return ;
            }

        }
        System.out.println(high);
    }
}