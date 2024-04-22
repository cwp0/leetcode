// 
// @Question: [377]组合总和 Ⅳ 
// @Author: cwp0
// @CreatedTime: 2024-04-22 21:56:17
// @Description: 
//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 991 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(target, nums, memo);
    }

    private int dfs(int i, int[] nums, int[] memo) {
        if (i == 0) { // 爬完了
            return 1;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res = 0;
        for (int x : nums) { // 枚举所有可以爬的台阶数
            if (x <= i) {
                res += dfs(i - x, nums, memo);
            }
        }
        return memo[i] = res; // 记忆化
    }
}
//leetcode submit region end(Prohibit modification and deletion)
