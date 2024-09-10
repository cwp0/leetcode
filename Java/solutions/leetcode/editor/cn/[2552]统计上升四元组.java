// 
// @Question: [2552]统计上升四元组 
// @Author: cwp0
// @CreatedTime: 2024-09-10 20:31:44
// @Description: 
//给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。 
//
// 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的： 
//
// 
// 0 <= i < j < k < l < n 且 
// nums[i] < nums[k] < nums[j] < nums[l] 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,2,4,5]
//输出：2
//解释：
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//没有其他的四元组，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4]
//输出：0
//解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 4000 
// 1 <= nums[i] <= nums.length 
// nums 中所有数字 互不相同 ，nums 是一个排列。 
// 
//
// Related Topics 树状数组 数组 动态规划 枚举 前缀和 👍 78 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][] great = new int[n][n + 1];
        for (int k = n - 2; k >= 2; k--) {
            great[k] = great[k + 1].clone();
            for (int x = 1; x < nums[k + 1]; x++) {
                great[k][x]++;
            }
        }

        long ans = 0;
        int[] less = new int[n + 1];
        for (int j = 1; j < n - 2; j++) {
            for (int x = nums[j - 1] + 1; x <= n; x++) {
                less[x]++;
            }
            for (int k = j + 1; k < n - 1; k++) {
                if (nums[j] > nums[k]) {
                    ans += less[nums[k]] * great[k][nums[j]];
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
