package interview.TencentMusic;

/**
 * @Program: Java
 * @Package: interview.TencentMusic
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/05 19:01
 * @Version: 1.0
 */
public class Q3 {
    public int matrixCount (String[] a, int myval) {
        int n = a.length;
        int res = 0;

        int[][] prefixR = new int[n+1][n+1];
        int[][] prefixE = new int[n+1][n+1];
        int[][] prefixD = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = a[i-1].charAt(j-1);
                prefixR[i][j] = prefixR[i-1][j] + prefixR[i][j-1] - prefixR[i-1][j-1] + (ch == 'r' ? 1 : 0);
                prefixE[i][j] = prefixE[i-1][j] + prefixE[i][j-1] - prefixE[i-1][j-1] + (ch == 'e' ? 1 : 0);
                prefixD[i][j] = prefixD[i-1][j] + prefixD[i][j-1] - prefixD[i-1][j-1] + (ch == 'd' ? 1 : 0);
            }
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int size = 1; i + size - 1 <= n && j + size - 1 <= n; size++) {
                    int rCount = getSum(prefixR, i, j, i+size-1, j+size-1);
                    int eCount = getSum(prefixE, i, j, i+size-1, j+size-1);
                    int dCount = getSum(prefixD, i, j, i+size-1, j+size-1);

                    int minCount = Math.min(rCount, Math.min(eCount, dCount));
                    if (minCount >= myval) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private int getSum(int[][] prefix, int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1];
    }

}