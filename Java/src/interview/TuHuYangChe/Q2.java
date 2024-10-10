package interview.TuHuYangChe;

/**
 * @Program: Java
 * @Package: interview.TuHuYangChe
 * @Class: Q2
 * @Description:
 * @Author: cwp0
 * @CreatedTime: 2024/10/10 19:07
 * @Version: 1.0
 */
public class Q2 {
    public static void main(String[] args) {

    }

    public int maxSpending (int[] costs, int budget) {
        // dp[i]表示预算为i时的最大花费
        int[] dp = new int[budget+1];

        for (int cost : costs) {
            for (int j = budget; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j-cost] + cost);
            }
        }

        return dp[budget];
    }
}