package interview.QuNa;

/**
 * @Program: Java
 * @Package: interview.QuNa
 * @Class: Q3
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 14:38
 * @Version: 1.0
 */
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] fatigue = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fatigue[i][j] = scanner.nextInt();
                if (fatigue[i][j] == -1) {
                    fatigue[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int start = 0; start < n; start++) {
            int[] res = new int[m];
            Arrays.fill(res, -1);

            bfs(fatigue, start, n, m, res);

            for (int time = 0; time < m; time++) {
                System.out.print(res[time] + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int[][] fatigue, int start, int n, int maxTime, int[] res) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0, 0});

        int[][] dp = new int[n][maxTime+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currStation = curr[0];
            int currTime = curr[1];
            int currFatigue = curr[2];

            if (currTime > maxTime) continue;

            if (currStation == start && currTime > 0 && currTime <= maxTime) {
                if (res[currTime-1] == -1 || currFatigue < res[currTime-1]) {
                    res[currTime-1] = currFatigue;
                }
            }

            for (int nextStation = 0; nextStation < n; nextStation++) {
                if (fatigue[currStation][nextStation] != Integer.MAX_VALUE && currTime + 1 <= maxTime) {
                    int nextFatigue = currFatigue + fatigue[currStation][nextStation];
                    if (nextFatigue < dp[nextStation][currTime+1]) {
                        dp[nextStation][currTime+1] = nextFatigue;
                        queue.offer(new int[]{nextStation, currTime+1, nextFatigue});
                    }
                }
            }
        }
    }

}