package interview.WangYi;

/**
 * @Program: Java
 * @Package: interview.WangYi
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/06/20 20:05
 * @Version: 1.0
 */

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int[][] buildings = new int[n][4];
        for (int i = 0; i < n; i++) {
            buildings[i][0] = scanner.nextInt(); // ai
            buildings[i][1] = scanner.nextInt(); // bi
            buildings[i][2] = scanner.nextInt(); // ci
            buildings[i][3] = scanner.nextInt(); // vi
        }

        scanner.close();

        long[][][] dp = new long[A+1][B+1][C+1];
        for (int i = 0; i < n; i++) {
            int ai = buildings[i][0];
            int bi = buildings[i][1];
            int ci = buildings[i][2];
            int vi = buildings[i][3];

            for (int a = A; a >= ai; a--) {
                for (int b = B; b >= bi; b--) {
                    for (int c = C; c >= ci; c--) {
                        dp[a][b][c] = Math.max(dp[a][b][c], dp[a-ai][b-bi][c-ci] + vi);
                    }
                }
            }

        }
        System.out.println(dp[A][B][C]);
    }
}