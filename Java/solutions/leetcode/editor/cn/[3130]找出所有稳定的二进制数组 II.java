// 
// @Question: [3130]找出所有稳定的二进制数组 II 
// @Author: cwp0
// @CreatedTime: 2024-08-07 11:12:43
// @Description: 
//给你 3 个正整数 zero ，one 和 limit 。 
//
// 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ： 
//
// 
// 0 在 arr 中出现次数 恰好 为 zero 。 
// 1 在 arr 中出现次数 恰好 为 one 。 
// arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。 
// 
//
// 请你返回 稳定 二进制数组的 总 数目。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：zero = 1, one = 1, limit = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 两个稳定的二进制数组为 [1,0] 和 [0,1] ，两个数组都有一个 0 和一个 1 ，且没有子数组长度大于 2 。 
//
// 示例 2： 
//
// 
// 输入：zero = 1, one = 2, limit = 1 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一稳定的二进制数组是 [1,0,1] 。 
//
// 二进制数组 [1,1,0] 和 [0,1,1] 都有长度为 2 且元素全都相同的子数组，所以它们不稳定。 
//
// 示例 3： 
//
// 
// 输入：zero = 3, one = 3, limit = 2 
// 
//
// 输出：14 
//
// 解释： 
//
// 所有稳定的二进制数组包括 [0,0,1,0,1,1] ，[0,0,1,1,0,1] ，[0,1,0,0,1,1] ，[0,1,0,1,0,1] ，[0,1
//,0,1,1,0] ，[0,1,1,0,0,1] ，[0,1,1,0,1,0] ，[1,0,0,1,0,1] ，[1,0,0,1,1,0] ，[1,0,1,0,
//0,1] ，[1,0,1,0,1,0] ，[1,0,1,1,0,0] ，[1,1,0,0,1,0] 和 [1,1,0,1,0,0] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= zero, one, limit <= 1000 
// 
//
// Related Topics 动态规划 前缀和 👍 23 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int MOD = 1000000007;
    int[][][] memo;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.memo = new int[zero + 1][one + 1][2];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        this.limit = limit;
        return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD;
    }

    public int dp(int zero, int one, int lastBit) {
        if (zero == 0) {
            return (lastBit == 0 || one > limit) ? 0 : 1;
        } else if (one == 0) {
            return (lastBit == 1 || zero > limit) ? 0 : 1;
        }

        if (memo[zero][one][lastBit] == -1) {
            int res = 0;
            if (lastBit == 0) {
                res = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1))% MOD;
                if (zero > limit) {
                    res = (res - dp(zero - limit - 1, one, 1) + MOD) % MOD;
                }
            } else {
                res = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD;
                if (one > limit) {
                    res = (res - dp(zero, one - limit - 1, 0) + MOD) % MOD;
                }
            }
            memo[zero][one][lastBit] = res % MOD;
        }
        return memo[zero][one][lastBit];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
