// 
// @Question: [78]子集 
// @Author: cwp0
// @CreatedTime: 2024-08-15 13:14:54
// @Description: 
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2341 👎 0

import java.util.*;

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }
    private void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]); // 做选择
            backtrack(nums, i+1, track); // 回溯
            track.remove(track.size() - 1); // 撤销选择
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
