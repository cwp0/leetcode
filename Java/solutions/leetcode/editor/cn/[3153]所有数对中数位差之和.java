// 
// @Question: [3153]所有数对中数位差之和 
// @Author: cwp0
// @CreatedTime: 2024-08-30 21:01:59
// @Description: 
//你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。 
//
// 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。 
//
// 请你返回 nums 中 所有 整数对里，数位差之和。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [13,23,12] 
// 
//
// 输出：4 
//
// 解释： 计算过程如下： - 13 和 23 的数位差为 1 。 - 13 和 12 的数位差为 1 。 - 23 和 12 的数位差为 2 。 所以所有整
//数数对的数位差之和为 1 + 1 + 2 = 4 。 
//
// 示例 2： 
//
// 
// 输入：nums = [10,10,10,10] 
// 
//
// 输出：0 
//
// 解释： 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] < 10⁹ 
// nums 中的整数都有相同的数位长度。 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 44 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        int n = nums.length;
        while (nums[0] > 0) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                cnt[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; i++) {
                res += (long) (n - cnt[i]) * cnt[i];
            }
        }
        return res / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
