package interview.WangYi;

/**
 * @Program: Java
 * @Package: interview.WangYi
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/06/20 20:31
 * @Version: 1.0
 */

import java.util.*;

public class Q3 {

    private static final int SIZE = 1001;
    private static final int OFFSET = 500; // 偏移量

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] diff = new int[SIZE][SIZE]; // 将坐标范围从-500～500变为 0~1000

        // 预处理
        for (int i = 0; i < n; i++) {
            int xi = scanner.nextInt() + OFFSET;
            int yi = scanner.nextInt() + OFFSET;
            int ri = scanner.nextInt();

            int left = Math.max(0, xi - ri);
            int right = Math.min(SIZE - 1, xi + ri);
            int top = Math.max(0, yi - ri);
            int bottom = Math.min(SIZE - 1, yi + ri);

            diff[left][top] += 1;
            if (right + 1 < SIZE) diff[right+1][top] -= 1;
            if (bottom + 1 < SIZE) diff[left][bottom+1] -= 1;
            if (right + 1 < SIZE && bottom + 1 < SIZE) diff[right+1][bottom+1] += 1;

        }

        // 构建影响矩阵
        int[][] influence = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i > 0) diff[i][j] += diff[i-1][j];
                if (j > 0) diff[i][j] += diff[i][j-1];
                if (i > 0 && j > 0) diff[i][j] -= diff[i-1][j-1];
                influence[i][j] = diff[i][j];
            }
        }

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int x0 = scanner.nextInt() + OFFSET;
            int y0 = scanner.nextInt() + OFFSET;
            System.out.println(influence[x0][y0]);
        }

        scanner.close();
    }
}