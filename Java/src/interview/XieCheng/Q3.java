package interview.XieCheng;

import java.util.Scanner;

/**
 * @Program: cloudsim-package
 * @Package: org.cloudbus.fog
 * @Class: Main2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/28 20:34
 * @Version: 1.0
 */

/*
游游拿到了一个 01 矩阵，她每次操作可以选择一个 1*2（1 行 2 列，不能 2 行 1 列）的区域，将所有字符都变成 1。游游想知道，将所有字符都变成 1 需要最少操作多少次？

输入描述
第一行输入两个正整数n,m，用空格隔开。
接下来的n行，每行输入一个长度为m的 01 串，代表游游拿到的矩阵。
2<=n,m <= 1000

输出描述
一个整数，代表游游的最小操作次数。

实例
输入
2 4
1010
1000
输出
4
 */
public class Q3 {
    // 动态规划求最值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i];
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    res += dp[i][j];
                }
            }
        }

        System.out.println(res);
    }


}