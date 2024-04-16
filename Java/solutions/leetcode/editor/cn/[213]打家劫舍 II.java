// 
// @Question: [213]打家劫舍 II 
// @Author: cwp0
// @CreatedTime: 2024-04-15 22:31:07
// @Description: 
//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
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
//输入：nums = [1,2,3]
//输出：3
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
// Related Topics 数组 动态规划 👍 1580 👎 0

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

        // 分三种情况：
        // 1. 盗窃第一间房子，不盗窃第二间房子
        // 2. 不盗窃第一间房子，盗窃第二间房子
        // 3. 两间房子都没有被盗窃
        int first = dp(nums, 0, n-1);
        // 不同的startIndex和endIndex会让备忘录中的值不一样，所以每次dp重置备忘录。
        Arrays.fill(memo, -1);
        int second = dp(nums, 1, n);
        Arrays.fill(memo, -1);
        // 这种情况肯定比前两种情况小，所以可以不计算
        // int third = dp(nums, 1, n-1);
        return Math.max(first, second);

    }


    // dp(nums, startIndex)表示盗窃nums[startIndex..]的房子得到的最高金额
    private int dp(int[] nums, int startIndex, int endIndex) {
        // base case
        // 如果startIndex大于数组的长度，则没有房子可以盗窃
        if (startIndex >= endIndex) return 0;

        if (memo[startIndex] != -1) return memo[startIndex];

        // 第一种情况，盗窃startIndex房子，则startIndex+1不能盗窃
        int first = nums[startIndex] + dp(nums, startIndex + 2, endIndex);
        // 第二种情况，不盗窃startIndex房子，则可以从startIndex+1开始盗窃
        int second = dp(nums, startIndex + 1, endIndex);

        int res = Math.max(first, second);

        memo[startIndex] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
