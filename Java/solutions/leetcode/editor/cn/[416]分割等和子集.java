// 
// @Question: [416]分割等和子集 
// @Author: cwp0
// @CreatedTime: 2024-04-05 15:22:08
// @Description: 
//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2047 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 如果和为奇数，则不能平分
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum/2;
        // 定义dp[i][j]为nums中前i个数是否可以拼凑出sum
        boolean[][] dp = new boolean[n+1][sum+1];

        // base case
        // 前0个的话，没有数字可以拼凑出num，dp[0][..] = false
        // 如果背包为0，不管任何数字，不使用就可以填满
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // 状态转移函数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 如果容量不足，不能装入第i个物品
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 不装入 || 装入第i个物品
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }


        return dp[n][sum]; // sum已经除以2了。
    }
}
//leetcode submit region end(Prohibit modification and deletion)
