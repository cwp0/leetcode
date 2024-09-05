package autumn.JingDong;

/**
 * @Program: Java
 * @Package: autumn.JingDong
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/08/24 16:16
 * @Version: 1.0
 */

import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        while (k-- > 0) {
            String s = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean[][] grid = new boolean[n+1][m+1];

            if (s.equals("c")) {
                grid[x][y] = true;
            } else if (s.equals("l")) {
                int result = -1;
                for (int j = y - 1; j >= 1; j--) {
                    if (!grid[x][j]) {
                        result = j;
                        break;
                    }
                }
                System.out.println(result == -1 ? -1 : x + " " + result);
            } else if (s.equals("r")) {
                int result = -1;
                for (int j = y + 1; j <= m; j++) {
                    if (!grid[x][j]) {
                        result = j;
                        break;
                    }
                }
                System.out.println(result == -1 ? -1 : x + " " + result);

            } else if (s.equals("u")) {
                int result = -1;
                for (int i = x - 1; i >= 1; i--) {
                    if (!grid[i][y]) {
                        result = i;
                        break;
                    }
                }
                System.out.println(result == -1 ? -1 : result + " " + y);
            } else if (s.equals("d")) {
                int result = -1;
                for (int i = x + 1; i <= n; i++) {
                    if (!grid[i][y]) {
                        result = i;
                        break;
                    }
                }
                System.out.println(result == -1 ? -1 : result + " " + y);
            }
        }
        scanner.close();
    }
}