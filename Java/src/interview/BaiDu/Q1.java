package interview.BaiDu;

/**
 * @Program: Java
 * @Package: interview.BaiDu
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/15 19:02
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < T; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            long maxScore = Math.min(k, n-k+1);
            res.append(maxScore).append("\n");
        }
        System.out.println(res);
    }
}