// 
// @Question: [LCR 101]分割等和子集 
// @Author: cwp0
// @CreatedTime: 2024-04-05 15:22:25
// @Description: 
//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
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
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
//
// Related Topics 数学 字符串 模拟 👍 95 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;

        sum = sum / 2;

        // 定义dp[i][j]为nums中前i个数能否组合成j
        boolean[][] dp = new boolean[n+1][sum+1];

        //base case
        // dp[0][j] = false;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // 状态转移函数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // 如果剩余的数j小于当前nums中数字大小，则不能被凑出，不使用当前数字
                if (j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 如果j大于等于nums中的当前数字
                    // 前i-1个数是否可以凑齐j || 使用第i个数后，前i-1个数是否可以凑齐j-nums[i-1]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }


        return dp[n][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
