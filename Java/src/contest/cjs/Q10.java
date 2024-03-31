package contest.cjs;

import java.util.*;

/**
 * @Program: Java
 * @Package: contest.cjs
 * @Class: Q10
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/03/31 11:23
 * @Version: 1.0
 */
public class Q10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取目的地数量
        int N = scanner.nextInt();
        int[] destinations = new int[N];

        // 读取每个目的地的坐标
        for (int i = 0; i < N; i++) {
            destinations[i] = scanner.nextInt();
        }

        // 读取新车的续航和询问次数
        int L = scanner.nextInt();
        int Q = scanner.nextInt();

        // 处理查询
        for (int q = 0; q < Q; q++) {
            int li = scanner.nextInt();
            int ri = scanner.nextInt();

            // 计算从目的地 li 到 ri 最小需要多少天
            int minDays = calculateMinDays(destinations, L, li, ri);
            System.out.println(minDays);
        }

        scanner.close();
    }

    public static int calculateMinDays(int[] destinations, int L, int li, int ri) {
        int minDays = 0;
        int currentLocation = destinations[li - 1]; // 起点的位置
        int i = li;
        while(i < ri) {
            int dailyMaxLocation = currentLocation + L; // 每天能走的最远的路程

            int distance = Math.abs(destinations[i - 1] - currentLocation); // 计算当前目的地到下一个目的地的距离

            if (distance < dailyMaxLocation) {
                i++;
            } else {
                minDays++;
                i--;
                currentLocation = destinations[i-1];
            }

        }
        return minDays;
    }
}