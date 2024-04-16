// 
// @Question: [198]打家劫舍 
// @Author: cwp0
// @CreatedTime: 2024-04-15 22:31:04
// @Description: 
//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2970 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    // 定义dp(nums, index)为抢夺nums[index..]所能够盗窃到的最高金额
    private int dp(int[] nums, int index) {
        // base case
        if (index >= nums.length) return 0;

        if (memo[index] != -1) return memo[index];

        // 状态转移函数
        // 第一种选择，如果在当前index盗窃，则不能在index+1盗窃
        int first = nums[index] + dp(nums, index + 2);
        // 第二种选择，如果不在当前index盗窃，则可以在index+1盗窃
        int second = dp(nums, index+1);

        int res = Math.max(first, second);
        memo[index] = res;

        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
