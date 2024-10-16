package interview.YongYou;

/**
 * @Program: Java
 * @Package: interview.YongYou
 * @Class: Q4
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/16 19:03
 * @Version: 1.0
 */
import java.util.*;
public class Q4 {
    static class Item {
        int startTime, sellTime, benefit, endTime;
        public Item(int startTime, int sellTime, int benefit) {
            this.startTime = startTime;
            this.sellTime = sellTime;
            this.benefit = benefit;
            this.endTime = startTime + sellTime;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        int[] sellTime = new int[n];
        int[] benefit = new int[n];

        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sellTime[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            benefit[i] = scanner.nextInt();
        }

        System.out.println(getMaxProfit(n, startTime, sellTime, benefit));

    }

    public static int getMaxProfit(int n, int[] startTime, int[] sellTime, int[] benefit) {
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(startTime[i], sellTime[i], benefit[i]);
        }

        Arrays.sort(items, Comparator.comparingInt(a -> a.endTime));

        int[] dp = new int[n];
        dp[0] = items[0].benefit;

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1];

            int lastIndex = binarySearch(items, i);
            if (lastIndex != -1) {
                dp[i] = Math.max(dp[i], dp[lastIndex] + items[i].benefit);
            } else {
                dp[i] = Math.max(dp[i], items[i].benefit);
            }
        }
        return dp[n-1];
    }

    private static int binarySearch(Item[] items, int i) {
        int left = 0, right = i - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (items[mid].endTime <= items[i].startTime) {
                if (items[mid+1].endTime <= items[i].startTime) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}