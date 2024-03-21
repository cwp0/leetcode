// 
// @Question: [322]零钱兑换 
// @Auther: cwp0
// @CreatedTime: 2024-03-15 21:37:48
// @Description: 
//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2734 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] memory;
    public int coinChange(int[] coins, int amount) {
        memory = new int[amount + 1];
        Arrays.fill(memory, -100);

        return dynamicProgramming(coins, amount);
    }

    private int dynamicProgramming(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memory[amount] != -100) return memory[amount];
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 子问题求解
            int subProblem = dynamicProgramming(coins, amount - coin);

            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);

        }
        memory[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memory[amount];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
