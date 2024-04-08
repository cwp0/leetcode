// 
// @Question: [2009]使数组连续的最少操作数 
// @Author: cwp0
// @CreatedTime: 2024-04-08 21:41:11
// @Description: 
//给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。 
//
// 如果 nums 满足以下条件，那么它是 连续的 ： 
//
// 
// nums 中所有元素都是 互不相同 的。 
// nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。 
// 
//
// 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。 
//
// 请你返回使 nums 连续 的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,2,5,3]
//输出：0
//解释：nums 已经是连续的了。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,5,6]
//输出：1
//解释：一个可能的解是将最后一个元素变为 4 。
//结果数组为 [1,2,3,5,4] ，是连续数组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,10,100,1000]
//输出：3
//解释：一个可能的解是：
//- 将第二个元素变为 2 。
//- 将第三个元素变为 3 。
//- 将第四个元素变为 4 。
//结果数组为 [1,2,3,4] ，是连续数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 滑动窗口 👍 84 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/solutions/1005398/on-zuo-fa-by-endlesscheng-l7yi
    public int minOperations(int[] nums) {

        // 正难则反，考虑最多保留多少个元素不变。

        Arrays.sort(nums);
        int n = nums.length;
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) {
                nums[m++] = nums[i]; // 原地去重
            }
        }
        // m为原地去重后的数组长度
        // 滑动窗口：寻找最多有多少个去重后的数字留在窗口中，然后其他不在窗口中的数字都需要替换
        int ans = 0;
        int left = 0;
        for (int i = 0; i < m; i++) {
            // 滑动窗口的长度为n
            while (nums[left] < nums[i] - n + 1) {
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return n - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
