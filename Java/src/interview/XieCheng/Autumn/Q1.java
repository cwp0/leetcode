package interview.XieCheng.Autumn;

/**
 * @Program: Java
 * @Package: interview.XieCheng.Autumn
 * @Class: Q1
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/19 19:00
 * @Version: 1.0
 */
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] treasures = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    treasures[i][j] = j + i * m;
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            // 定义di[i][j][steps]表示到达(i, j)且走steps步所能获得的宝物的最大值。
            int[][][] dp = new int[n][m][k+1];

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0, 0}); // 从(0, 0)开始，走了0步
            int maxValue = treasures[0][0];

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int steps = current[2];

                if (steps == k) continue;

                int currentTreasures = dp[x][y][steps];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        int newTreasures = currentTreasures + treasures[nx][ny];

                        if (newTreasures > dp[nx][ny][steps+1]) {
                            dp[nx][ny][steps+1] = newTreasures;
                            queue.add(new int[]{nx, ny, steps+1});
                            maxValue = Math.max(maxValue, newTreasures);
                        }
                    }
                }
            }
            System.out.println(maxValue);
        }
        scanner.close();
    }

}