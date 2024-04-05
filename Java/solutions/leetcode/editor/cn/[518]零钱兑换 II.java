// 
// @Question: [518]零钱兑换 II 
// @Author: cwp0
// @CreatedTime: 2024-03-25 11:16:44
// @Description: 
//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
//
// Related Topics 数组 动态规划 👍 1256 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 定义dp[i][j]为只使用coins中前i个硬币可以凑出的硬币组合数
        int[][] dp = new int[n+1][amount+1];

        // base case
        // 金币数为0 时，除了0意外，任何数量都抽不出来dp[0][i] = 0
        // 要凑出的金额为0时，只能有一种办法，那就是不使用任何金币
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 状态转移函数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i-1]) {
                    //  如果剩余的金额硬币值小于第i个硬币值，则不能凑出，不使用该硬币值
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 不使用第i枚硬币凑出j的组合数+使用前i枚硬币凑出j-coins[i-1]的组合数？
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[n][amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
