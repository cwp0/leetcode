// 
// @Question: [LCR 102]目标和 
// @Author: cwp0
// @CreatedTime: 2024-04-06 14:29:20
// @Description: 
//给定一个正整数数组 nums 和一个整数 target 。 
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
// 
//
// 
// 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/ 
//
// Related Topics 数组 动态规划 回溯 👍 75 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashMap<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return backtrace(nums, 0, target);
    }

    // 回溯法，并使用备忘录消除重叠子问题
    private int backtrace(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) {
                return 1;
            }
            return 0;
        }

        String key = i + "," + remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int res = backtrace(nums, i+1, remain-nums[i]) + backtrace(nums, i+1, remain+nums[i]);
        memo.put(key, res);
        return res;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
