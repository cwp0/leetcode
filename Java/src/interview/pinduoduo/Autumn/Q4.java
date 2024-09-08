package interview.pinduoduo.Autumn;

/**
 * @Program: Java
 * @Package: interview.pinduoduo.Autumn
 * @Class: Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/08 15:06
 * @Version: 1.0
 */
import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            int[][] land = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    land[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < q; i++) {
                int h = scanner.nextInt();
                int w = scanner.nextInt();
                int V = scanner.nextInt();

                int[][] nonCoprime = new int[n][m];
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        if (gcd(land[x][y], V) > 1) {
                            nonCoprime[x][y] = 1;
                        } else {
                            nonCoprime[x][y] = 0;
                        }
                    }
                }

                int[][] preSum = prefixSum(nonCoprime, n, m);

                int count = 0;
                for (int x1 = 1; x1 <= n - h + 1; x1++) {
                    for (int y1 = 1; y1 <= m - w + 1; y1++) {
                        int x2 = x1 + h - 1;
                        int y2 = y1 + w - 1;
                        int areaSum = queryArea(preSum, x1, y1, x2, y2);
                        if (areaSum == h * w) {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
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

    private static int[][] prefixSum(int[][] matrix, int n, int m) {
        int[][] preSum = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = matrix[i-1][j-1] + preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1];
            }
        }
        return preSum;
    }

    private static int queryArea(int[][] preSum, int x1, int y1, int x2, int y2) {
        return preSum[x2][y2] - preSum[x1-1][y2] - preSum[x2][y1-1] + preSum[x1-1][y1-1];
    }

}