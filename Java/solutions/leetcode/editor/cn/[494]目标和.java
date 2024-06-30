// 
// @Question: [494]目标和 
// @Author: cwp0
// @CreatedTime: 2024-06-30 15:50:52
// @Description: 
//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1946 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // https://labuladong.online/algo/dynamic-programming/target-sum/#%E4%B8%89%E3%80%81%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
            return 0;
        }
        return subSets(nums, (sum + target) / 2);
    }
    // 计算nums中有几个子集的和为num
    private int subSets(int[] nums, int num) {
        int n = nums.length;
        // 定义dp[i][j]为 使用nums前i个数字是否可以凑出j
        int[][] dp = new int[n+1][num+1];
        // base case
        // 如果 nums的长度为0，则肯定凑不出来j，即dp[0][..] = 0，除了dp[0][0]
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= num; j++) {
                if (j < nums[i-1]) {
                    // 不能使用当前第i个数字
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][num];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
