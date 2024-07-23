// 
// @Question: [3098]求出所有子序列的能量和 
// @Author: cwp0
// @CreatedTime: 2024-07-23 12:40:15
// @Description: 
//给你一个长度为 n 的整数数组 nums 和一个 正 整数 k 。 
//
// 一个 子序列 的 能量 定义为子序列中 任意 两个元素的差值绝对值的 最小值 。 
//
// 请你返回 nums 中长度 等于 k 的 所有 子序列的 能量和 。 
//
// 由于答案可能会很大，将答案对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,4], k = 3 
// 
//
// 输出：4 
//
// 解释： 
//
// nums 中总共有 4 个长度为 3 的子序列：[1,2,3] ，[1,3,4] ，[1,2,4] 和 [2,3,4] 。能量和为 |2 - 3| + |
//3 - 4| + |2 - 1| + |3 - 4| = 4 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,2], k = 2 
// 
//
// 输出：0 
//
// 解释： 
//
// nums 中唯一一个长度为 2 的子序列是 [2,2] 。能量和为 |2 - 2| = 0 。 
//
// 示例 3： 
//
// 
// 输入：nums = [4,3,-1], k = 2 
// 
//
// 输出：10 
//
// 解释： 
//
// nums 总共有 3 个长度为 2 的子序列：[4,3] ，[4,-1] 和 [3,-1] 。能量和为 |4 - 3| + |4 - (-1)| + |3
// - (-1)| = 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= n == nums.length <= 50 
// -10⁸ <= nums[i] <= 10⁸ 
// 2 <= k <= n 
// 
//
// Related Topics 数组 动态规划 排序 👍 25 👎 0

import java.util.Arrays;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int MOD = 1000000007, INF = 0x3f3f3f3f;

    public int sumOfPowers(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[][] d = new Map[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                d[i][j] = new HashMap<Integer, Integer>();
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            d[i][1].put(INF, 1);
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                for (int p = 2; p <= k; p++) {
                    for (Map.Entry<Integer, Integer> entry : d[j][p - 1].entrySet()) {
                        int v = entry.getKey(), cnt = entry.getValue();
                        int currKey = Math.min(diff, v);
                        d[i][p].put(currKey, (d[i][p].getOrDefault(currKey, 0) + cnt) % MOD);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : d[i][k].entrySet()) {
                int v = entry.getKey(), cnt = entry.getValue();
                res = (int) ((res + 1L * v * cnt % MOD) % MOD);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
