// 
// @Question: [3040]相同分数的最大操作数目 II 
// @Author: cwp0
// @CreatedTime: 2024-06-08 22:13:06
// @Description: 
//给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个： 
//
// 
// 选择 nums 中最前面两个元素并且删除它们。 
// 选择 nums 中最后两个元素并且删除它们。 
// 选择 nums 中第一个和最后一个元素并且删除它们。 
// 
//
// 一次操作的 分数 是被删除元素的和。 
//
// 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。 
//
// 请你返回按照上述要求 最多 可以进行的操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,2,3,4]
//输出：3
//解释：我们执行以下操作：
//- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
//- 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
//- 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
//由于 nums 为空，我们无法继续进行任何操作。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,6,1,4]
//输出：2
//解释：我们执行以下操作：
//- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
//- 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
//至多进行 2 次操作。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 记忆化搜索 数组 动态规划 👍 37 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;
    private int[][] memo;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n][n];
        int res1 = helper(2, n - 1, nums[0] + nums[1]); // 删除前两个数
        int res2 = helper(0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个数
        int res3 = helper(1, n - 2, nums[0] + nums[n - 1]); // 删除第一个和最后一个数
        return Math.max(Math.max(res1, res2), res3) + 1; // 加上第一次操作
    }

    private int helper(int i, int j, int target) {
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(i, j, target);
    }

    private int dfs(int i, int j, int target) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        if (nums[i] + nums[i + 1] == target) { // 删除前两个数
            res = Math.max(res, dfs(i + 2, j, target) + 1);
        }
        if (nums[j - 1] + nums[j] == target) { // 删除后两个数
            res = Math.max(res, dfs(i, j - 2, target) + 1);
        }
        if (nums[i] + nums[j] == target) { // 删除第一个和最后一个数
            res = Math.max(res, dfs(i + 1, j - 1, target) + 1);
        }
        return memo[i][j] = res; // 记忆化
    }
}
//leetcode submit region end(Prohibit modification and deletion)
