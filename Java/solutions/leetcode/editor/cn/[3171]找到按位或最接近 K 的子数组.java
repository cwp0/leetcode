// 
// @Question: [3171]找到按位或最接近 K 的子数组 
// @Author: cwp0
// @CreatedTime: 2024-10-09 21:41:56
// @Description: 
//给你一个数组 nums 和一个整数 k 。你需要找到 nums 的一个 子数组 ，满足子数组中所有元素按位或运算 OR 的值与 k 的 绝对差 尽可能 小 
//。换言之，你需要选择一个子数组 nums[l..r] 满足 |k - (nums[l] OR nums[l + 1] ... OR nums[r])| 最小。 
//
//
// 请你返回 最小 的绝对差值。 
//
// 子数组 是数组中连续的 非空 元素序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,4,5], k = 3 
// 
//
// 输出：0 
//
// 解释： 
//
// 子数组 nums[0..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 3| = 0 。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,3,1,3], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 nums[1..1] 的按位 OR 运算值为 3 ，得到最小差值 |3 - 2| = 1 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1], k = 10 
// 
//
// 输出：9 
//
// 解释： 
//
// 只有一个子数组，按位 OR 运算值为 1 ，得到最小差值 |10 - 1| = 9 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 位运算 线段树 数组 二分查找 👍 42 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.min(ans, Math.abs(x - k));
            // 如果 x 是 nums[j] 的子集，就退出循环
            for (int j = i - 1; j >= 0 && (nums[j] | x) != nums[j]; j--) {
                nums[j] |= x;
                ans = Math.min(ans, Math.abs(nums[j] - k));
            }
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
