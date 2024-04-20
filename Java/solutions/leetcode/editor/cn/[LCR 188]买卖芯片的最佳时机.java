// 
// @Question: [LCR 188]买卖芯片的最佳时机 
// @Author: cwp0
// @CreatedTime: 2024-04-18 12:49:09
// @Description: 
//数组 prices 记录了某芯片近期的交易价格，其中 prices[i] 表示的 i 天该芯片的价格。你只能选择 某一天 买入芯片，并选择在 未来的某一个不
//同的日子 卖出该芯片。请设计一个算法计算并返回你从这笔交易中能获取的最大利润。 
//
// 如果你不能获取任何利润，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [3, 6, 2, 9, 8, 5]
//输出：7
//解释：在第 3 天（芯片价格 = 2）买入，在第 4 天（芯片价格 = 9）卖出，最大利润 = 9 - 2 = 7。
// 
//
// 示例 2： 
//
// 
//输入：prices = [8, 12, 15, 7, 3, 10]
//输出：7
//解释：在第 5 天（芯片价格 = 3）买入，在第 6 天（芯片价格 = 10）卖出，最大利润 = 10 - 3 = 7。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= prices.length <= 10^5 
// 0 <= prices[i] <= 10^4 
// 
//
// 
//
// 注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-
//stock/ 
//
// 
//
// Related Topics 数组 动态规划 👍 380 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestTiming(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        // 定义dp[i][0] dp[i][1]分别为第i天未持有和持有芯片所能获得的最大利润
        int[][] dp = new int[n][2];

        // base case
        // 交易开始前未持有芯片所能获得的最大利润为0
        // dp[-1][0] = 0;
        // 交易开始前不可能持有芯片
        // dp[-1][1] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // dp[0][0] = Math.max(dp[-1][0], dp[-1][1] + prices[0]);
                dp[i][0] = 0;
                // dp[0][1] = Math.max(dp[-1][1], dp[-1][0] - prices[0]);
                dp[i][1] = -prices[i];
                continue;
            }
            // 第i天未持有芯片分两种情况
            // 1 在第i-1天就未持有芯片
            // 2 在第i-1天持有芯片，但是今天卖了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 第i天持有芯片分两种情况
            // 1 在第i-1天就持有芯片
            // 2 在第i-1天没有持有芯片，但是今天买了，此时k = 0,所以prices[i]前面的数字为0。
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
