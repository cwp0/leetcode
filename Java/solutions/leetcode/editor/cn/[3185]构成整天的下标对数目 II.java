// 
// @Question: [3185]构成整天的下标对数目 II 
// @Author: cwp0
// @CreatedTime: 2024-10-23 19:13:13
// @Description: 
//给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标
//对 i, j 的数目。 
//
// 整天 定义为时间持续时间是 24 小时的 整数倍 。 
//
// 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。 
//
// 
//
// 示例 1： 
//
// 
// 输入： hours = [12,12,30,24,24] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1) 和 (3, 4)。 
//
// 示例 2： 
//
// 
// 输入： hours = [72,48,24,3] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 5 * 10⁵ 
// 1 <= hours[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 计数 👍 26 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        final int H = 24;
        long ans = 0;
        int[] cnt = new int[H];
        for (int t : hours) {
            // 先查询 cnt，再更新 cnt，因为题目要求 i < j
            // 如果先更新，再查询，就把 i = j 的情况也考虑进去了
            ans += cnt[(H - t % H) % H];
            cnt[t % H]++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
