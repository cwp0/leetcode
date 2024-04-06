// 
// @Question: [494]目标和 
// @Author: cwp0
// @CreatedTime: 2024-04-06 14:25:41
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
// Related Topics 数组 动态规划 回溯 👍 1894 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrace(nums, 0, target);
        return res;
    }

    // 回溯
    private void backtrace(int[] nums, int i, int remain) {
        if (i == nums.length) {
            // 如果i到达nums的长度，则证明匹配结束，remain如果为0，则结果+1
            if (remain == 0) {
                res++;
            }
            return ;
        }

        // 第i个数字添加+号
        remain -= nums[i];
        // 使用回溯穷举所有可能结果
        backtrace(nums, i+1, remain);
        // 撤销对第i个数的操作
        remain += nums[i];


        // 第i个数字添加-号
        remain += nums[i];
        // 使用回溯穷举所有可能结果
        backtrace(nums, i+1, remain);
        // 撤销对第i个数的操作
        remain -= nums[i];

    }

}
//leetcode submit region end(Prohibit modification and deletion)
