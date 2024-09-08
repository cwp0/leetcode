package interview.MiHoYo.Autumn;

/**
 * @Program: Java
 * @Package: interview.MiHoYo.Autumn
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/09/07 16:01
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    static int n, m;
    static int[] extraReward;
    static int[][] rewards, sources;
    static int maxAbility = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        extraReward = new int[m];
        for (int i = 0; i < m; i++) {
            extraReward[i] = scanner.nextInt();
        }
        rewards = new int[n][3];
        sources = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                rewards[i][j] = scanner.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                sources[i][j] = scanner.nextInt() - 1; // 对应数组的索引
            }
        }
        int[] counts = new int[m]; // 英灵加成次数
        dfs(0, counts, 0);
        System.out.println(maxAbility);
    }

    private static void dfs(int level, int[] counts, int sum) {
        if (level == n) {
            for (int i = 0; i < m; i++) {
                if (counts[i] >= 3) {
                    sum += extraReward[i];
                }
            }
            maxAbility = Math.max(maxAbility, sum);
            return ;
        }

        // 关卡的3种选择
        for (int i = 0; i < 3; i++) {
            int temp = sources[level][i];
            counts[temp]++;
            dfs(level+1, counts, sum + rewards[level][i]);
            // 回溯
            counts[temp]--;
        }

    }
}