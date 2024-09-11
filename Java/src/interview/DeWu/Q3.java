package interview.DeWu;

/**
 * @Program: Java
 * @Package: interview.DeWu
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/11 10:01
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] gifts = new int[n][2];
        int[][] papers = new int[n][2];

        for (int i = 0; i < n; i++) {
            gifts[i][0] = scanner.nextInt();
            gifts[i][1] = scanner.nextInt();
            papers[i][0] = scanner.nextInt();
            papers[i][1] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(gifts, (g1, g2) -> {
            if (g1[0] == g2[0]) return g1[1] - g2[1];
            return g1[0] - g2[0];
        });
        Arrays.sort(papers, (p1, p2) -> {
            if (p1[0] == p2[0]) return p1[1] - p2[1];
            return p1[0] - p2[0];
        });

        long maxK = 0;
        for (int i = 0; i < n; i++) {
            int a = gifts[i][0], b = gifts[i][1];
            int c = papers[i][0], d = papers[i][1];

            long k1 = (a+c-1) / c;
            long k2 = (b+d-1) / d;
            long currentK = Math.max(k1, k2);

            maxK = Math.max(maxK, currentK);
        }

        System.out.println(maxK);
    }


}