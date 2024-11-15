// 
// @Question: [228]汇总区间 
// @Author: cwp0
// @CreatedTime: 2024-11-15 12:56:03
// @Description: 
//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
//
// Related Topics 数组 👍 411 👎 0

// 时间复杂度：O()
// 空间复杂度：O()
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
class Solution {
    public List<String> summaryRanges(int[] nums) {
        // 创建一个列表用于存储结果
        List<String> result = new ArrayList<>();

        // 如果输入数组为空，直接返回空列表
        if (nums.length == 0) return result;

        // 初始化起始点，起始点为数组的第一个数字
        int start = nums[0];

        // 遍历数组中的每一个元素
        for (int i = 1; i <= nums.length; i++) {
            // 判断当前数字是否与前一个数字连续（即 nums[i] == nums[i-1] + 1）
            // 或者当前已经是数组的最后一个元素
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // 创建一个区间的列表来记录当前的区间
                // List<Integer> range = new ArrayList<>();
                // 将起始点添加到区间中
                // range.add(start);
                String range = Integer.toString(start);

                // 如果区间的起始点和结束点不同，表示这是一个包含多个数字的区间
                if (i - 1 > 0 && nums[i - 1] != start) {
                    // 添加区间的结束点
                    // range.add(nums[i - 1]);
                    range = range + "->" + Integer.toString(nums[i-1]);
                }

                // 将当前区间添加到结果列表中
                result.add(range);

                // 如果当前不是数组的最后一个元素，更新起始点为当前的数字
                if (i < nums.length) start = nums[i];
            }
        }

        // 返回最终的结果列表
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
