// 
// @Question: [714]买卖股票的最佳时机含手续费 
// @Author: cwp0
// @CreatedTime: 2024-04-18 12:48:52
// @Description: 
//给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
//
// 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
//
// 返回获得利润的最大值。 
//
// 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
//输出：8
//解释：能够达到的最大利润:  
//在此处买入 prices[0] = 1
//在此处卖出 prices[3] = 8
//在此处买入 prices[4] = 4
//在此处卖出 prices[5] = 9
//总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
//
// 示例 2： 
//
// 
//输入：prices = [1,3,7,5,10,3], fee = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5 * 10⁴ 
// 1 <= prices[i] < 5 * 10⁴ 
// 0 <= fee < 5 * 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1052 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // 定义dp[i][0] dp[i][1]分别为在第i天未持有和持有股票所能获得的最大利润
        int[][] dp = new int[n][2];

        // base case
        // 在开始前未持有股票所获的最大利润为0
        // dp[-1][0] = 0;
        // 在开始前不可能持有股票
        // dp[-1][1] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // dp[0][0] = Math.max(dp[-1][0], dp[-1][1] + prices[0]);
                dp[0][0] = 0;
                // dp[0][1] = Math.max(dp[-1][1], dp[-1][0] - prices[0] - fee);
                dp[0][1] = - prices[0] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 2 昨天没有持有，今天买入股票，然后减去手续费。
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[n-1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
