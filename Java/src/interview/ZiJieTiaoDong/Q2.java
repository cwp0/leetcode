package interview.ZiJieTiaoDong;

/**
 * @Program: Java
 * @Package: interview.ZiJieTiaoDong
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/20 19:40
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    static int n, m, ex, ey;
    static int[][] grid;
    static boolean[][] visited;
    static long[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ex = scanner.nextInt() - 1;
        ey = scanner.nextInt() - 1;

        grid = new int[n][m];
        dp = new long[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j) - '0';
                dp[i][j] = Long.MAX_VALUE;
            }
        }

        bfs();

        long p = 0;
        long q = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] != Long.MAX_VALUE) {
                    p += dp[i][j];
                    q++;
                }
            }
        }

        long gcd = gcd(p, q);
        System.out.println((p / gcd) + " " + (q / gcd));
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ex, ey});
        dp[ex][ey] = 0;
        visited[ex][ey] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dp[nx][ny] = dp[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0;
    }

}