// 
// @Question: [LCR 090]打家劫舍 II 
// @Author: cwp0
// @CreatedTime: 2024-04-15 22:31:30
// @Description: 
//一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同
//时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 
// 注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/ 
//
// Related Topics 数组 动态规划 👍 63 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        memo = new int[n];
        Arrays.fill(memo, -1);

        // 三种情况
        // 1 盗窃第一间房子，不盗窃最后一间房子
        int first = dp(nums, 0, n - 1);
        // 每次执行后重置备忘录，因为备忘录结果会应为start和end不同而不同
        Arrays.fill(memo, -1);
        // 2 不盗窃第一间房子，盗窃最后一间房子
        int second = dp(nums, 1, n);
        Arrays.fill(memo, -1);
        // 3 第一间和最后一间都不盗窃
        int third = dp(nums, 1, n-1);
        return Math.max(Math.max(first, second), third);
    }

    // 定义dp(nums, start, end)为盗窃nums[start, end]所能获取的最高金额
    private int dp(int[] nums, int start, int end) {
        // base case
        if (start >= end) return 0;

        if (memo[start] != -1) return memo[start];

        int first = nums[start] + dp(nums, start + 2, end);
        int second = dp(nums, start + 1, end);
        int res = Math.max(first, second);
        memo[start] = res;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
