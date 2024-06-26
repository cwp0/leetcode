package interview.Tencent;

import java.util.*;

/**
 * @Program: Java
 * @Package: interview.Tencent
 * @Class: Q5
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 21:25
 * @Version: 1.0
 */

/*
3 3
1 2 3
1 2 3
1 2 3
RPR
PRP
RPR
 */

public class Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] values = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i][j] = in.nextInt();
            }
        }

        in.nextLine(); // 注意这里的关键是这里nextInt()后的换行。
        char[][] colors = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            for (int j = 0; j < m; j++) {
                colors[i][j] = line.charAt(j);
                System.out.println(colors[i][j]);
            }
        }



    }
}