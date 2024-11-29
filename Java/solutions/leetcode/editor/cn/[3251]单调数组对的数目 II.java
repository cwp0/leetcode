// 
// @Question: [3251]单调数组对的数目 II 
// @Author: cwp0
// @CreatedTime: 2024-11-29 13:04:27
// @Description: 
//给你一个长度为 n 的 正 整数数组 nums 。 
//
// 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对： 
//
// 
// 两个数组的长度都是 n 。 
// arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。 
// arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。 
// 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。 
// 
//
// 请你返回所有 单调 数组对的数目。 
//
// 由于答案可能很大，请你将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,3,2] 
// 
//
// 输出：4 
//
// 解释： 
//
// 单调数组对包括： 
//
// 
// ([0, 1, 1], [2, 2, 1]) 
// ([0, 1, 2], [2, 2, 0]) 
// ([0, 2, 2], [2, 1, 0]) 
// ([1, 2, 2], [1, 1, 0]) 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [5,5,5,5] 
// 
//
// 输出：126 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 2000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 数学 动态规划 组合数学 前缀和 👍 21 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countOfPairs(int[] nums) {
        int n = nums.length, m = 0, mod = 1000000007;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] dp = new int[n][m + 1];
        for (int a = 0; a <= nums[0]; a++) {
            dp[0][a] = 1;
        }
        for (int i = 1; i < n; i++) {
            int d = Math.max(0, nums[i] - nums[i - 1]);
            for (int j = d; j <= nums[i]; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j - d];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - d]) % mod;
                }
            }
        }
        int res = 0;
        for (int num : dp[n - 1]) {
            res = (res + num) % mod;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

