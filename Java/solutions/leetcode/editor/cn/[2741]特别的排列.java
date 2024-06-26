// 
// @Question: [2741]特别的排列 
// @Author: cwp0
// @CreatedTime: 2024-06-26 17:01:00
// @Description: 
//给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列： 
//
// 
// 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] 
//== 0 。 
// 
//
// 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,6]
//输出：2
//解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
// 
//
// 示例 2： 
//
// 输入：nums = [1,4,3]
//输出：2
//解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 14 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 67 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int MOD = 1000000007;
    int[] nums;
    int n;
    int[][] f;

    public int specialPerm(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.f = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(f[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dfs((1 << n) - 1, i)) % MOD;
        }
        return res;
    }

    public int dfs(int state, int i) {
        if (f[state][i] != -1) {
            return f[state][i];
        }
        if (state == (1 << i)) {
            return 1;
        }
        f[state][i] = 0;
        for (int j = 0; j < n; j++) {
            if (i == j || (state >> j & 1) == 0) {
                continue;
            }
            if (nums[i] % nums[j] != 0 && nums[j] % nums[i] != 0) {
                continue;
            }
            f[state][i] = (f[state][i] + dfs(state ^ (1 << i), j)) % MOD;
        }
        return f[state][i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
