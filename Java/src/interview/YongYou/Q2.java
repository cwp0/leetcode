package interview.YongYou;

/**
 * @Program: Java
 * @Package: interview.YongYou
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/16 19:03
 * @Version: 1.0
 */
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] roomCapacities = new int[m];
        for (int i = 0; i < m; i++) {
            roomCapacities[i] = scanner.nextInt();
        }

        int totalCapacity = 0;
        for (int cap : roomCapacities) {
            totalCapacity += cap;
        }

        int maxTime = 0;
        int[][] schedules = new int[n][3];
        for (int i = 0; i < n; i++) {
            schedules[i][0] = scanner.nextInt();
            schedules[i][1] = scanner.nextInt();
            schedules[i][2] = scanner.nextInt();
            maxTime = Math.max(maxTime, schedules[i][1]);
        }

        int[] timeLine = new int[maxTime + 1];

        for (int i = 0; i < n; i++) {
            int startTime = schedules[i][0];
            int endTime = schedules[i][1];
            int num = schedules[i][2];

            for (int t = startTime; t < endTime; t++) {
                timeLine[t] += num;
            }

        }

        for (int t = 0; t <= maxTime; t++) {
            if (timeLine[t] > totalCapacity) {
                System.out.println("false");
                return;
            }
        }


        System.out.println("true");
    }
}