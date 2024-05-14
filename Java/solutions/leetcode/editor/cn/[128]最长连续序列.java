// 
// @Question: [128]最长连续序列 
// @Author: cwp0
// @CreatedTime: 2024-05-14 17:04:49
// @Description: 
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2087 👎 0

import java.util.HashSet;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        // 转化为HashSet
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;

        // 遍历set
        for (int num : set) {
            if (set.contains(num-1)) {
                // 如果可以找到num-1，则说明num不是最长序列的开头元素
                continue;
            }
            // 现在num是开头元素
            int len = 1;
            while (set.contains(num+1)) {
                len++;
                num += 1;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
